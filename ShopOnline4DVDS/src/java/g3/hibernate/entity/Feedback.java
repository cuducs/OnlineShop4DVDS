package g3.hibernate.entity;
// Generated Jun 5, 2013 8:44:18 AM by Hibernate Tools 3.2.1.GA


import java.io.Serializable;
import java.util.Date;

/**
 * Feedback generated by hbm2java
 */
public class Feedback  implements java.io.Serializable {


     private int id;
     private Integer memberId;
     private String feedbackText;
     private Boolean isRead;
     private String replyText;
     private Date createdDate;
     private Date modifiedDate;
     private boolean isDeleted;

    public Feedback() {
    }

	
    public Feedback(int id, Date createdDate, Date modifiedDate, boolean isDeleted) {
        this.id = id;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.isDeleted = isDeleted;
    }
    public Feedback(int id, Integer memberId, String feedbackText, Boolean isRead, String replyText, Date createdDate, Date modifiedDate, boolean isDeleted) {
       this.id = id;
       this.memberId = memberId;
       this.feedbackText = feedbackText;
       this.isRead = isRead;
       this.replyText = replyText;
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
    public Integer getMemberId() {
        return this.memberId;
    }
    
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }
    public String getFeedbackText() {
        return this.feedbackText;
    }
    
    public void setFeedbackText(String feedbackText) {
        this.feedbackText = feedbackText;
    }
    public Boolean getIsRead() {
        return this.isRead;
    }
    
    public void setIsRead(Boolean isRead) {
        this.isRead = isRead;
    }
    public String getReplyText() {
        return this.replyText;
    }
    
    public void setReplyText(String replyText) {
        this.replyText = replyText;
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


