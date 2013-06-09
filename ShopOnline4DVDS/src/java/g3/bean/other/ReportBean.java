/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.bean.other;

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
    private String myyear = "2010";
  
    
    public ReportBean() {
    }

    public int getTotalOrders() {
        return ReportHelper.getTotalOrder(myyear);
    }

    public int getDoneOrder() {
        return ReportHelper.getDoneOrder(myyear);
    }

    public int getWaitingOrder() {
        return ReportHelper.getWaitingOrder(myyear);
    }

    public int getCanceledOrder() {
        return ReportHelper.getCanceledOrder(myyear);
    }

    public String getPie() {
        pie = ReportHelper.drawPie(myyear);
        return pie;
    }

    public String getByMonth() {
        return ReportHelper.incomeMonthbyYearMusic(myyear);
    }

    public String getMyyear() {
        return myyear;
    }

    public void setMyyear(String myyear) {
        this.myyear = myyear;
    }
    public void changeYear(){
        setMyyear(myyear);
    }
    public String getTest(){
        String s = ReportHelper.prin();
        return s;
    }
    
}
