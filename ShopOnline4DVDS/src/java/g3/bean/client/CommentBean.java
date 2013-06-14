/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.bean.client;

import g3.bean.security.CustomerManagedHelper;
import g3.hibernate.entity.Comment;
import g3.hibernate.entity.Member;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DUCVM
 */
@ManagedBean
@SessionScoped
public class CommentBean {
    private CommentHelper helper;
    private CustomerManagedHelper customer_helper;
    private String commentText;

    /**
     * Creates a new instance of CommentBean
     */
    public CommentBean() {
    }
    
    @PostConstruct
    public void init() {
        helper = CommentHelper.getInstance();
        customer_helper = CustomerManagedHelper.getInstance();
    }

    @PreDestroy
    public void end() {
        helper.close();
        customer_helper.close();
    }
    
    public List<Comment> commentsByProduct(String productId)
    {
        try
        {
            return helper.getCommentsByProduct(productId);
        }
        catch(Exception e)
        {
            try
            {
                System.out.printf("commentsByProduct Loi 1 : " + e.toString());
                HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
                productId =  (String) request.getSession().getAttribute("productid");
                return helper.getCommentsByProduct(productId);
            }catch(Exception ex)
            {
                System.out.printf("commentsByProduct Loi 2 : " + ex.toString());
                return new ArrayList();
            }
        }
        
    }
    
    public String commentMemberName(int memberId)
    {
        try
        {
            
            Member mem = (Member) customer_helper.getMember(memberId);
            
            return mem.getName();
        }
        catch(Exception e)
        {
            return "";
        }
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }
    
    public String save(int productId)
    {
        Member m = null;
        try {
            HttpSession ss = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            
            if (ss.getAttribute("member") != null) {
                
                m = (Member) ss.getAttribute("member");
                Comment comment = new Comment();
                comment.setTitle(" ");
                comment.setMemberId(m.getId());
                comment.setDvdId(productId);
                comment.setCreatedDate(new Date());
                comment.setModifiedDate(new Date());
                comment.setIsDeleted(false);
                comment.setCommentText(commentText);
                helper.save(comment);
                commentText = "";
                return "details.xhtml?productid=" + productId;
            }
        } catch (Exception e) {
            System.out.printf(e.toString());
        }

        return "details.xhtml?productid=" + productId;
        
    }
}
