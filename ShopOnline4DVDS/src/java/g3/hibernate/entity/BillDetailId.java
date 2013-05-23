package g3.hibernate.entity;
// Generated May 23, 2013 8:04:27 PM by Hibernate Tools 3.2.1.GA



/**
 * BillDetailId generated by hbm2java
 */
public class BillDetailId  implements java.io.Serializable {


     private int billId;
     private int productId;

    public BillDetailId() {
    }

    public BillDetailId(int billId, int productId) {
       this.billId = billId;
       this.productId = productId;
    }
   
    public int getBillId() {
        return this.billId;
    }
    
    public void setBillId(int billId) {
        this.billId = billId;
    }
    public int getProductId() {
        return this.productId;
    }
    
    public void setProductId(int productId) {
        this.productId = productId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof BillDetailId) ) return false;
		 BillDetailId castOther = ( BillDetailId ) other; 
         
		 return (this.getBillId()==castOther.getBillId())
 && (this.getProductId()==castOther.getProductId());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getBillId();
         result = 37 * result + this.getProductId();
         return result;
   }   


}

