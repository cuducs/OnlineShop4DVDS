package g3.hibernate.entity;
// Generated Jun 5, 2013 8:44:18 AM by Hibernate Tools 3.2.1.GA


import java.io.Serializable;
import java.util.Date;

/**
 * Producer generated by hbm2java
 */
public class Producer  implements java.io.Serializable {


     private int id;
     private String title;
     private String info;
     private Date createdDate;
     private Date modifiedDate;
     private boolean isDeleted;

    public Producer() {
    }

	
    public Producer(int id, String title, Date createdDate, Date modifiedDate, boolean isDeleted) {
        this.id = id;
        this.title = title;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.isDeleted = isDeleted;
    }
    public Producer(int id, String title, String info, Date createdDate, Date modifiedDate, boolean isDeleted) {
       this.id = id;
       this.title = title;
       this.info = info;
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
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    public String getInfo() {
        return this.info;
    }
    
    public void setInfo(String info) {
        this.info = info;
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


