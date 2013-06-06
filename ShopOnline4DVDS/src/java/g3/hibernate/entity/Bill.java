package g3.hibernate.entity.ver2;
// Generated Jun 5, 2013 8:44:18 AM by Hibernate Tools 3.2.1.GA


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Bill generated by hbm2java
 */
public class Bill  implements java.io.Serializable {


     private int id;
     private BigDecimal total;
     private Short status;
     private String customerName;
     private String deliveryAddress;
     private String phone;
     private String message;
     private Integer memberId;
     private Date createdDate;
     private Date modifiedDate;
     private boolean isDeleted;

    public Bill() {
    }

	
    public Bill(int id, Date createdDate, Date modifiedDate, boolean isDeleted) {
        this.id = id;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.isDeleted = isDeleted;
    }
    public Bill(int id, BigDecimal total, Short status, String customerName, String deliveryAddress, String phone, String message, Integer memberId, Date createdDate, Date modifiedDate, boolean isDeleted) {
       this.id = id;
       this.total = total;
       this.status = status;
       this.customerName = customerName;
       this.deliveryAddress = deliveryAddress;
       this.phone = phone;
       this.message = message;
       this.memberId = memberId;
       this.createdDate = createdDate;
       this.modifiedDate = modifiedDate;
       this.isDeleted = isDeleted;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public BigDecimal getTotal() {
        return this.total;
    }
    
    public void setTotal(BigDecimal total) {
        this.total = total;
    }
    public Short getStatus() {
        return this.status;
    }
    
    public void setStatus(Short status) {
        this.status = status;
    }
    public String getCustomerName() {
        return this.customerName;
    }
    
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String getDeliveryAddress() {
        return this.deliveryAddress;
    }
    
    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getMessage() {
        return this.message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    public Integer getMemberId() {
        return this.memberId;
    }
    
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }
    public Date getCreatedDate() {
        return this.createdDate;
    }
    
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    public Date getModifiedDate() {
        return this.modifiedDate;
    }
    
    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
    public boolean isIsDeleted() {
        return this.isDeleted;
    }
    
    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }




}


