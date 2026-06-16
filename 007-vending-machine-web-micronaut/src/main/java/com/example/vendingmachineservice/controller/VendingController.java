package com.example.vendingmachineservice.controller;

import com.example.vendingmachineservice.Q;
import com.example.vendingmachineservice.product.Product;
import com.example.vendingmachineservice.vendingorder.VendingOrder;
import com.example.vendingmachineservice.vendingorderitem.VendingOrderItem;
import com.example.vendingmachineservice.orderpayment.OrderPayment;
import io.teaql.core.SmartList;
import io.teaql.core.UserContext;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.QueryValue;
import jakarta.inject.Inject;

@Controller("/api/vending")
public class VendingController {

    @Inject
    UserContext userContext;

    @Get("/products")
    public SmartList<Product> getProductList() {
        return Q.products()
                .comment("Get all products")
                .purpose("Display product list to user")
                .executeForList(userContext);
    }

    @Post("/cart/add")
    public VendingOrder addToCart(@QueryValue(defaultValue = "") Long orderId,
                                  @QueryValue Long productId,
                                  @QueryValue int quantity) {
        VendingOrder order;
        if (orderId == null) {
            order = new VendingOrder();
            order.updateTitle("Order-" + System.currentTimeMillis());
            order.updateTotalAmount(0);
            order.updateStatusToPending();
            order.auditAs("Create new cart").save(userContext);
        } else {
            order = Q.vendingOrders()
                    .withIdIs(orderId)
                    .comment("Find order")
                    .purpose("Add item to existing cart")
                    .executeForOne(userContext);
        }

        Product product = Q.products()
                .withIdIs(productId)
                .comment("Find product")
                .purpose("Calculate price for cart item")
                .executeForOne(userContext);

        VendingOrderItem item = new VendingOrderItem();
        item.updateName(product.getName() + " x " + quantity);
        item.updateVendingOrder(order);
        item.updateProduct(product);
        item.updateQuantity(quantity);
        item.updatePrice(product.getPrice());
        item.updateAmount(product.getPrice() * quantity);
        item.auditAs("Add item to cart").save(userContext);

        order.updateTotalAmount(order.getTotalAmount() + item.getAmount());
        order.auditAs("Update order total").save(userContext);

        return order;
    }

    @Post("/checkout")
    public OrderPayment checkout(@QueryValue Long orderId) {
        VendingOrder order = Q.vendingOrders()
                .withIdIs(orderId)
                .comment("Find order")
                .purpose("Checkout")
                .executeForOne(userContext);

        order.updateStatusToPaid();
        order.auditAs("Mark order as paid").save(userContext);

        OrderPayment payment = new OrderPayment();
        payment.updateName("Payment for " + order.getTitle());
        payment.updateVendingOrder(order);
        payment.updatePaymentMethodToGooglePay();
        payment.updatePaymentStatusToSuccess();
        payment.updateAmount(order.getTotalAmount());
        payment.updateTransactionId("TX-" + System.currentTimeMillis());
        payment.auditAs("Create payment record").save(userContext);

        return payment;
    }

    @Get("/orders")
    public SmartList<VendingOrder> getOrderList() {
        return Q.vendingOrders()
                .comment("Get all orders")
                .purpose("Display order list")
                .executeForList(userContext);
    }
}
