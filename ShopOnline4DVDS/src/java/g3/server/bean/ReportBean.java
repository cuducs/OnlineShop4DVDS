/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.server.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.Session;

/**
 *
 * @author lab
 */
@ManagedBean
@SessionScoped
public class ReportBean {

    /**
     * Creates a new instance of ReportBean
     */
    private int totalOrders;
    private int doneOrder;
    private int waitingOrder;
    private int canceledOrder;
    private String pie;
    private String byMonth;
  
    
    public ReportBean() {
    }

    public int getTotalOrders() {
        return ReportHelper.getTotalOrder();
    }

    public int getDoneOrder() {
        return ReportHelper.getDoneOrder();
    }

    public int getWaitingOrder() {
        return ReportHelper.getWaitingOrder();
    }

    public int getCanceledOrder() {
        return ReportHelper.getCanceledOrder();
    }

    public String getPie() {
        pie = ReportHelper.drawPie();
        return pie;
    }

    public String getByMonth() {
        return ReportHelper.drawBarMonth(2010);
    }
    
    
}
