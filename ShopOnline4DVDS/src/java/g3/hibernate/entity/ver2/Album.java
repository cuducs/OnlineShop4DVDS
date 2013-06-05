package g3.hibernate.entity.ver2;
// Generated Jun 5, 2013 8:44:18 AM by Hibernate Tools 3.2.1.GA


import java.io.Serializable;
import java.util.Date;

/**
 * Album generated by hbm2java
 */
public class Album  implements java.io.Serializable {


     private int id;
     private String title;
     private String owner;
     private Integer viewCount;
     private Integer numberItem;
     private Date createdDate;
     private Date modifiedDate;
     private boolean isDeleted;

    public Album() {
    }

	
    public Album(int id, String title, boolean isDeleted) {
        this.id = id;
        this.title = title;
        this.isDeleted = isDeleted;
    }
    public Album(int id, String title, String owner, Integer viewCount, Integer numberItem, Date createdDate, Date modifiedDate, boolean isDeleted) {
       this.id = id;
       this.title = title;
       this.owner = owner;
       this.viewCount = viewCount;
       this.numberItem = numberItem;
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
    public String getOwner() {
        return this.owner;
    }
    
    public void setOwner(String owner) {
        this.owner = owner;
    }
    public Integer getViewCount() {
        return this.viewCount;
    }
    
    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }
    public Integer getNumberItem() {
        return this.numberItem;
    }
    
    public void setNumberItem(Integer numberItem) {
        this.numberItem = numberItem;
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

