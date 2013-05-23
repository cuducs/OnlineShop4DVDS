package g3.hibernate.entity;
// Generated May 21, 2013 8:59:34 PM by Hibernate Tools 3.2.1.GA


import java.io.Serializable;
import java.util.Date;

/**
 * Category generated by hbm2java
 */
public class Category  implements java.io.Serializable {


     private int id;
     private Serializable name;
     private Serializable query;
     private Serializable description;
     private Integer categoryParentId;
     private Date createdDate;
     private Date modifiedDate;
     private boolean isDeleted;

    public Category() {
    }

	
    public Category(int id, boolean isDeleted) {
        this.id = id;
        this.isDeleted = isDeleted;
    }
    public Category(int id, Serializable name, Serializable query, Serializable description, Integer categoryParentId, Date createdDate, Date modifiedDate, boolean isDeleted) {
       this.id = id;
       this.name = name;
       this.query = query;
       this.description = description;
       this.categoryParentId = categoryParentId;
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
    public Serializable getQuery() {
        return this.query;
    }
    
    public void setQuery(Serializable query) {
        this.query = query;
    }
    public Serializable getDescription() {
        return this.description;
    }
    
    public void setDescription(Serializable description) {
        this.description = description;
    }
    public Integer getCategoryParentId() {
        return this.categoryParentId;
    }
    
    public void setCategoryParentId(Integer categoryParentId) {
        this.categoryParentId = categoryParentId;
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

