package g3.hibernate.entity.ver2;
// Generated May 23, 2013 8:04:27 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * Category generated by hbm2java
 */
public class Category {


     private int id;
     private String name;
     private String query;
     private String description;
     private Integer categoryParentId;
     private Date createdDate;
     private Date modifiedDate;
     private boolean isDeleted;
     private String woodenLeg;
     private int cateLevel;

    public Category() {
    }
    
    public Category(int id, String name, String query, String description, Integer categoryParentId, Date createdDate, Date modifiedDate, boolean isDeleted, String woodenLeg, int cateLevel) {
       this.id = id;
       this.name = name;
       this.query = query;
       this.description = description;
       this.categoryParentId = categoryParentId;
       this.createdDate = createdDate;
       this.modifiedDate = modifiedDate;
       this.isDeleted = isDeleted;
       this.woodenLeg = woodenLeg;
       this.cateLevel = cateLevel;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getQuery() {
        return this.query;
    }
    
    public void setQuery(String query) {
        this.query = query;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
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

    public String getWoodenLeg() {
        return this.woodenLeg;
    }
    
    public void setWoodenLeg(String woodenLeg) {
        this.woodenLeg = woodenLeg;
    }
    public int getCateLevel() {
        return this.cateLevel;
    }
    
    public void setCateLevel(int cateLevel) {
        this.cateLevel = cateLevel;
    }


}


