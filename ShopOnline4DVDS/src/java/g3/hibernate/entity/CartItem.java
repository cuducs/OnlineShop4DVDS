/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.hibernate.entity;

/**
 *
 * @author TrungDuc
 */
public class CartItem {
    private Dvd product;
    private Integer count;

    public CartItem() {
    }

    public CartItem(Dvd product, Integer count) {
        this.product = product;
        this.count = count;
    }

    public Dvd getProduct() {
        return product;
    }

    public void setProduct(Dvd product) {
        this.product = product;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
