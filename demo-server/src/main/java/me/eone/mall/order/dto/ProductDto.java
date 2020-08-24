package me.eone.mall.order.dto;

/**
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/6-9:17 PM
 */
public class ProductDto {
    private int id;
    private int price;
    private String name;
    private String remarks;

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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
               "id=" + id +
               ", price=" + price +
               ", name='" + name + '\'' +
               ", remarks='" + remarks + '\'' +
               '}';
    }
}
