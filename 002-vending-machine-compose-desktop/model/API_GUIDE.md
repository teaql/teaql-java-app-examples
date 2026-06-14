# TeaQL API Guide

Generated for `com.doublechaintech.vendingmachineservice`. Domain: **vending-machine-service**.

---

## Part 1 — API Rules

### 1.1 Query Chain

Every query follows this chain:

```java
var list = Q.vendingMachines()
    .filterByXxx(value)            // optional filters
    .selectSelf()                  // select own fields
    .comment("what this loads")    // REQUIRED — describe what query loads
    .purpose("why it is needed")   // REQUIRED — describe why data is needed
    .executeForList(ctx);          // terminal: returns SmartList
```

Single-object variant:

```java
var entity = Q.vendingMachines()
    .filterById(id)
    .selectSelf()
    .comment("load single entity")
    .purpose("display detail page")
    .executeForOne(ctx);
```

Pagination:

```java
var page = Q.vendingMachines()
    .selectSelf()
    .page(1, 20)
    .comment("page listing")
    .purpose("list view")
    .executeForList(ctx);
```

### 1.2 Filter Operators

#### String Filters

| Method | SQL Equivalent |
|--------|---------------|
| `.<prefix>Name(value)` | `= value` |
| `.<prefix>NameIsNull()` | `IS NULL` |
| `.<prefix>NameIsNotNull()` | `IS NOT NULL` |
| `.<prefix>NameIsEmpty()` | `= ''` |
| `.<prefix>NameNot(value)` | `<> value` |
| `.<prefix>NameContain<suffix>(text)` | `LIKE '%text%'` |
| `.<prefix>NameStartWith(text)` | `LIKE 'text%'` |
| `.<prefix>NameEndWith(text)` | `LIKE '%text'` |
| `.<prefix>NameIn(list)` | `IN (...)` |
| `.<prefix>NameNotIn(list)` | `NOT IN (...)` |
| `.<prefix>NameMatchPattern(pattern)` | `LIKE pattern` |

> `<prefix>` is `whose` for Human entities, `with` for Thing entities.
> `<suffix>` is `s` for Human entities, `ing` for Thing entities.

#### Number Filters

| Method | SQL Equivalent |
|--------|---------------|
| `.<prefix>Age(value)` | `= value` |
| `.<prefix>AgeGreaterThan(n)` | `> n` |
| `.<prefix>AgeLessThan(n)` | `< n` |
| `.<prefix>AgeBetween(min, max)` | `BETWEEN min AND max` |
| `.<prefix>AgeIn(list)` | `IN (...)` |

#### DateTime Filters

| Method | SQL Equivalent |
|--------|---------------|
| `.<prefix>CreateTime(value)` | `= value` |
| `.<prefix>CreateTimeGreaterThan(dt)` | `> dt` |
| `.<prefix>CreateTimeLessThan(dt)` | `< dt` |
| `.<prefix>CreateTimeBetween(from, to)` | `BETWEEN from AND to` |
| `.<prefix>CreateTimeIsNull()` | `IS NULL` |

#### Boolean Filters

| Method | SQL Equivalent |
|--------|---------------|
| `.<prefix>Active(true)` | `= true` |
| `.<prefix>Active(false)` | `= false` |
| `.whoAre<Property>()` / `.whichAre<Property>()` | `= true` |
| `.whoAreNot<Property>()` / `.whichAreNot<Property>()` | `= false` |

> Human entities use `whoAre` / `whoAreNot`. Thing entities use `whichAre` / `whichAreNot`.

### 1.3 Human vs Thing Naming

| Aspect | Human Entity | Thing Entity |
|--------|-------------|-------------|
| Filter prefix | `whose` | `with` |
| String contain suffix | `Contains` (e.g. `whoseNameContains`) | `Containing` (e.g. `withNameContaining`) |
| Boolean shortcut | `whoAre` / `whoAreNot` | `whichAre` / `whichAreNot` |
| Example | `Q.employees().whoseNameContains("John")` | `Q.tasks().withNameContaining("build")` |

### 1.4 Entity Field Methods

For every property `P` on an entity, three methods are generated:

| Method | Usage | Notes |
|--------|-------|-------|
| `getP()` | Read field value | Getter |
| `updateP(value)` | **Preferred** — change field | Use this for all updates |
| `setP(value)` | **DEPRECATED** — do not use | Exists for legacy compatibility |

```java
// Correct
entity.updateName("new value");

// WRONG — do not use setters
entity.setName("new value");
```

### 1.5 Relation Methods

For a relation `R` pointing to entity `Child`:

| Method | Description |
|--------|-------------|
| `selectR()` | Select the relation for loading |
| `selectRWith(Q.children().selectSelf())` | Select relation with nested query |
| `withRMatching(Q.children().whoseXxx(v))` | Filter parent by child criteria |
| `getRList()` | Get loaded child list from parent |
| `updateR(child)` | Set/change the relation target |

```java
// Load parent with children
var list = Q.vendingMachines()
    .selectSelf()
    .selectChildrenWith(Q.children().selectSelf())
    .comment("load with children")
    .purpose("display tree")
    .executeForList(ctx);
```

### 1.6 Status Enum Shortcuts

For constant/enum fields (e.g. `Status` with values `PLANNED`, `ACTIVE`), TeaQL generates filter and update shortcuts:

```java
// Filter shortcuts
Q.tasks().withStatusIsPlanned()
Q.tasks().withStatusIsActive()

// Update shortcuts
entity.updateStatusToPlanned();
entity.updateStatusToActive();
```

### 1.7 Mutation Patterns

#### Create

```java
var entity = new VendingMachine();
entity.updateName("example");
// set other fields with updateXxx(...)
entity.auditAs("Create new item").save(ctx);
```

#### Update

```java
var entity = Q.vendingMachines()
    .filterById(id)
    .selectSelf()
    .comment("load for update")
    .purpose("edit entity")
    .executeForOne(ctx);

entity.updateName("updated value");
entity.auditAs("Update name").save(ctx);
```

#### Delete (Soft Delete)

```java
var entity = Q.vendingMachines()
    .filterById(id)
    .selectSelf()
    .comment("load for delete")
    .purpose("soft delete entity")
    .executeForOne(ctx);

entity.markAsDeleted();
entity.auditAs("Soft delete entity").save(ctx);
```

> Never hard-delete. Never use SQL DELETE. Use `markAsDeleted()` + `save(ctx)`.

### 1.8 Expression Facade (E)

The generated `E` class provides null-safe expression chains:

```java
// Instead of manual null checks:
String name = E.vendingMachine(entity).name().value();
// Returns "" if entity or name is null

int version = E.vendingMachine(entity).version().value();
// Returns 0 if null
```

| Method | Returns |
|--------|---------|
| `.value()` | The actual value, or type-appropriate default (`0`, `""`, `false`) |
| `.isPresent()` | Whether the value is non-null |

---

## Part 2 — Domain Graph

Package: `com.doublechaintech.vendingmachineservice`

### Entity: VendingMachine

- **Query**: `Q.vendingMachines()`
- **Filter prefix**: `with`
- **Filter suffix**: `ing`
- **Display name**: Vending Machine
- **Category**: Thing — uses `with`, `Containing`, `whichAre`

| Property | Type | Getter | Updater |
|----------|------|--------|---------|
| name |  | `getName()` | `updateName(value)` |

| createTime |  | `getCreateTime()` | `updateCreateTime(value)` |

| updateTime |  | `getUpdateTime()` | `updateUpdateTime(value)` |


**Children (incoming):**
- `orderStatusList` → OrderStatus (select with `selectOrderStatusList()`)

- `paymentMethodList` → PaymentMethod (select with `selectPaymentMethodList()`)

- `paymentStatusList` → PaymentStatus (select with `selectPaymentStatusList()`)

- `productList` → Product (select with `selectProductList()`)


---

### Entity: OrderStatus

- **Query**: `Q.orderStatuses()`
- **Filter prefix**: `with`
- **Filter suffix**: `ing`
- **Display name**: Order Status
- **Category**: Thing — uses `with`, `Containing`, `whichAre`

| Property | Type | Getter | Updater |
|----------|------|--------|---------|
| vendingMachine |  | `getVendingMachine()` | `updateVendingMachine(value)` |

| name |  | `getName()` | `updateName(value)` |

| code |  | `getCode()` | `updateCode(value)` |


**Relations (outgoing):**
- `vendingMachine` → references another entity (select with `selectVendingMachine()`)


**Children (incoming):**
- `vendingOrderList` → VendingOrder (select with `selectVendingOrderList()`)


---

### Entity: PaymentMethod

- **Query**: `Q.paymentMethods()`
- **Filter prefix**: `with`
- **Filter suffix**: `ing`
- **Display name**: Payment Method
- **Category**: Thing — uses `with`, `Containing`, `whichAre`

| Property | Type | Getter | Updater |
|----------|------|--------|---------|
| vendingMachine |  | `getVendingMachine()` | `updateVendingMachine(value)` |

| name |  | `getName()` | `updateName(value)` |

| code |  | `getCode()` | `updateCode(value)` |


**Relations (outgoing):**
- `vendingMachine` → references another entity (select with `selectVendingMachine()`)


**Children (incoming):**
- `orderPaymentList` → OrderPayment (select with `selectOrderPaymentList()`)


---

### Entity: PaymentStatus

- **Query**: `Q.paymentStatuses()`
- **Filter prefix**: `with`
- **Filter suffix**: `ing`
- **Display name**: Payment Status
- **Category**: Thing — uses `with`, `Containing`, `whichAre`

| Property | Type | Getter | Updater |
|----------|------|--------|---------|
| vendingMachine |  | `getVendingMachine()` | `updateVendingMachine(value)` |

| name |  | `getName()` | `updateName(value)` |

| code |  | `getCode()` | `updateCode(value)` |


**Relations (outgoing):**
- `vendingMachine` → references another entity (select with `selectVendingMachine()`)


**Children (incoming):**
- `orderPaymentList` → OrderPayment (select with `selectOrderPaymentList()`)


---

### Entity: Product

- **Query**: `Q.products()`
- **Filter prefix**: `with`
- **Filter suffix**: `ing`
- **Display name**: Product
- **Category**: Thing — uses `with`, `Containing`, `whichAre`

| Property | Type | Getter | Updater |
|----------|------|--------|---------|
| name |  | `getName()` | `updateName(value)` |

| price |  | `getPrice()` | `updatePrice(value)` |

| stock |  | `getStock()` | `updateStock(value)` |

| imageUrl |  | `getImageUrl()` | `updateImageUrl(value)` |

| vendingMachine |  | `getVendingMachine()` | `updateVendingMachine(value)` |

| createTime |  | `getCreateTime()` | `updateCreateTime(value)` |

| updateTime |  | `getUpdateTime()` | `updateUpdateTime(value)` |


**Relations (outgoing):**
- `vendingMachine` → references another entity (select with `selectVendingMachine()`)


**Children (incoming):**
- `vendingOrderItemList` → VendingOrderItem (select with `selectVendingOrderItemList()`)


---

### Entity: VendingOrder

- **Query**: `Q.vendingOrders()`
- **Filter prefix**: `with`
- **Filter suffix**: `ing`
- **Display name**: Vending Order
- **Category**: Thing — uses `with`, `Containing`, `whichAre`

| Property | Type | Getter | Updater |
|----------|------|--------|---------|
| title |  | `getTitle()` | `updateTitle(value)` |

| totalAmount |  | `getTotalAmount()` | `updateTotalAmount(value)` |

| status |  | `getStatus()` | `updateStatus(value)` |

| createTime |  | `getCreateTime()` | `updateCreateTime(value)` |

| updateTime |  | `getUpdateTime()` | `updateUpdateTime(value)` |


**Relations (outgoing):**
- `status` → references another entity (select with `selectStatus()`)


**Children (incoming):**
- `orderPaymentList` → OrderPayment (select with `selectOrderPaymentList()`)

- `vendingOrderItemList` → VendingOrderItem (select with `selectVendingOrderItemList()`)


---

### Entity: OrderPayment

- **Query**: `Q.orderPayments()`
- **Filter prefix**: `with`
- **Filter suffix**: `ing`
- **Display name**: Order Payment
- **Category**: Thing — uses `with`, `Containing`, `whichAre`

| Property | Type | Getter | Updater |
|----------|------|--------|---------|
| name |  | `getName()` | `updateName(value)` |

| vendingOrder |  | `getVendingOrder()` | `updateVendingOrder(value)` |

| paymentMethod |  | `getPaymentMethod()` | `updatePaymentMethod(value)` |

| paymentStatus |  | `getPaymentStatus()` | `updatePaymentStatus(value)` |

| amount |  | `getAmount()` | `updateAmount(value)` |

| paymentTime |  | `getPaymentTime()` | `updatePaymentTime(value)` |

| transactionId |  | `getTransactionId()` | `updateTransactionId(value)` |

| createTime |  | `getCreateTime()` | `updateCreateTime(value)` |

| updateTime |  | `getUpdateTime()` | `updateUpdateTime(value)` |


**Relations (outgoing):**
- `vendingOrder` → references another entity (select with `selectVendingOrder()`)

- `paymentMethod` → references another entity (select with `selectPaymentMethod()`)

- `paymentStatus` → references another entity (select with `selectPaymentStatus()`)


---

### Entity: VendingOrderItem

- **Query**: `Q.vendingOrderItems()`
- **Filter prefix**: `with`
- **Filter suffix**: `ing`
- **Display name**: Vending Order Item
- **Category**: Thing — uses `with`, `Containing`, `whichAre`

| Property | Type | Getter | Updater |
|----------|------|--------|---------|
| name |  | `getName()` | `updateName(value)` |

| vendingOrder |  | `getVendingOrder()` | `updateVendingOrder(value)` |

| product |  | `getProduct()` | `updateProduct(value)` |

| quantity |  | `getQuantity()` | `updateQuantity(value)` |

| price |  | `getPrice()` | `updatePrice(value)` |

| amount |  | `getAmount()` | `updateAmount(value)` |

| createTime |  | `getCreateTime()` | `updateCreateTime(value)` |

| updateTime |  | `getUpdateTime()` | `updateUpdateTime(value)` |


**Relations (outgoing):**
- `vendingOrder` → references another entity (select with `selectVendingOrder()`)

- `product` → references another entity (select with `selectProduct()`)


---
