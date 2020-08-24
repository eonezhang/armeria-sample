package com.eone.mall.product.dto;

/**
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/6-4:41 PM
 */
public class ProductDto {
    private int id;
    private int price;
    private String name;
    private String remark;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
               "id=" + id +
               ", price=" + price +
               ", name='" + name + '\'' +
               ", remark='" + remark + '\'' +
               '}';
    }
}
