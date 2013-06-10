/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.bean.other;

import g3.hibernate.entity.Member;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

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
    private String musicincomedata;
    private String movieincomedata;
    private String gameincomedata;
    private String myday=""+ReportHelper.getDay();
    private String mymonth=""+ReportHelper.getMonth();
    private String myyear = ReportHelper.getYear()+"";
  
    
    public ReportBean() {
    }

    public int getTotalOrders() {
        return ReportHelper.getTotalOrder(myday, mymonth, myyear);
    }
    
    public int getTotalOrdersToday() {
        return ReportHelper.getTotalOrder(ReportHelper.getDay()+"", ReportHelper.getMonth()+"", ReportHelper.getYear()+"");
    }

    public int getDoneOrder() {
        return ReportHelper.getDoneOrder(myday, mymonth, myyear);
    }

    public int getWaitingOrder() {
        return ReportHelper.getWaitingOrder(myday, mymonth, myyear);
    }

    public int getCanceledOrder() {
        return ReportHelper.getCanceledOrder(myday, mymonth, myyear);
    }

    public String getMyyear() {
        if(myyear.equals("")){
            myyear = ReportHelper.getYear()+"";
        }
        return myyear;
    }

    public void setMyyear(String myyear) {
        this.myyear = myyear;
    }
    public void changeYear(){
            setMyyear(myyear);
    }

    public String getMusicincomedata() {
        String[] s = ReportHelper.income("0", "0", myyear);
        movieincomedata = s[1];
        gameincomedata = s[2];
        return s[0];
    }

    public String getMovieincomedata() {
        return movieincomedata;
    }

    public String getGameincomedata() {
        return gameincomedata;
    }
    
    public Member getVipCustomer(){
        return ReportHelper.cutomerName(myday, mymonth, myyear);
    }
    
    public Member getVipCustomerToday(){
        return ReportHelper.cutomerName(ReportHelper.getDay()+"", ReportHelper.getMonth()+"", ReportHelper.getYear()+"");
    }
    
    public String getTopsellingdata(){
        int[] x = ReportHelper.topnumber(myday, mymonth, myyear);
        return x[0]+","+x[1]+","+x[2];
    }
    public int getVipQuantity(){
        return ReportHelper.cutomerQuantity(myday, mymonth, myyear);
    }
    
    public int getVipQuantityToday(){
        return ReportHelper.cutomerQuantity(ReportHelper.getDay()+"", ReportHelper.getMonth()+"", ReportHelper.getYear()+"");
    }
    
    public long getTotalDVD(){
        return ReportHelper.totalDVD();
    }
    public long getTotalMember(){
        return ReportHelper.totalMember();
    }
    public long getTotalUnreadFeedback(){
        return ReportHelper.totalUnreadFeedback();
    }
    public long getTotalSong(){
        return ReportHelper.totalSong();
    }
    public BigDecimal getTotalIncomeToday(){
        return ReportHelper.incomeToday();
    }
    public int getTotalSoldToday(){
        return ReportHelper.totalSoldToday();
    }

    public String getMymonth() {
        return mymonth;
    }

    public void setMymonth(String mymonth) {
        this.mymonth = mymonth;
    }
    public List<String> getListMonth(){
        List<String> l = new ArrayList<String>();
        for(int i=1; i<13; i++){
            l.add(""+i+"");
        }
        return l;
    }
    public List<String> getListDay(){
        List<String> l = new ArrayList<String>();
        for(int i=1; i<32; i++){
            l.add(""+i+"");
        }
        return l;
    }

    public String getMyday() {
        return myday;
    }

    public void setMyday(String myday) {
        this.myday = myday;
    }
}
