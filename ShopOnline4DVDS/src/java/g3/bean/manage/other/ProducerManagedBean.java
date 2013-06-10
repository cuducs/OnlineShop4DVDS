/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.bean.manage.other;

import g3.bean.utility.AppConstant;
import g3.hibernate.entity.Producer;
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
public class ProducerManagedBean {

    private Producer curProducer;
    private int formMode;
    private ProducerManagedHelper helper;
    private String returnFromDetails;
    private Producer searchProducer;
    private List<Producer> resustSearch;

    /**
     * Creates a new instance of MusicManagedBean
     */
    public ProducerManagedBean() {
    }

    @PostConstruct
    public void init() {
        helper = ProducerManagedHelper.getInstance();
    }

    @PreDestroy
    public void end() {
        helper.close();
    }

    public List<Producer> getResustSearch() {
        return resustSearch;
    }

    public void setResustSearch(List<Producer> resustSearch) {
        this.resustSearch = resustSearch;
    }

    public Producer getSearchProducer() {
        if (searchProducer == null) {
            searchProducer = new Producer();
        }
        return searchProducer;
    }

    public String search() {

        if (searchProducer != null) {
            resustSearch = helper.search(searchProducer);
        }
        return null;
    }

    public void setSearchProducer(Producer searchProducer) {
        this.searchProducer = searchProducer;
    }

    public int getMode() {
        return formMode;
    }

    public void setMode(int mode) {
        this.formMode = mode;
    }

    public Producer getCurProducer() {
        return curProducer;
    }

    public void setCurProducer(Producer curProducer) {
        this.curProducer = curProducer;
    }

    public String create() {
        curProducer = new Producer();
        formMode = AppConstant.FORM_MODE_CREATE;
        return "form";
    }

    public String edit(Producer item) {
        curProducer = item;
        formMode = AppConstant.FORM_MODE_EDIT;
        return "form";
    }

    public String details(Producer item) {
        curProducer = item;
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        returnFromDetails = params.get("from");
        return "details";
    }

    public String save() {
        curProducer.setCreatedDate(new Date());
        curProducer.setModifiedDate(new Date());
        helper.save(curProducer);
        curProducer = null;
        return "show";
    }

    public String del(Producer item) {
        item.setIsDeleted(true);
        item.setModifiedDate(new Date());
        helper.update(item);
        return null;
    }

    public String update() {
        curProducer.setModifiedDate(new Date());
        helper.update(curProducer);
        return "show";
    }

    public List<Producer> getAllProducers() {
        return helper.getAllProducers();
    }

    public List<Producer> getAllProducersDeleted() {
        return helper.getAllProducersDeleted();
    }

    public String recovery(Producer item) {
        item.setIsDeleted(false);
        item.setModifiedDate(new Date());
        helper.update(item);
        return null;
    }

    public String cancel() {
        curProducer = new Producer();
        return "show";
    }
}
