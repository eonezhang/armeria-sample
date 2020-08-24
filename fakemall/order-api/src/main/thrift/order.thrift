namespace java me.eone.fakemall.order

struct Order {
    1: i32 id
}

struct OrderLine {
    1: i32 productId
    2: i32 amount
    3: i32 price
}

struct CartItem {
    1: i32 productId
    2: i32 amount
    3: i32 price
}

struct CreateOrderReq {
    1: i32 userId
    2: list<CartItem> items
}

struct CreateOrderResp {
    1: Order order
}

struct GetOrderReq {
    1: i32 orderId
}

struct GetOrderResp {
    1: list<Order> orders
}

service OrderService {
    CreateOrderResp createOrder(1: CreateOrderReq req),
    GetOrderResp getOrder(1: GetOrderReq req)
}