/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.bean.security;

import g3.bean.utility.AppConstant;
import g3.hibernate.entity.Manage;
import g3.hibernate.entity.Permission;
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
public class PermissionManagedBean {

    private Permission curPermission;
    private int formMode;
    private PermissionManagedHelper helper;
    private String returnFromDetails;
    private Permission searchPermission;
    private List<Permission> resustSearch;

    /**
     * Creates a new instance of MusicManagedBean
     */
    public PermissionManagedBean() {
    }

    @PostConstruct
    public void init() {
        helper = PermissionManagedHelper.getInstance();
    }

    @PreDestroy
    public void end() {
        helper.close();
    }

    public List<Permission> getResustSearch() {
        return resustSearch;
    }

    public void setResustSearch(List<Permission> resustSearch) {
        this.resustSearch = resustSearch;
    }

    public Permission getSearchPermission() {
        if (searchPermission == null) {
            searchPermission = new Permission();
        }
        return searchPermission;
    }

    public String search() {

        if (searchPermission != null) {
            resustSearch = helper.search(searchPermission);
        }
        return null;
    }

    public void setSearchPermission(Permission searchPermission) {
        this.searchPermission = searchPermission;
    }

    public int getMode() {
        return formMode;
    }

    public void setMode(int mode) {
        this.formMode = mode;
    }

    public Permission getCurPermission() {
        return curPermission;
    }

    public void setCurPermission(Permission curPermission) {
        this.curPermission = curPermission;
    }

    public String create() {
        curPermission = new Permission();
        formMode = AppConstant.FORM_MODE_CREATE;
        return "form";
    }

    public String edit(Permission item) {
        curPermission = item;
        formMode = AppConstant.FORM_MODE_EDIT;
        return "form";
    }

    public String details(Permission item) {
        curPermission = item;
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        returnFromDetails = params.get("from");
        return "details";
    }

    public String save() {
        curPermission.setPosition(ManageManagedBean.MANAGE_POSITION_NORMAL);
        curPermission.setCreatedDate(new Date());
        curPermission.setModifiedDate(new Date());
        helper.save(curPermission);
        curPermission = null;
        return "show";
    }

    public String del(Permission item) {
        item.setIsDeleted(true);
        item.setModifiedDate(new Date());
        helper.update(item);
        return "show";
    }

    public String update() {
        curPermission.setModifiedDate(new Date());
        helper.update(curPermission);
        return "show";
    }

    public List<Permission> getAllPermissions() {
        return helper.getAllPermissions();
    }

    public List<Permission> getAllPermissionsDeleted() {
        return helper.getAllPermissionsDeleted();
    }

    public String recovery(Permission item) {
        item.setIsDeleted(false);
        item.setModifiedDate(new Date());
        helper.update(item);
        return "recovery";
    }

    public String cancel() {
        curPermission = new Permission();
        return "show";
    }

    public String prepareAddPer(Permission item) {
        curPermission = item;
        return "addpermission";
    }

    public String addPer(Permission item) {
        helper.addPer(curPermission, item);
        return null;
    }

    public String removePer(Permission item) {
        helper.removePer(curPermission, item);
        return null;
    }

    public List<Permission> getListPerAdded() {
        return helper.getListPerAdded(curPermission);
    }

    public List<Permission> getListPerCanAdd() {
        return helper.getListPerCanAdd(curPermission);
    }

}
