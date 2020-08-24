namespace java me.eone.mall.product

/**
 * Product DTO
 */
struct Product {
    1: i32 id = 0,
    2: string name,
    3: i32 price,
    4: optional string remarks,
}

/**
 * Business Exception
 */
exception BizException {
    1: i32 errcode,
    2: string errmsg
}

/**
 * Product Service
 */
service ProductService {
    void ping(),
    Product findById(1:i32 id) throws (1:BizException be),
    list<Product> products(1:i32 pageNo, 2:i32 pageSize) throws (1:BizException be)
    i32 update(1:i32 id, 2:Product product) throws (1:BizException be)
}