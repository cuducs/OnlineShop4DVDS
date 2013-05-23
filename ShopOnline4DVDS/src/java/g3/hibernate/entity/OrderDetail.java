package g3.hibernate.entity;
// Generated May 21, 2013 8:59:34 PM by Hibernate Tools 3.2.1.GA



/**
 * OrderDetail generated by hbm2java
 */
public class OrderDetail  implements java.io.Serializable {


     private OrderDetailId id;
     private Double price;
     private Integer quantity;

    public OrderDetail() {
    }

	
    public OrderDetail(OrderDetailId id) {
        this.id = id;
    }
    public OrderDetail(OrderDetailId id, Double price, Integer quantity) {
       this.id = id;
       this.price = price;
       this.quantity = quantity;
    }
   
    public OrderDetailId getId() {
        return this.id;
    }
    
    public void setId(OrderDetailId id) {
        this.id = id;
    }
    public Double getPrice() {
        return this.price;
    }
    
    public void setPrice(Double price) {
        this.price = price;
    }
    public Integer getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }




}

