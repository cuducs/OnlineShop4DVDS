/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.bean.security;

import g3.bean.utility.AppConstant;
import g3.hibernate.entity.Manage;
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
public class ManageManagedBean {

    private Manage curManage;
    private int formMode;
    private ManageManagedHelper helper;
    private String returnFromDetails;
    private Manage searchManage;
    private List<Manage> resustSearch;

    /**
     * Creates a new instance of MusicManagedBean
     */
    public ManageManagedBean() {
    }

    @PostConstruct
    public void init() {
        helper = ManageManagedHelper.getInstance();
    }

    @PreDestroy
    public void end() {
        helper.close();
    }

    public List<Manage> getResustSearch() {
        return resustSearch;
    }

    public void setResustSearch(List<Manage> resustSearch) {
        this.resustSearch = resustSearch;
    }

    public Manage getSearchManage() {
        if (searchManage == null) {
            searchManage = new Manage();
        }
        return searchManage;
    }

    public String search() {

        if (searchManage != null) {
            resustSearch = helper.search(searchManage);
        }
        return null;
    }

    public void setSearchManage(Manage searchManage) {
        this.searchManage = searchManage;
    }

    public int getMode() {
        return formMode;
    }

    public void setMode(int mode) {
        this.formMode = mode;
    }

    public Manage getCurManage() {
        return curManage;
    }

    public void setCurManage(Manage curManage) {
        this.curManage = curManage;
    }

    public String create() {
        curManage = new Manage();
        formMode = AppConstant.FORM_MODE_CREATE;
        return "form";
    }

    public String edit(Manage item) {
        curManage = item;
        formMode = AppConstant.FORM_MODE_EDIT;
        return "form";
    }

    public String details(Manage item) {
        curManage = item;
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        returnFromDetails = params.get("from");
        return "details";
    }

    public String save() {
        curManage.setCreatedDate(new Date());
        curManage.setModifiedDate(new Date());
        helper.save(curManage);
        curManage = null;
        return "show";
    }

    public String del(Manage item) {
        item.setIsLock(true);
        item.setModifiedDate(new Date());
        helper.update(item);
        return "show";
    }

    public String update() {
        curManage.setModifiedDate(new Date());
        helper.update(curManage);
        return "show";
    }

    public List<Manage> getAllManages() {
        return helper.getAllManages();
    }

    public List<Manage> getAllManagesDeleted() {
        return helper.getAllManagesDeleted();
    }

    public String recovery(Manage item) {
        item.setIsLock(false);
        item.setModifiedDate(new Date());
        helper.update(item);
        return "recovery";
    }

    public String cancel() {
        curManage = new Manage();
        return "show";
    }
}
