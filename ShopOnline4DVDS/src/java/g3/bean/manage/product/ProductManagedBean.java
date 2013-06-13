/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.bean.manage.product;

import g3.bean.utility.AppConstant;
import g3.hibernate.entity.Album;
import g3.hibernate.entity.Dvd;
import g3.hibernate.entity.FileData;
import g3.hibernate.entity.Producer;
import g3.hibernate.entity.Supplier;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;

/**
 *
 * @author Administrator
 */
@ManagedBean
@SessionScoped
public class ProductManagedBean {

    private ProductManagedHelper helper;
    private Dvd curDvd;
    private int formMode;
    private String returnFromDetails;
    private Dvd searchDvd;
    private List<Dvd> resustSearch;
    private String supplier;
    private String producer;

    /**
     * Creates a new instance of ProductManagedBean
     */
    public ProductManagedBean() {
    }

    @PostConstruct
    public void init() {
        helper = ProductManagedHelper.getInstance();
    }

    @PreDestroy
    public void end() {
        helper.close();
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public List<Dvd> getResustSearch() {
        return resustSearch;
    }

    public void setResustSearch(List<Dvd> resustSearch) {
        this.resustSearch = resustSearch;
    }

    public Dvd getSearchDvd() {
        if (searchDvd == null) {
            searchDvd = new Dvd();
        }
        return searchDvd;
    }

    public String search() {

        if (searchDvd != null) {
//            resustSearch = helper.search(searchDvd);
            resustSearch = helper.search(searchDvd);
        }
        return null;
    }

    public void setSearchDvd(Dvd searchDvd) {
        this.searchDvd = searchDvd;
    }

    public int getMode() {
        return formMode;
    }

    public void setMode(int mode) {
        this.formMode = mode;
    }

    public Dvd getCurDvd() {
        return curDvd;
    }

    public void setCurDvd(Dvd curDvd) {
        this.curDvd = curDvd;
    }

    public String create() {
        curDvd = new Dvd();
        supplier = "";
        producer = "";
        formMode = AppConstant.FORM_MODE_CREATE;
        return "form";
    }

    public String edit(Dvd item) {
        curDvd = item;
        Supplier sup = (Supplier) helper.getSession().createCriteria(Supplier.class).add(Expression.eq("id", item.getSupplierId())).uniqueResult();
        Producer pro = (Producer) helper.getSession().createCriteria(Producer.class).add(Expression.eq("id", item.getProducerId())).uniqueResult();
        supplier = (sup == null ? "" : sup.getTitle());
        producer = (pro == null ? "" : pro.getTitle());
        formMode = AppConstant.FORM_MODE_EDIT;
        return "form";
    }

    public String details(Dvd item) {
        curDvd = item;
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        returnFromDetails = params.get("from");
        return "details";
    }

    public String back() {
        return returnFromDetails;
    }
//    public String getCriteria(){
//        if(searchDvd!=null){
//            Criteria criteria=helper.getCriteriaSearch(searchDvd);
//            return criteria.toString();
//        }
//        return "No criteria";
//    }

    public String save() {
        if (supplier != null && !supplier.equals("")) {
            Supplier inputSup = getOrCreateSupplier(supplier);
            curDvd.setSupplierId(inputSup.getId());
        }
        if (producer != null && !producer.equals("")) {
            Producer inputPro = getOrCreateProducer(producer);
            curDvd.setProducerId(inputPro.getId());
        }
        curDvd.setCreatedDate(new Date());
        curDvd.setModifiedDate(new Date());
        helper.save(curDvd);
        curDvd = null;
        return "show";
    }

    public String del(Dvd item) {
        item.setIsDeleted(true);
        item.setModifiedDate(new Date());
        helper.update(item);
        return null;
    }

    public String update() {
        if (supplier != null && !supplier.equals("")) {
            Supplier inputSup = getOrCreateSupplier(supplier);
            curDvd.setSupplierId(inputSup.getId());
        }
        if (producer != null && !producer.equals("")) {
            Producer inputPro = getOrCreateProducer(producer);
            curDvd.setProducerId(inputPro.getId());
        }
        curDvd.setModifiedDate(new Date());
        helper.update(curDvd);
        return "show";
    }

    public List<Dvd> getAllDvds() {
        return helper.getAllDvds();
    }

    public List<Dvd> getAllDvdsDeleted() {
        return helper.getAllDvdsDeleted();
    }

    public Map<String, Object> getListType() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(AppConstant.DVD_TYPE_MUSIC, AppConstant.DVD_TYPE_MUSIC);
        map.put(AppConstant.DVD_TYPE_MOVIE, AppConstant.DVD_TYPE_MOVIE);
        map.put(AppConstant.DVD_TYPE_GAME, AppConstant.DVD_TYPE_GAME);
        return map;
    }

    public Map<String, Object> getListTypeSearch() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("All", null);
        map.put(AppConstant.DVD_TYPE_MUSIC, AppConstant.DVD_TYPE_MUSIC);
        map.put(AppConstant.DVD_TYPE_MOVIE, AppConstant.DVD_TYPE_MOVIE);
        map.put(AppConstant.DVD_TYPE_GAME, AppConstant.DVD_TYPE_GAME);
        return map;
    }

    public Map<String, Object> getListProducer() {
        Map<String, Object> map = new HashMap<String, Object>();
        for (Producer producer : helper.getListProducer()) {
            map.put(producer.getTitle(), producer.getId());
        }

        return map;
    }

    public Map<String, Object> getListSupplier() {
        Map<String, Object> map = new HashMap<String, Object>();
        for (Supplier supplier : helper.getListSupplier()) {
            map.put(supplier.getTitle(), supplier.getId());
        }

        return map;
    }

    public String recovery(Dvd item) {
        item.setIsDeleted(false);
        item.setModifiedDate(new Date());
        helper.update(item);
        return "recovery";
    }

    public String cancel() {
        curDvd = new Dvd();
        return "show";
    }

    public String prepareMap(Dvd item) {
        curDvd = item;
        if (curDvd.getType().equals(AppConstant.DVD_TYPE_GAME)) {
            return "mappingtrailer";
        }
        if (curDvd.getType().equals(AppConstant.DVD_TYPE_MOVIE)) {
            return "mappingtrailer";
        }
        return "mappingalbum";
    }

    public String mappingAlbum(Album item) {
        curDvd.setAlbumId(item.getId());
        curDvd.setModifiedDate(new Date());
        helper.save(curDvd);
        return "details";
    }

    public String removeTrailerId() {
        curDvd.setTrailerId(null);
        curDvd.setModifiedDate(new Date());
        helper.save(curDvd);
        return "details";
    }

    public String removeAlbumId() {
        curDvd.setAlbumId(null);
        curDvd.setModifiedDate(new Date());
        helper.save(curDvd);
        return "details";
    }

    public String addFile(FileData file) {
        curDvd.setTrailerId(file.getId());
        curDvd.setModifiedDate(new Date());
        helper.update(curDvd);
        return "details";
    }

    public List<String> autoCompleteSupplier(String query) {
        Session session = helper.getSession();
        List<String> lst = new ArrayList<String>();
        if (query.length() > 2) {
            for (Object sup : session.createCriteria(Supplier.class).add(Expression.ilike("title", "%" + query + "%")).list()) {

                lst.add(((Supplier) sup).getTitle());
            }


        }
        return lst;
    }

    public Supplier getOrCreateSupplier(String title) {
        Session session = helper.getSession();
        Supplier getSup = (Supplier) session.createCriteria(Supplier.class).add(Expression.eq("title", title)).uniqueResult();
        if (getSup != null) {
            return getSup;
        }
        getSup = new Supplier();
        getSup.setTitle(title);
        getSup.setCreatedDate(new Date());
        getSup.setModifiedDate(new Date());
        getSup.setIsDeleted(false);
        session.save(getSup);
        return getSup;
    }

    public List<String> autoCompleteProducer(String query) {
        Session session = helper.getSession();
        List<String> lst = new ArrayList<String>();
        if (query.length() > 2) {
            for (Object pro : session.createCriteria(Producer.class).add(Expression.ilike("title", "%" + query + "%")).list()) {

                lst.add(((Producer) pro).getTitle());
            }


        }
        return lst;
    }

    public Producer getOrCreateProducer(String title) {
        Session session = helper.getSession();
        Producer getPro = (Producer) session.createCriteria(Producer.class).add(Expression.eq("title", title)).uniqueResult();
        if (getPro != null) {
            return getPro;
        }
        getPro = new Producer();
        getPro.setTitle(title);
        getPro.setCreatedDate(new Date());
        getPro.setModifiedDate(new Date());
        getPro.setIsDeleted(false);
        session.save(getPro);
        return getPro;
    }
}
