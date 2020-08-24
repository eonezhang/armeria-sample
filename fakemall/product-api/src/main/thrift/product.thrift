namespace java me.eone.fakemall.product

struct Product {
    1: i32 id
    2: string name
    3: string richDesc
}

service ProductService {
    Product product(1: i32 id),
    list<Product> products(1: i32 pageNo, 2: i32 pageSize)
}