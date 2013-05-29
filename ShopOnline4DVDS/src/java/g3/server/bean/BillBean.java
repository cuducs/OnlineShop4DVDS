/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.server.bean;

import g3.hibernate.entity.Bill;
import g3.hibernate.entity.Member;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.hibernate.Query;
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
    private List<Bill> adminSearch;
    private String orderedDate;
    private List<Bill> billAdmin;
    private int itemsPerPage = 100;//for paging
    private int page = 0; //offset = 2*10
    private int length = 0;
    private List<Page> pageLinks;//paging links
    private Bill detail;//detail object
    private int detailId;//Id to view detail
    private String updateStatus;//for update
    private String searchField;//for search
    private String searchQuery;//for search
    private String result;
    private List<Bill> sortBills;
    private List<Page> sortLinks;//paging links sorted

    public BillBean() {
    }

    /**
     * *****************************************GETTER and
     * SETTER********************************************
     */
    public Session getSession() {
        return DvdStoreHibernateUtil.getSessionFactory().openSession();
    }

    public List<Bill> getBills() {
        HttpSession ss = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        if (ss.getAttribute("member") != null) {
            int id = ((Member) ss.getAttribute("member")).getId();
            setBills(getSession().createQuery("FROM Bill b WHERE b.isDeleted = 0 and b.memberId = " + id).list());
        } else {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(BillBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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

    public List<Bill> getBillSearch() {
        return billSearch;
    }

    public void setBillSearch(List<Bill> billSearch) {
        this.billSearch = billSearch;
    }

    public List<Bill> getBillAdmin() {
        String sqlQuery = "FROM Bill b where b.isDeleted = 0 and b.status != 2";
        return getSession().createQuery(sqlQuery).setFirstResult(itemsPerPage * ((getPage()) - 1)).setMaxResults(itemsPerPage).list();
    }

    public void setBillAdmin(List<Bill> billAdmin) {
        this.billAdmin = billAdmin;
    }

    public int getPage() {
        HttpServletRequest rq = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String pa = "";
        try {
            pa = rq.getParameter("page");
            page = Integer.parseInt(pa);
            if (page == 0) {
                page = 1;
            }
        } catch (Exception ex) {
            page = 1;
        }
        return page;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getLength() {
        return getSession().createQuery("FROM Bill b WHERE b.isDeleted = 0 and b.status != 2").list().size();
    }

    public List<Page> getPageLinks() {
        int number = getLength() / itemsPerPage;
        if (number == 0) {
            number = 1;
        }
        pageLinks = new ArrayList<Page>();
        for (int i = 1; i < number + 2; i++) {
            pageLinks.add(new Page(i, "order.xhtml?page=" + i));
        }
        return pageLinks;
    }

    public Bill getDetail() {
        Bill b = (Bill) getSession().createQuery("FROM Bill b WHERE b.id = " + getDetailId()).uniqueResult();
        HttpSession ss = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        ss.setAttribute("detail", b);
        return b;
    }

    public int getDetailId() {
        HttpServletRequest rq = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String pa = "";
        try {
            pa = rq.getParameter("detail");
            detailId = Integer.parseInt(pa);
            if (detailId == 0) {
                detailId = 1;
            }
            HttpSession ss = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            ss.setAttribute("bId", detailId);
        } catch (Exception ex) {
            detailId = 1;
        }
        return detailId;
    }

    public String getUpdateStatus() {
        return updateStatus;
    }

    public void setUpdateStatus(String updateStatus) {
        this.updateStatus = updateStatus;
    }

    public List<Bill> getAdminSearch() {
        return adminSearch;
    }

    public String getSearchField() {
        return searchField;
    }

    public void setSearchField(String searchField) {
        this.searchField = searchField;
    }

    public String getSearchQuery() {
        return searchQuery;
    }

    public void setSearchQuery(String searchQuery) {
        this.searchQuery = searchQuery;
    }

    public void setAdminSearch(List<Bill> adminSearch) {
        this.adminSearch = adminSearch;
    }

    public List<Bill> getSortBills() {
        List<Bill> l = new ArrayList<Bill>();
        HttpSession ss = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        if (ss.getAttribute("currentSort") != null) {
            String c = ss.getAttribute("currentSort").toString();
            String sqlQuery = "FROM Bill b where b.isDeleted = 0 and b.status = " + c;
            l = getSession().createQuery(sqlQuery).setFirstResult(itemsPerPage * ((getPage()) - 1)).setMaxResults(itemsPerPage).list();
        }
        return l;
    }

    public List<Page> getSortLinks() {
        HttpSession ss = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        String s = "0";
        if (ss.getAttribute("currentSort") != null) {
            s = ss.getAttribute("currentSort").toString();
        }
        int number = sortLength(s) / itemsPerPage;
        if (number == 0) {
            number = 1;
        }
        sortLinks = new ArrayList<Page>();
        for (int i = 1; i < number + 2; i++) {
            sortLinks.add(new Page(i, "sort.xhtml?page=" + i));
        }
        return sortLinks;
    }

    public int getCanceled() {
        return getSession().createQuery("FROM Bill b WHERE b.isDeleted = 0 and b.status = 0").list().size();
    }

    public int getWaiting() {
        return getSession().createQuery("FROM Bill b WHERE b.isDeleted = 0 and b.status = 1").list().size();
    }

    public int getDone() {
        return getSession().createQuery("FROM Bill b WHERE b.isDeleted = 0 and b.status = 2").list().size();
    }
    
    public String getCurrentTime(){
        return DvdStoreHibernateUtil.currenrTime();
    }

    /**
     * **********************FUNCTIONS************************************************
     */
    public int sortLength(String s) {
        return getSession().createQuery("FROM Bill b WHERE b.isDeleted = 0 and b.status = " + s).list().size();
    }

    public void searchAdmin() {
        if (searchField != null && searchQuery != null) {
            List<Bill> l = new ArrayList<Bill>();
            if (searchField == "orderDate") {
                l = getSession().createQuery("FROM Bill b WHERE b.isDeleted = 0 and " + searchField + " = '" + searchQuery + "'").list();
            } else if (searchField == "id") {
                l = getSession().createQuery("FROM Bill b WHERE b.isDeleted = 0 and " + searchField + " = " + searchQuery + "").list();
            } else {
                l = getSession().createQuery("FROM Bill b WHERE b.isDeleted = 0 and " + searchField + " like '%" + searchQuery + "%'").list();
            }
            setAdminSearch(l);
        }
    }

    public String update() {
        String x = "";
        String returnPage = "";
        HttpSession ss = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        if (ss.getAttribute("bId") != null) {
            x = ss.getAttribute("bId").toString();
        }
        try {
            String sql = "update Bill set status = " + updateStatus + " where id = " + x;
            getSession().createSQLQuery(sql).executeUpdate();
            getSession().beginTransaction().commit();
            setResult("Change successful!");
            returnPage = "detail.xhtml?faces-redirect=true&detail=" + x;
        } catch (Exception ex) {
            setResult("Change Error!");
            if (ss.getAttribute("bId") != null) {
                Bill b = (Bill) ss.getAttribute("bId");
                returnPage = "detail.xhtml?faces-redirect=true&detail=" + b.getId();
            } else {
                setResult("Change Error! You must back to order page");
            }
        }
        return returnPage;
    }

    public void delete(Bill b) {
        String sql = "update Bill set IsDeleted = 1 where id = " + b.getId();
        getSession().createSQLQuery(sql).executeUpdate();
        getSession().beginTransaction().commit();
    }

    public void search() {
        HttpSession ss = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        if (ss.getAttribute("member") == null) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(BillBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            int id = ((Member) ss.getAttribute("member")).getId();
            try {
                Date d = new Date(orderedDate);
                setBillSearch(getSession().createQuery("FROM Bill b WHERE b.isDeleted = 0 and b.orderDate = '" + orderedDate + "' and b.memberId = " + id).list());
            } catch (Exception ex) {
                result = "Invalid date! Format is: mm/dd/yyyy";
            }
        }
    }

    public String currentSort(String s) {
        HttpSession ss = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        ss.setAttribute("currentSort", s);
        return "sort.xhtml?faces-redirect=true";
    }
}
