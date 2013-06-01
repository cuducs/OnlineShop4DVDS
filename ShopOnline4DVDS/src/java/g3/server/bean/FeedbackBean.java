/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.server.bean;

import g3.hibernate.entity.Feedback;
import g3.hibernate.entity.Member;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;

/**
 *
 * @author kiendv
 */
@ManagedBean
@RequestScoped
public class FeedbackBean {

    /**
     * Creates a new instance of FeedbackBean
     */
    private String content;
    private String result;
    private List<Feedback> fbSearch;
    private List<Feedback> fbAdmin;
    private int itemsPerPage = 100;//for paging
    private int page = 0; //offset = 2*10
    private int length = 0;
    private List<Page> pageLinks;//paging links
    private Feedback detail;//detail object
    private String detailId;//Id to view detail
    private String updateStatus;//for update
    private String searchField;//for search
    private String searchQuery;//for search
    private List<Page> sortLinks;//paging links sorted
    private Member customer;

    public FeedbackBean() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Session getSession() {
        return DvdStoreHibernateUtil.getSessionFactory().openSession();
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<Feedback> getFbSearch() {
        return fbSearch;
    }

    public void setFbSearch(List<Feedback> fbSearch) {
        this.fbSearch = fbSearch;
    }

    public List<Feedback> getFbAdmin() {
        String sqlQuery = "FROM Feedback f where f.isDeleted = 0";
        return getSession().createQuery(sqlQuery).setFirstResult(itemsPerPage * ((getPage()) - 1)).setMaxResults(itemsPerPage).list();
    }

    public void setFbAdmin(List<Feedback> fbAdmin) {
        this.fbAdmin = fbAdmin;
    }

    public int getItemsPerPage() {
        return itemsPerPage;
    }

    public void setItemsPerPage(int itemsPerPage) {
        this.itemsPerPage = itemsPerPage;
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

    public void setPage(int page) {
        this.page = page;
    }

    public int getLength() {
        return getSession().createQuery("FROM Feedback f WHERE f.isDeleted = 0").list().size();
    }

    public void setLength(int length) {
        this.length = length;
    }

    public List<Page> getPageLinks() {
        int number = getLength() / itemsPerPage;
        if (number == 0) {
            number = 1;
        }
        pageLinks = new ArrayList<Page>();
        for (int i = 1; i < number + 2; i++) {
            pageLinks.add(new Page(i, "show.xhtml?page=" + i));
        }
        return pageLinks;
    }

    public void setPageLinks(List<Page> pageLinks) {
        this.pageLinks = pageLinks;
    }

    public Feedback getDetail() {
        HttpSession ss = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        Feedback b = (Feedback) ss.getAttribute("feedback");
        return b;
    }

    public void setDetailId(String detailId) {
        this.detailId = detailId;
    }

    public String getUpdateStatus() {
        return updateStatus;
    }

    public void setUpdateStatus(String updateStatus) {
        this.updateStatus = updateStatus;
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

    public void setSortLinks(List<Page> sortLinks) {
        this.sortLinks = sortLinks;
    }

    public Member getCustomer() {
        try {
            customer = (Member) getSession().createQuery("FROM Member m WHERE m.id = " + getDetail().getCustomerId()).uniqueResult();

        } catch (Exception ex) {
            customer = null;
        }
        return customer;
    }

    public Member getName(String name) {
        Member m = null;
        try {
            m = (Member) getSession().createQuery("FROM Member m WHERE m.name = '" + name + "'").uniqueResult();
        } catch (Exception ex) {
            m = new Member(0, 0);
        }
        return m;
    }

    public String getDetailId() {
        HttpServletRequest rq = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        try {
            detailId = rq.getParameter("detail");
            if (detailId == null || detailId == "") {
                detailId = "1";
            } else {
                Feedback f = (Feedback) getSession().createQuery("FROM Feedback f WHERE f.isDeleted = 0 and f.id=" + detailId).uniqueResult();
                if (f == null) {
                    result = "Not fount ID: " + detailId;
                } else {
                    HttpSession ss = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                    ss.setAttribute("feedback", f);
                }
            }
        } catch (Exception ex) {
            detailId = "1";
        }
        return detailId;
    }

    /**
     * **************Functions******************
     */
    public void send() {
        try {
            HttpSession ss = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            if (ss.getAttribute("member") == null) {
                result = "You have to relogin.";
            } else {
                if (content == "" || content.length() < 10) {
                    result = "Invalid content, content must be larger 10 chars.";
                } else {
                    int customerId = ((Member) ss.getAttribute("member")).getId();
                    String sql = "insert into Feedback values (" + customerId + ", '" + DvdStoreHibernateUtil.currenrTime() + "', N'" + content + "', 0, N'', '" + DvdStoreHibernateUtil.currenrTime() + "', '" + DvdStoreHibernateUtil.currenrTime() + "', 0)";
                    getSession().createSQLQuery(sql).executeUpdate();
                    getSession().beginTransaction().commit();
                    result = "1";//Thank for your feedback!";
                }
            }
        } catch (Exception ex) {
            result = "Error, cannot send feedback, please contact to admin.";
        }
    }

    private int sortLength(String s) {
        return getSession().createQuery("FROM Bill b WHERE b.isDeleted = 0 and b.isRead = " + s).list().size();
    }

    public void delete(Feedback b) {
        String sql = "update Feedback set IsDeleted = 1 where id = " + b.getId();
        getSession().createSQLQuery(sql).executeUpdate();
        getSession().beginTransaction().commit();
    }

    public void searchAdmin() {
        if (searchField != null) {
            String qr = "";
            List<Feedback> l = new ArrayList<Feedback>();
            if (searchField.equals("submittedDate") || searchField.equals("modifiedDate")) {
                qr = "FROM Feedback b WHERE b.isDeleted = 0 and " + searchField + " = '" + searchQuery + "'";
            }
            if (searchField.equals("id")) {
                qr = "FROM Feedback b WHERE b.isDeleted = 0 and b.id = " + searchQuery + "";
            }
            if (searchField.equals("customerName")) {
                qr = "FROM Feedback b WHERE b.isDeleted = 0 and b.customerId = " + getName(searchQuery).getId();
            }
            if (searchField.equals("read")) {
                qr = "FROM Feedback b WHERE b.isDeleted = 0 and b.isRead = 0";
            }
            if (searchField.equals("unread")) {
                qr = "FROM Feedback b WHERE b.isDeleted = 0 and b.isRead = 0";
            }
            if (qr != "") {
                try{
                l = getSession().createQuery(qr).list();
                }catch(Exception ex){
                    l = null;
                }
            }
            fbSearch = l;
        }
    }

    public String reply() {
        int x = 0;
        String returnPage = "";
        Feedback b = null;
        HttpSession ss = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        if (ss.getAttribute("feedback") != null) {
            b = (Feedback) ss.getAttribute("feedback");
            x = b.getId();
        }
        try {
            String sql = "update Feedback set IsRead = 1, ReplyText = N'" + updateStatus + "', ModifiedDate = '" + DvdStoreHibernateUtil.currenrTime() + "' where id = " + x;
            getSession().createSQLQuery(sql).executeUpdate();
            getSession().beginTransaction().commit();
            result = "1";
            b.setIsRead(Boolean.TRUE);
            ss.setAttribute("feedback", b);
            returnPage = "detail.xhtml?faces-redirect=true&detail=" + x;
        } catch (Exception ex) {
            result = "0";
        }
        return returnPage;
    }
}
