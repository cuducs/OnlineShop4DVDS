package g3.hibernate.entity;
// Generated May 23, 2013 2:18:11 PM by Hibernate Tools 3.2.1.GA


import java.io.Serializable;
import java.util.Date;

/**
 * File generated by hbm2java
 */
public class File  implements java.io.Serializable {


     private int id;
     private Serializable title;
     private Serializable url;
     private String type;
     private Integer viewCount;
     private Date createdDate;
     private Date modifiedDate;
     private boolean isDeleted;

    public File() {
    }

	
    public File(int id, boolean isDeleted) {
        this.id = id;
        this.isDeleted = isDeleted;
    }
    public File(int id, Serializable title, Serializable url, String type, Integer viewCount, Date createdDate, Date modifiedDate, boolean isDeleted) {
       this.id = id;
       this.title = title;
       this.url = url;
       this.type = type;
       this.viewCount = viewCount;
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
    public Serializable getTitle() {
        return this.title;
    }
    
    public void setTitle(Serializable title) {
        this.title = title;
    }
    public Serializable getUrl() {
        return this.url;
    }
    
    public void setUrl(Serializable url) {
        this.url = url;
    }
    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
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


