/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.bean.client;

import g3.bean.manage.other.ProducerManagedHelper;
import g3.hibernate.entity.Dvd;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author DUCVM
 */
@ManagedBean
@SessionScoped
public class RatingBean implements Serializable{
    private ProducerManagedHelper helper;
    int ratePoint = 0;

    /**
     * Creates a new instance of RatingBean
     */
    public RatingBean() {
    }
    
     @PostConstruct
    public void init() {
        helper = ProducerManagedHelper.getInstance();
    }

    @PreDestroy
    public void end() {
        helper.close();
    }

    public int getRatePoint() {
        int productId = 0;
        int oldPoint = 0; 
        int oldCount = 0;
        
        
        try
        {
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            productId = Integer.parseInt(request.getSession().getAttribute("productid").toString());
            System.out.printf("getRatePoint : productid = " + productId);
            Dvd product = (Dvd) helper.getObjectById(Dvd.class, Integer.toString(productId));
            oldPoint = product.getRatePoint();
            oldCount = product.getRateCount();
        }catch(Exception e){
            System.out.printf("getRatePoint loi : " + e.toString());
        }
            
        int result = 0;
        if(oldCount!=0) {
            result = oldPoint/oldCount;
            
        }
        else {
            result=0;
        }
        System.out.printf("getRatePoint : result = " + result + " oldPoint = " + oldPoint + " oldCount = " + oldCount);
        return result;
    }

    public void setRatePoint(int ratePoint) {
        this.ratePoint = ratePoint;
    }
    
    public String onrate() {
        try {
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            int productId;
            productId = Integer.parseInt(request.getSession().getAttribute("productid").toString());
                
            String strProductId = Integer.toString(productId);
            int oldPoint = 0; 
            int oldCount = 0;
            Dvd product = (Dvd) helper.getObjectById(Dvd.class, strProductId);

            try
            {
                oldPoint = product.getRatePoint();
                oldCount = product.getRateCount();
            }catch(Exception ex){}
            product.setRatePoint(oldPoint + ratePoint);
            product.setRateCount(oldCount + 1);
            helper.updateRateing(product);
             System.out.printf("onrate : oldPoint = " + oldPoint + " oldCount = " + oldCount);
            return "details.xhtml?productid=" + productId;
        } catch (Exception e) {
            System.out.printf("onrate loi : " + e.toString());
            return "welcome.xhtml";
        }
         
    }
}
