/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.bean.manage.other;

import g3.bean.utility.AppConstant;
import g3.hibernate.entity.Supplier;
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
public class SupplierManagedBean {

    private Supplier curSupplier;
    private int formMode;
    private SupplierManagedHelper helper;
    private String returnFromDetails;
    private Supplier searchSupplier;
    private List<Supplier> resustSearch;

    /**
     * Creates a new instance of MusicManagedBean
     */
    public SupplierManagedBean() {
    }

    @PostConstruct
    public void init() {
        helper = SupplierManagedHelper.getInstance();
    }

    @PreDestroy
    public void end() {
        helper.close();
    }

    public List<Supplier> getResustSearch() {
        return resustSearch;
    }

    public void setResustSearch(List<Supplier> resustSearch) {
        this.resustSearch = resustSearch;
    }

    public Supplier getSearchSupplier() {
        if (searchSupplier == null) {
            searchSupplier = new Supplier();
        }
        return searchSupplier;
    }

    public String search() {

        if (searchSupplier != null) {
            resustSearch = helper.search(searchSupplier);
        }
        return null;
    }

    public void setSearchSupplier(Supplier searchSupplier) {
        this.searchSupplier = searchSupplier;
    }

    public int getMode() {
        return formMode;
    }

    public void setMode(int mode) {
        this.formMode = mode;
    }

    public Supplier getCurSupplier() {
        return curSupplier;
    }

    public void setCurSupplier(Supplier curSupplier) {
        this.curSupplier = curSupplier;
    }

    public String create() {
        curSupplier = new Supplier();
        formMode = AppConstant.FORM_MODE_CREATE;
        return "form";
    }

    public String edit(Supplier item) {
        curSupplier = item;
        formMode = AppConstant.FORM_MODE_EDIT;
        return "form";
    }

    public String details(Supplier item) {
        curSupplier = item;
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        returnFromDetails = params.get("from");
        return "details";
    }

    public String save() {
        curSupplier.setCreatedDate(new Date());
        curSupplier.setModifiedDate(new Date());
        helper.save(curSupplier);
        curSupplier = null;
        return "show";
    }

    public String del(Supplier item) {
        item.setIsDeleted(true);
        item.setModifiedDate(new Date());
        helper.update(item);
        return null;
    }

    public String update() {
        curSupplier.setModifiedDate(new Date());
        helper.update(curSupplier);
        return "show";
    }

    public List<Supplier> getAllSuppliers() {
        return helper.getAllSuppliers();
    }

    public List<Supplier> getAllSuppliersDeleted() {
        return helper.getAllSuppliersDeleted();
    }

    public String recovery(Supplier item) {
        item.setIsDeleted(false);
        item.setModifiedDate(new Date());
        helper.update(item);
        return null;
    }

    public String cancel() {
        curSupplier = new Supplier();
        return "show";
    }
}
