/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.bean.client;

import g3.bean.utility.AppConstant;
import g3.hibernate.entity.Browser;
import g3.hibernate.entity.BrowserMenu;
import g3.hibernate.entity.Dvd;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Administrator
 */
@ManagedBean
@SessionScoped
public class BrowserManagedBean {

    private Browser curBrowser;
    private int formMode;
    private BrowserManagedHelper helper;
    private String returnFromDetails;
    private Browser searchBrowser;
    private List<Browser> resustSearch;

    /**
     * Creates a new instance of FileManagedBean
     */
    public BrowserManagedBean() {
    }

    @PostConstruct
    public void init() {
        helper = BrowserManagedHelper.getInstance();
    }

    @PreDestroy
    public void end() {
        helper.close();
    }

    public List<Browser> getResustSearch() {
        return resustSearch;
    }

    public void setResustSearch(List<Browser> resustSearch) {
        this.resustSearch = resustSearch;
    }

    public Browser getSearchBrowser() {
        if (searchBrowser == null) {
            searchBrowser = new Browser();
        }
        return searchBrowser;
    }

    public String search() {

        if (searchBrowser != null) {
            resustSearch = helper.search(searchBrowser);
        }
        return null;
    }

    public void setSearchBrowser(Browser searchBrowser) {
        this.searchBrowser = searchBrowser;
    }

    public int getMode() {
        return formMode;
    }

    public void setMode(int mode) {
        this.formMode = mode;
    }

    public Browser getCurBrowser() {
        return curBrowser;
    }

    public void setCurBrowser(Browser curBrowser) {
        this.curBrowser = curBrowser;
    }

    public String create() {
        curBrowser = new Browser();
        formMode = AppConstant.FORM_MODE_CREATE;
        return "form";
    }

    public String edit(Browser item) {
        curBrowser = item;
        formMode = AppConstant.FORM_MODE_EDIT;
        return "form";
    }

    public String details(Browser item) {
        curBrowser = item;
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        returnFromDetails = params.get("from");
        return "details";
    }

    public String back() {
        return returnFromDetails;
    }

    public String save() {
        helper.save(curBrowser);
        curBrowser = null;
        return "show";
    }

    public String del(Browser item) {
        helper.del(item);
        return "show";
    }

    public String update() {
        helper.update(curBrowser);
        return "show";
    }

    public List<Browser> getAllBrowsers() {
        return helper.getAllBrowsers();
    }

    public String cancel() {
        curBrowser = new Browser();
        return "show";
    }

    public List<Dvd> execQuery() {
        Session session = helper.getSession();
        Query query = session.createQuery(curBrowser.getQuerySearch());
        return query.list();
    }

    public Map<String, Object> getListParent() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Browser> lst = getAllBrowsers();
        map.put("None", 0);
        for (Browser browser : lst) {
            map.put(browser.getTitle(), browser.getId());
        }
        return map;
    }

    public Map<String, Object> getListParentSearch() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Browser> lst = getAllBrowsers();
        map.put("All", null);
        map.put("None", 0);
        for (Browser browser : lst) {
            map.put(browser.getTitle(), browser.getId());
        }
        return map;
    }
    private BrowserMenu browserMenu;

    public void setBrowserMenu(BrowserMenu browserMenu) {
        this.browserMenu = browserMenu;
    }

    public BrowserMenu getBrowserMenu() {
        if (browserMenu == null) {
            browserMenu = new BrowserMenu();
            List<Browser> list = helper.getSession().createQuery("From Browser b where b.parentId=0").list();
            browserMenu.setMenuLv1(list);
            for (Browser browser : list) {
                browserMenu.getMenuLv2().put(browser.getId(), getMenuLevel2(browser));
            }

        }

        return browserMenu;
    }

    public List<Browser> getMenuLevel2(Browser browserParent) {
        return helper.getSession().createQuery("From Browser b where b.parentId=" + browserParent.getId()).list();
    }
    private List<Dvd> browserDvd;

    public List<Dvd> getBrowserDvd() {
        if(browserDvd==null){
            return helper.getSession().createQuery("From Dvd d where d.isDeleted=0").list();
        }
        return browserDvd;
    }

    public void setBrowserDvd(List<Dvd> browserDvd) {
        this.browserDvd = browserDvd;
    }
    
    public String browser(Browser browser){
        browserDvd=helper.getSession().createQuery(browser.getQuerySearch()).list();
        return "showproduct";
    }
}
