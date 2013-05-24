/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.server.bean;

import g3.hibernate.entity.Bill;
import g3.hibernate.entity.Member;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;

/**
 *
 * @author kiendv
 */
@ManagedBean
@RequestScoped
public class BillBean {

    /**
     * Creates a new instance of BillBean
     */
    Session session = null;
    private List<Bill> bills;
    private List<Bill> billSearch;
    private String orderedDate;
    public BillBean() {
    }
    public Session getSession() {
        return DvdStoreHibernateUtil.getSessionFactory().openSession();
    }

    public List<Bill> getBills() {
        HttpSession ss = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        int id = ((Member) ss.getAttribute("member")).getId();
        setBills(getSession().createQuery("FROM Bill b WHERE b.isDeleted = 0 and b.memberId = "+id).list());
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }

    public String getOrderedDate() {
        return orderedDate;
    }

    public void setOrderedDate(String orderedDate) {
        this.orderedDate = orderedDate;
    }
    public void search(){
        HttpSession ss = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        int id = ((Member) ss.getAttribute("member")).getId();
        setBillSearch(getSession().createQuery("FROM Bill b WHERE b.isDeleted = 0 and b.orderDate = '"+orderedDate+"' and b.memberId = "+id).list());
    }

    public List<Bill> getBillSearch() {
        return billSearch;
    }

    public void setBillSearch(List<Bill> billSearch) {
        this.billSearch = billSearch;
    }
    
}
