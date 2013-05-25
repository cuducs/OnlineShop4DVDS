/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.server.bean;

import g3.hibernate.entity.Dvd;
import g3.hibernate.entity.Game;
import java.util.Date;
import java.util.HashMap;
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
public class ProductManagedBean {

    private ProductManagedHelper helper;
    private Dvd curDvd;
    private int formMode;
    private String returnFromDetails;
    private Dvd searchDvd;
    private List<Dvd> resustSearch;
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
        curDvd = new Dvd(0, false);
        formMode = AppConstant.FORM_MODE_CREATE;
        return "form";
    }

    public String edit(Dvd item) {
        curDvd = item;
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

    public String save() {
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
        return "show";
    }

    public String update() {
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
    public Map<String,Object> getListType(){
        Map<String,Object> map=new HashMap<String, Object>();
        map.put(AppConstant.DVD_TYPE_MUSIC, AppConstant.DVD_TYPE_MUSIC);
        map.put(AppConstant.DVD_TYPE_MOVIE, AppConstant.DVD_TYPE_MOVIE);
        map.put(AppConstant.DVD_TYPE_GAME, AppConstant.DVD_TYPE_GAME);
        return map;
    }
    public String recovery(Dvd item) {
        item.setIsDeleted(false);
        item.setModifiedDate(new Date());
        helper.update(item);
        return "recovery";
    }
    public String cancel(){
        curDvd=new Dvd();
        return "show";
    }
    public String prepareMap(Dvd item){
        if(item.getDetailId()!=null){
            return "details";
        }
        curDvd=item;
        
        return "mappinggame";
    }
    public String removeDetails(){
        curDvd.setDetailId(null);
        curDvd.setModifiedDate(new Date());
        helper.save(curDvd);
        return null;
    }
    public String mappingGame(Game item){
        curDvd.setDetailId(item.getId());
        curDvd.setModifiedDate(new Date());
        helper.save(curDvd);
        return "productdetails";
    }
}
