package g3.hibernate.entity;
// Generated May 21, 2013 8:59:34 PM by Hibernate Tools 3.2.1.GA


import java.io.Serializable;
import java.util.Date;

/**
 * Game generated by hbm2java
 */
public class Game  implements java.io.Serializable {


     private int id;
     private Serializable title;
     private Serializable language;
     private Serializable platform;
     private Serializable brand;
     private Integer trailerId;
     private Date createdDate;
     private Date modifiedDate;
     private boolean isDeleted;

    public Game() {
    }

	
    public Game(int id, boolean isDeleted) {
        this.id = id;
        this.isDeleted = isDeleted;
    }
    public Game(int id, Serializable title, Serializable language, Serializable platform, Serializable brand, Integer trailerId, Date createdDate, Date modifiedDate, boolean isDeleted) {
       this.id = id;
       this.title = title;
       this.language = language;
       this.platform = platform;
       this.brand = brand;
       this.trailerId = trailerId;
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
    public Serializable getLanguage() {
        return this.language;
    }
    
    public void setLanguage(Serializable language) {
        this.language = language;
    }
    public Serializable getPlatform() {
        return this.platform;
    }
    
    public void setPlatform(Serializable platform) {
        this.platform = platform;
    }
    public Serializable getBrand() {
        return this.brand;
    }
    
    public void setBrand(Serializable brand) {
        this.brand = brand;
    }
    public Integer getTrailerId() {
        return this.trailerId;
    }
    
    public void setTrailerId(Integer trailerId) {
        this.trailerId = trailerId;
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

