package g3.hibernate.entity.ver2;
// Generated Jun 5, 2013 8:44:18 AM by Hibernate Tools 3.2.1.GA


import java.io.Serializable;
import java.util.Date;

/**
 * Movie generated by hbm2java
 */
public class Movie  implements java.io.Serializable {


     private int id;
     private String title;
     private String studio;
     private String director;
     private String actor;
     private String info;
     private Integer trailerId;
     private Date createdDate;
     private Date modifiedDate;
     private boolean isDeleted;

    public Movie() {
    }

	
    public Movie(int id, String title, Date createdDate, Date modifiedDate, boolean isDeleted) {
        this.id = id;
        this.title = title;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.isDeleted = isDeleted;
    }
    public Movie(int id, String title, String studio, String director, String actor, String info, Integer trailerId, Date createdDate, Date modifiedDate, boolean isDeleted) {
       this.id = id;
       this.title = title;
       this.studio = studio;
       this.director = director;
       this.actor = actor;
       this.info = info;
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
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    public String getStudio() {
        return this.studio;
    }
    
    public void setStudio(String studio) {
        this.studio = studio;
    }
    public String getDirector() {
        return this.director;
    }
    
    public void setDirector(String director) {
        this.director = director;
    }
    public String getActor() {
        return this.actor;
    }
    
    public void setActor(String actor) {
        this.actor = actor;
    }
    public String getInfo() {
        return this.info;
    }
    
    public void setInfo(String info) {
        this.info = info;
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


