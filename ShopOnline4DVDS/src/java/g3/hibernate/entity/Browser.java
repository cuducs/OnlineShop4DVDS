package g3.hibernate.entity;
// Generated Jun 3, 2013 12:34:39 PM by Hibernate Tools 3.2.1.GA


import java.io.Serializable;

/**
 * Browser generated by hbm2java
 */
public class Browser  implements java.io.Serializable {


     private int id;
     private int parentId;
     private String query;
     private String title;

    public Browser() {
    }

    public Browser(int id, int parentId, String query, String title) {
       this.id = id;
       this.parentId = parentId;
       this.query = query;
       this.title = title;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public int getParentId() {
        return this.parentId;
    }
    
    public void setParentId(int parentId) {
        this.parentId = parentId;
    }
    public String getQuery() {
        return this.query;
    }
    
    public void setQuery(String query) {
        this.query = query;
    }
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }




}


