package g3.hibernate.entity;
// Generated May 21, 2013 8:59:34 PM by Hibernate Tools 3.2.1.GA


import java.io.Serializable;
import java.util.Date;

/**
 * Feedback generated by hbm2java
 */
public class Feedback  implements java.io.Serializable {


     private int id;
     private Integer customerId;
     private Date submittedDate;
     private Serializable feedbackText;
     private Boolean status;
     private Serializable replyText;
     private Date createdDate;
     private Date modifiedDate;
     private boolean isDeleted;

    public Feedback() {
    }

	
    public Feedback(int id, boolean isDeleted) {
        this.id = id;
        this.isDeleted = isDeleted;
    }
    public Feedback(int id, Integer customerId, Date submittedDate, Serializable feedbackText, Boolean status, Serializable replyText, Date createdDate, Date modifiedDate, boolean isDeleted) {
       this.id = id;
       this.customerId = customerId;
       this.submittedDate = submittedDate;
       this.feedbackText = feedbackText;
       this.status = status;
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
    public Integer getCustomerId() {
        return this.customerId;
    }
    
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
    public Date getSubmittedDate() {
        return this.submittedDate;
    }
    
    public void setSubmittedDate(Date submittedDate) {
        this.submittedDate = submittedDate;
    }
    public Serializable getFeedbackText() {
        return this.feedbackText;
    }
    
    public void setFeedbackText(Serializable feedbackText) {
        this.feedbackText = feedbackText;
    }
    public Boolean getStatus() {
        return this.status;
    }
    
    public void setStatus(Boolean status) {
        this.status = status;
    }
    public Serializable getReplyText() {
        return this.replyText;
    }
    
    public void setReplyText(Serializable replyText) {
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


