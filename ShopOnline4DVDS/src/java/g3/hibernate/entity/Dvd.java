package g3.hibernate.entity;
// Generated May 21, 2013 8:59:34 PM by Hibernate Tools 3.2.1.GA


import java.io.Serializable;
import java.util.Date;

/**
 * Dvd generated by hbm2java
 */
public class Dvd  implements java.io.Serializable {


     private int id;
     private Date releaseDate;
     private Serializable genres;
     private Serializable description;
     private Double price;
     private Serializable imageCoverUrl;
     private Serializable author;
     private Integer discNumber;
     private Integer detailId;
     private Integer ratePoint;
     private Integer rateCount;
     private String type;
     private Date createdDate;
     private Date modifiedDate;
     private boolean isDeleted;

    public Dvd() {
    }

	
    public Dvd(int id, boolean isDeleted) {
        this.id = id;
        this.isDeleted = isDeleted;
    }
    public Dvd(int id, Date releaseDate, Serializable genres, Serializable description, Double price, Serializable imageCoverUrl, Serializable author, Integer discNumber, Integer detailId, Integer ratePoint, Integer rateCount, String type, Date createdDate, Date modifiedDate, boolean isDeleted) {
       this.id = id;
       this.releaseDate = releaseDate;
       this.genres = genres;
       this.description = description;
       this.price = price;
       this.imageCoverUrl = imageCoverUrl;
       this.author = author;
       this.discNumber = discNumber;
       this.detailId = detailId;
       this.ratePoint = ratePoint;
       this.rateCount = rateCount;
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
    public Date getReleaseDate() {
        return this.releaseDate;
    }
    
    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
    public Serializable getGenres() {
        return this.genres;
    }
    
    public void setGenres(Serializable genres) {
        this.genres = genres;
    }
    public Serializable getDescription() {
        return this.description;
    }
    
    public void setDescription(Serializable description) {
        this.description = description;
    }
    public Double getPrice() {
        return this.price;
    }
    
    public void setPrice(Double price) {
        this.price = price;
    }
    public Serializable getImageCoverUrl() {
        return this.imageCoverUrl;
    }
    
    public void setImageCoverUrl(Serializable imageCoverUrl) {
        this.imageCoverUrl = imageCoverUrl;
    }
    public Serializable getAuthor() {
        return this.author;
    }
    
    public void setAuthor(Serializable author) {
        this.author = author;
    }
    public Integer getDiscNumber() {
        return this.discNumber;
    }
    
    public void setDiscNumber(Integer discNumber) {
        this.discNumber = discNumber;
    }
    public Integer getDetailId() {
        return this.detailId;
    }
    
    public void setDetailId(Integer detailId) {
        this.detailId = detailId;
    }
    public Integer getRatePoint() {
        return this.ratePoint;
    }
    
    public void setRatePoint(Integer ratePoint) {
        this.ratePoint = ratePoint;
    }
    public Integer getRateCount() {
        return this.rateCount;
    }
    
    public void setRateCount(Integer rateCount) {
        this.rateCount = rateCount;
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

