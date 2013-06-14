/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.bean.client;

import g3.bean.utility.DvdStoreHibernateUtil;
import g3.hibernate.entity.Dvd;
import g3.hibernate.entity.FileData;
import g3.bean.utility.AppConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.Query;
import org.hibernate.Session;
import g3.bean.other.CategoryManagedHelper;
import g3.hibernate.entity.Category;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author kiendv
 */
@ManagedBean
@SessionScoped
public class ShowProductBean {

    /**
     * Creates a new instance of ShowProductBean
     */
    Session session = null;
    private List<Dvd> dvdvideo;
    private List<Dvd> dvdmusic;
    private List<Dvd> dvdgame;
    private int page = 0; //offset = 2*10
    private int length = 0;
    private String sort;
    private List<Page> pageLinks;//paging links
    private String detailId;//for view detail
    private String detailType;//for view detail relation with
    private Dvd detail;
    private List<Dvd> others;
    private String query;
    private String trailerUrl;
    private int totalPage;
    private String txtSearch;
    private String changeIPP = "5";
    private String orderBy = "ModifiedDate";
    private String orderType = "ASC";
    //DucVM-Add
    private CategoryManagedHelper cate_helper;
    //DucVM-End

    public ShowProductBean() {
        cate_helper = CategoryManagedHelper.getInstance();
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getChangeIPP() {
        return changeIPP;
    }

    public void setChangeIPP(String changeIPP) {
        this.changeIPP = changeIPP;
    }

    public String getTxtSearch() {
        return txtSearch;
    }

    public void setTxtSearch(String txtSearch) {
        this.txtSearch = txtSearch;
    }

    public List<Dvd> getDvdvideo() {
        String sqlQuery = "FROM Dvd d WHERE d.type = 'movie' and d.isDeleted = 0 ORDER BY d.id DESC";
        return getSession().createQuery(sqlQuery).setFirstResult(getItemPerPage() * ((getPage()) - 1)).setMaxResults(getItemPerPage()).list();
    }

    public List<Dvd> getDvdmusic() {
        String sqlQuery = "FROM Dvd d WHERE d.type = 'music' and d.isDeleted = 0 ORDER BY d.id DESC";
        return getSession().createQuery(sqlQuery).setFirstResult(getItemPerPage() * ((getPage()) - 1)).setMaxResults(getItemPerPage()).list();
    }

    public List<Dvd> getDvdgame() {

        String sqlQuery = "FROM Dvd d WHERE d.type = 'game' and d.isDeleted = 0 ORDER BY d.id DESC";
        return getSession().createQuery(sqlQuery).setFirstResult(getItemPerPage() * ((getPage()) - 1)).setMaxResults(getItemPerPage()).list();
    }

    public Session getSession() {
        return DvdStoreHibernateUtil.getSessionFactory().openSession();
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getItemPerPage() {
//        FacesContext context = FacesContext.getCurrentInstance();
//
//        int itemsPerPage = AppConstant.ITEM_PER_PAGE;
//        Object temp = context.getExternalContext().getSessionMap().get(AppConstant.SESSION_KEY_IPP);
//        if (temp != null) {
//            itemsPerPage = Integer.parseInt(String.valueOf(temp));
//        }
        return Integer.parseInt(changeIPP);
    }

    public int getPage() {
        HttpServletRequest rq = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        try {
            page = Integer.parseInt(rq.getParameter("page"));
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

    public List<Page> getPageLinks() {
        HttpServletRequest rq = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String s = "";
        if (rq.getParameter("type") != null) {
            s = rq.getParameter("type");
        }
        int number = getLength(s) / getItemPerPage();
        if (number == 0) {
            number = 1;
        }
        pageLinks = new ArrayList<Page>();
        for (int i = 1; i < number + 1; i++) {
            pageLinks.add(new Page(i, "showproduct.xhtml?type=" + s + "&page=" + i));
        }
        return pageLinks;
    }

    public void setPageLinks(List<Page> pageLinks) {
        this.pageLinks = pageLinks;
    }

    public int getLength(String type) {
        return getSession().createQuery("FROM Dvd d WHERE d.isDeleted = 0 and d.type = '" + type + "'").list().size();
    }

    public String getSort() {
        HttpServletRequest rq = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String so = "";
        try {
            so = rq.getParameter("page");
            if (sort == "") {
                sort = "music";
            }
        } catch (Exception ex) {
            sort = "music";
        }
        return sort;
    }

    public String getDetailId() {
        HttpServletRequest rq = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String so = "";
        try {
            so = rq.getParameter("detail");
            if (detailId != "") {
                detailId = so.split("/")[0];
                setDetailType(so.split("/")[1]);
            } else {
                detailId = "1";
                setDetailType("music");
            }
        } catch (Exception ex) {
            detailId = "1";
            setDetailType("music");
        }
        return detailId;
    }

    public void setDetailId(String detailId) {
        this.detailId = detailId;
    }

    public Dvd getDetail() {
        String q = "FROM Dvd d WHERE d.isDeleted = 0 and d.id = " + getDetailId();
        Dvd d = (Dvd) getSession().createQuery(q).uniqueResult();
        return d;
    }

    public List<Dvd> getOthers() {
        String q = "FROM Dvd d WHERE d.isDeleted = 0 and d.type = '" + getDetailType() + "'";
        List<Dvd> d = getSession().createQuery(q).setMaxResults(4).list();
        return d;
    }

    public String getDetailType() {
        return detailType;
    }

    public void setDetailType(String detailType) {
        this.detailType = detailType;
    }

    public String getTrailerUrl() {
        try {
            Dvd d = getDetail();
            String q = "FROM FileData f WHERE f.isDeleted = 0 and f.id = " + d.getTrailerId();
            FileData f = (FileData) getSession().createQuery(q).uniqueResult();
            trailerUrl = f.getUrl();
        } catch (Exception ex) {
            trailerUrl = "";
        }
        return trailerUrl;
    }

    public List<Dvd> getTop3Game() {
        String sqlQuery = "FROM Dvd d WHERE d.isDeleted = 0 and d.type='" + AppConstant.DVD_TYPE_GAME + "'";
        return getSession().createQuery(sqlQuery).setMaxResults(3).list();
    }

    public List<Dvd> getTop3Movie() {
        String sqlQuery = "FROM Dvd d WHERE d.isDeleted = 0 and d.type='" + AppConstant.DVD_TYPE_MOVIE + "'";
        return getSession().createQuery(sqlQuery).setMaxResults(3).list();
    }

    public List<Dvd> getTop3Music() {
        String sqlQuery = "FROM Dvd d WHERE d.isDeleted = 0 and d.type='" + AppConstant.DVD_TYPE_MUSIC + "'";
        return getSession().createQuery(sqlQuery).setMaxResults(3).list();
    }

    public Dvd getProductDetails() {
        FacesContext context = FacesContext.getCurrentInstance();
        Map<String, String> params =
                context.getExternalContext().getRequestParameterMap();
        String id = params.get("productid");
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        request.getSession().setAttribute("productid", id);

        if (id == null) {
            context.responseComplete();
            context.getApplication().
                    getNavigationHandler().handleNavigation(context, null, "welcome");
            return null;
        } else {
            String hqlQuery = "From Dvd d Where d.id=" + id;
            return (Dvd) getSession().createQuery(hqlQuery).uniqueResult();
        }

    }

    public String execSearch() {
        FacesContext context = FacesContext.getCurrentInstance();
        Map<String, String> params =
                context.getExternalContext().getRequestParameterMap();
        String search = params.get("search");
        if (search.equals("begin")) {
            context.getExternalContext().getSessionMap().put("search", txtSearch);
            txtSearch = null;
        }
        return "cuslistproduct";
    }

    public List<Dvd> getProductList() {
        String outputQuery = null;
        boolean isCate = false;
        FacesContext context = FacesContext.getCurrentInstance();
        Map<String, String> params =
                context.getExternalContext().getRequestParameterMap();
        String search = params.get("search");
        int itemsPerPage = getItemPerPage();
        Category cate = null;
        if (search == null) {

            int currCateId = Integer.parseInt(params.get("cateId"));
            System.out.printf("id = " + currCateId);
            cate = cate_helper.searchById(currCateId);
//            cate_helper.close();
            outputQuery = cate.getQuery();
            isCate = true;
        } else {
            if ("begin".equals(search)) {
                search = (String) context.getExternalContext().getSessionMap().get("search");
            }
            outputQuery = "From Dvd d where d.title LIKE :search"
                    + " or d.genres LIKE  :search"
                    + " or d.author LIKE  :search";

        }
        if (isCate) {
            if (cate.getId() == 1) {
                outputQuery += " where DVD.IsDeleted=0";
            } else {
                outputQuery += " and DVD.IsDeleted=0";
            }


            return getSession().createSQLQuery(outputQuery).addEntity(Dvd.class).setFirstResult(itemsPerPage * ((getPage()) - 1)).setMaxResults(itemsPerPage).list();
        } else {
            outputQuery += " and d.isDeleted=0";
            return getSession().createQuery(outputQuery).setString("search", '%' + search + '%').setFirstResult(itemsPerPage * ((getPage()) - 1)).setMaxResults(itemsPerPage).list();
        }
    }

    public String toLowerCaseFisrtLetter(String source) {
        return Character.toLowerCase(source.charAt(0)) + (source.length() > 1 ? source.substring(1) : "");
    }

    public int getTotalPage() {
        String outputQuery = null;
        boolean isCate = false;
        FacesContext context = FacesContext.getCurrentInstance();
        Map<String, String> params =
                context.getExternalContext().getRequestParameterMap();
        int itemsPerPage = getItemPerPage();
        String search = params.get("search");
        Category cate = null;
        if (search == null) {
            int currCateId = Integer.parseInt(params.get("cateId"));
            System.out.printf("id = " + currCateId);
            cate = cate_helper.searchById(currCateId);
//            cate_helper.close();
            outputQuery = cate.getQuery();
            isCate = true;
        } else {
            if ("begin".equals(search)) {
                search = (String) context.getExternalContext().getSessionMap().get("search");
            }
            outputQuery = "From Dvd d where d.title LIKE :search"
                    + " or d.genres LIKE  :search"
                    + " or d.author LIKE  :search";

        }
        int total = 0;
        if (isCate) {

            if (cate.getId() == 1) {
                outputQuery += " where DVD.IsDeleted=0";
            } else {
                outputQuery += " and DVD.IsDeleted=0";
            }

            total = getSession().createSQLQuery(outputQuery).addEntity(Dvd.class).list().size();
        } else {
            outputQuery += " and d.isDeleted=0";
            total = getSession().createQuery(outputQuery).setString("search", '%' + search + '%').list().size();
        }
        totalPage = (total % itemsPerPage == 0) ? (total / itemsPerPage) : ((total / itemsPerPage) + 1);
        return totalPage == 0 ? 1 : totalPage;
    }

    public String getType() {
        FacesContext context = FacesContext.getCurrentInstance();
        Map<String, String> params =
                context.getExternalContext().getRequestParameterMap();
        return params.get("type");
    }

    public void valueChangeMethod(ValueChangeEvent e) {
    }

    public String changeItemPerPage() {
        FacesContext context = FacesContext.getCurrentInstance();
        String temp = changeIPP;
        context.getExternalContext().getSessionMap().put(AppConstant.SESSION_KEY_IPP, temp);
        return null;
    }
}
