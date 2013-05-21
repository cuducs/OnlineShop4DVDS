package g3.hibernate.entity;
// Generated May 21, 2013 8:59:34 PM by Hibernate Tools 3.2.1.GA


import java.io.Serializable;
import java.util.Date;

/**
 * Genre generated by hbm2java
 */
public class Genre  implements java.io.Serializable {


     private int id;
     private Serializable name;
     private String type;
     private Date createdDate;
     private Date modifiedDate;
     private boolean isDeleted;

    public Genre() {
    }

	
    public Genre(int id, boolean isDeleted) {
        this.id = id;
        this.isDeleted = isDeleted;
    }
    public Genre(int id, Serializable name, String type, Date createdDate, Date modifiedDate, boolean isDeleted) {
       this.id = id;
       this.name = name;
       this.type = type;
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
    public Serializable getName() {
        return this.name;
    }
    
    public void setName(Serializable name) {
        this.name = name;
    }
    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
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


