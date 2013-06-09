/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.bean.manage.other;

import g3.bean.utility.AppConstant;
import g3.hibernate.entity.Promotion;
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
public class PromotionManagedBean {
private Promotion curPromotion;
    private int formMode;
    private PromotionManagedHelper helper;
    private String returnFromDetails;
    private Promotion searchPromotion;
    private List<Promotion> resustSearch;

    /**
     * Creates a new instance of MusicManagedBean
     */
    public PromotionManagedBean() {
    }

    @PostConstruct
    public void init() {
        helper = PromotionManagedHelper.getInstance();
    }

    @PreDestroy
    public void end() {
        helper.close();
    }

    public List<Promotion> getResustSearch() {
        return resustSearch;
    }

    public void setResustSearch(List<Promotion> resustSearch) {
        this.resustSearch = resustSearch;
    }

    public Promotion getSearchPromotion() {
        if (searchPromotion == null) {
            searchPromotion = new Promotion();
        }
        return searchPromotion;
    }

    public String search() {

        if (searchPromotion != null) {
            resustSearch = helper.search(searchPromotion);
        }
        return null;
    }

    public void setSearchPromotion(Promotion searchPromotion) {
        this.searchPromotion = searchPromotion;
    }

    public int getMode() {
        return formMode;
    }

    public void setMode(int mode) {
        this.formMode = mode;
    }

    public Promotion getCurPromotion() {
        return curPromotion;
    }

    public void setCurPromotion(Promotion curPromotion) {
        this.curPromotion = curPromotion;
    }

    public String create() {
        curPromotion = new Promotion();
        formMode = AppConstant.FORM_MODE_CREATE;
        return "form";
    }

    public String edit(Promotion item) {
        curPromotion = item;
        formMode = AppConstant.FORM_MODE_EDIT;
        return "form";
    }

    public String details(Promotion item) {
        curPromotion = item;
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        returnFromDetails = params.get("from");
        return "details";
    }

    public String save() {
        curPromotion.setCreatedDate(new Date());
        curPromotion.setModifiedDate(new Date());
        helper.save(curPromotion);
        curPromotion = null;
        return "show";
    }

    public String del(Promotion item) {
        item.setIsDeleted(true);
        item.setModifiedDate(new Date());
        helper.update(item);
        return "show";
    }

    public String update() {
        curPromotion.setModifiedDate(new Date());
        helper.update(curPromotion);
        return "show";
    }

    public List<Promotion> getAllPromotions() {
        return helper.getAllPromotions();
    }

    public List<Promotion> getAllPromotionsDeleted() {
        return helper.getAllPromotionsDeleted();
    }

    public String recovery(Promotion item) {
        item.setIsDeleted(false);
        item.setModifiedDate(new Date());
        helper.update(item);
        return "recovery";
    }

    public String cancel() {
        curPromotion = new Promotion();
        return "show";
    }
}
