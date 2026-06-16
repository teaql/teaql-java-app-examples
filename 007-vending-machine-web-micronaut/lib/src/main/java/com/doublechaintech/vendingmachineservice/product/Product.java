package com.doublechaintech.vendingmachineservice.product;

import com.doublechaintech.vendingmachineservice.vendingmachine.VendingMachine;
import com.doublechaintech.vendingmachineservice.vendingorderitem.VendingOrderItem;
import io.teaql.core.Audited;
import io.teaql.core.BaseEntity;
import io.teaql.core.EntityStatus;
import io.teaql.core.FrameworkInternal;
import io.teaql.core.RemoteInput;
import io.teaql.core.SmartList;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * [TEAQL AI WARNING]
 * TeaQL was explicitly designed to PREVENT AI hallucinations and random guessing.
 * DO NOT GUESS METHOD NAMES!
 * The methods listed below are the ONLY valid ways to interact with this entity.
 * If you encounter compilation errors (e.g., method not found), DO NOT guess another method name.
 * Read the method signatures in this file before proceeding.
 */
public class Product extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "Product";

    public static final String NAME_PROPERTY = "name";
    public static final String PRICE_PROPERTY = "price";
    public static final String STOCK_PROPERTY = "stock";
    public static final String IMAGE_URL_PROPERTY = "imageUrl";
    public static final String VENDING_MACHINE_PROPERTY = "vendingMachine";
    public static final String CREATE_TIME_PROPERTY = "createTime";
    public static final String UPDATE_TIME_PROPERTY = "updateTime";
    public static final String VENDING_ORDER_ITEM_LIST_PROPERTY = "vendingOrderItemList";
    private String name;
    private Integer price;
    private Integer stock;
    private String imageUrl;
    private VendingMachine vendingMachine;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private SmartList<VendingOrderItem> vendingOrderItemList;

    public String getName(){
        return this.name;
    }
    public Integer getPrice(){
        return this.price;
    }
    public Integer getStock(){
        return this.stock;
    }
    public String getImageUrl(){
        return this.imageUrl;
    }
    public VendingMachine getVendingMachine(){
        return this.vendingMachine;
    }
    public LocalDateTime getCreateTime(){
        return this.createTime;
    }
    public LocalDateTime getUpdateTime(){
        return this.updateTime;
    }
    public SmartList<VendingOrderItem> getVendingOrderItemList(){
        return this.vendingOrderItemList;
    }
    public Product updateName(String name){
        name = (name == null ? null : name.trim());
        if(Objects.equals(this.name, name)){
            return this;
        }
        handleUpdate(NAME_PROPERTY, getName(), name);
        this.name = name;
        return this;
    }
    public Product updatePrice(Integer price){
        if(Objects.equals(this.price, price)){
            return this;
        }
        handleUpdate(PRICE_PROPERTY, getPrice(), price);
        this.price = price;
        return this;
    }
    public Product updateStock(Integer stock){
        if(Objects.equals(this.stock, stock)){
            return this;
        }
        handleUpdate(STOCK_PROPERTY, getStock(), stock);
        this.stock = stock;
        return this;
    }
    public Product updateImageUrl(String imageUrl){
        imageUrl = (imageUrl == null ? null : imageUrl.trim());
        if(Objects.equals(this.imageUrl, imageUrl)){
            return this;
        }
        handleUpdate(IMAGE_URL_PROPERTY, getImageUrl(), imageUrl);
        this.imageUrl = imageUrl;
        return this;
    }
    public Product updateVendingMachine(VendingMachine vendingMachine){
        if(Objects.equals(this.vendingMachine, vendingMachine)){
            return this;
        }
        handleUpdate(VENDING_MACHINE_PROPERTY, getVendingMachine(), vendingMachine);
        this.vendingMachine = vendingMachine;
        return this;
    }
    public Product updateCreateTime(LocalDateTime createTime){
        if(Objects.equals(this.createTime, createTime)){
            return this;
        }
        handleUpdate(CREATE_TIME_PROPERTY, getCreateTime(), createTime);
        this.createTime = createTime;
        return this;
    }
    public Product updateUpdateTime(LocalDateTime updateTime){
        if(Objects.equals(this.updateTime, updateTime)){
            return this;
        }
        handleUpdate(UPDATE_TIME_PROPERTY, getUpdateTime(), updateTime);
        this.updateTime = updateTime;
        return this;
    }
    public Product addVendingOrderItem(VendingOrderItem vendingOrderItem){
        if (vendingOrderItem == null){
            return this;
        }

        if(null == this.vendingOrderItemList){
            this.vendingOrderItemList = new SmartList<>();
        }

        this.vendingOrderItemList.add(vendingOrderItem);
        vendingOrderItem.cacheRelation(VendingOrderItem.PRODUCT_PROPERTY, this);
        return this;
    }

    public static Product refer(Long id){
        Product refer = new Product();
        refer.internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public Product comment(String comment){
        this.setComment(comment);
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Audited<Product> auditAs(String action) {
        return super.auditAs(action);
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void internalSet(String property, Object value) {
        switch (property) {
            case "name": this.name = (value == null ? null : ((String)value).trim()); break;

            case "price": this.price = (Integer) value; break;

            case "stock": this.stock = (Integer) value; break;

            case "imageUrl": this.imageUrl = (value == null ? null : ((String)value).trim()); break;

            case "vendingMachine": this.vendingMachine = (VendingMachine) value; break;

            case "createTime": this.createTime = (LocalDateTime) value; break;

            case "updateTime": this.updateTime = (LocalDateTime) value; break;

            case "vendingOrderItemList": this.vendingOrderItemList = (SmartList<VendingOrderItem>) value; break;
            default: super.internalSet(property, value);
        }
    }

    @Override
    @FrameworkInternal
    public Object internalGet(String property) {
        switch (property) {
            case "name": return this.name;
            case "price": return this.price;
            case "stock": return this.stock;
            case "imageUrl": return this.imageUrl;
            case "vendingMachine": return this.vendingMachine;
            case "createTime": return this.createTime;
            case "updateTime": return this.updateTime;
            case "vendingOrderItemList": return this.vendingOrderItemList;
            default: return super.internalGet(property);
        }
    }

}