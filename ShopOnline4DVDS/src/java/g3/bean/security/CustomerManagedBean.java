/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.bean.security;

import g3.bean.utility.AppConstant;
import g3.hibernate.entity.Member;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Administrator
 */
@ManagedBean
@SessionScoped
public class CustomerManagedBean {

    private Member curCustomer;
    private int formMode;
    private CustomerManagedHelper helper;
    private String returnFromDetails;
    private Member searchCustomer;
    private List<Member> resustSearch;

    /**
     * Creates a new instance of MusicManagedBean
     */
    public CustomerManagedBean() {
    }

    @PostConstruct
    public void init() {
        helper = CustomerManagedHelper.getInstance();
    }

    @PreDestroy
    public void end() {
        helper.close();
    }

    public List<Member> getResustSearch() {
        return resustSearch;
    }

    public void setResustSearch(List<Member> resustSearch) {
        this.resustSearch = resustSearch;
    }

    public Member getSearchCustomer() {
        if (searchCustomer == null) {
            searchCustomer = new Member();
        }
        return searchCustomer;
    }

    public String search() {

        if (searchCustomer != null) {
            resustSearch = helper.search(searchCustomer);
        }
        return null;
    }

    public void setSearchCustomer(Member searchCustomer) {
        this.searchCustomer = searchCustomer;
    }

    public int getMode() {
        return formMode;
    }

    public void setMode(int mode) {
        this.formMode = mode;
    }

    public Member getCurCustomer() {
        return curCustomer;
    }

    public void setCurCustomer(Member curCustomer) {
        this.curCustomer = curCustomer;
    }

    public String details(Member item) {
        curCustomer = item;
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        returnFromDetails = params.get("from");
        return "details";
    }

    public String del(Member item) {
        item.setIsLock(true);
        item.setModifiedDate(new Date());
        helper.update(item);
        return "show";
    }

    public String recovery(Member item) {
        item.setIsLock(false);
        item.setModifiedDate(new Date());
        helper.update(item);
        return null;
    }

    public String cancel() {
        curCustomer = new Member();
        return "show";
    }
}
