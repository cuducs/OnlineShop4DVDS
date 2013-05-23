package g3.hibernate.entity;
// Generated May 23, 2013 8:04:27 PM by Hibernate Tools 3.2.1.GA


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
     private Date createdDate;
     private Integer numberItem;
     private String type;
     private Date modifiedDate;
     private boolean isDeleted;

    public Album() {
    }

	
    public Album(int id, boolean isDeleted) {
        this.id = id;
        this.isDeleted = isDeleted;
    }
    public Album(int id, String title, String owner, Integer viewCount, Date createdDate, Integer numberItem, String type, Date modifiedDate, boolean isDeleted) {
       this.id = id;
       this.title = title;
       this.owner = owner;
       this.viewCount = viewCount;
       this.createdDate = createdDate;
       this.numberItem = numberItem;
       this.type = type;
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
    public Date getCreatedDate() {
        return this.createdDate;
    }
    
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    public Integer getNumberItem() {
        return this.numberItem;
    }
    
    public void setNumberItem(Integer numberItem) {
        this.numberItem = numberItem;
    }
    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
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


