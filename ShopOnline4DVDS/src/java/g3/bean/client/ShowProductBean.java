/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.bean.client;

import g3.bean.utility.DvdStoreHibernateUtil;
import g3.hibernate.entity.Dvd;
import g3.hibernate.entity.FileData;
import g3.bean.utility.AppConstant;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.Query;
import org.hibernate.Session;
import g3.bean.other.CategoryManagedHelper;
import g3.hibernate.entity.Category;

/**
 *
 * @author kiendv
 */
@ManagedBean
@RequestScoped
public class ShowProductBean {

    /**
     * Creates a new instance of ShowProductBean
     */
    Session session = null;
    private List<Dvd> dvdvideo;
    private List<Dvd> dvdmusic;
    private List<Dvd> dvdgame;
    private int itemsPerPage = 1;//for paging
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
    //DucVM-Add
    private CategoryManagedHelper cate_helper;
    //DucVM-End

    public ShowProductBean() {
        cate_helper = CategoryManagedHelper.getInstance();
    }

    public List<Dvd> getDvdvideo() {
        String sqlQuery = "FROM Dvd d WHERE d.type = 'movie' and d.isDeleted = 0 ORDER BY d.id DESC";
        return getSession().createQuery(sqlQuery).setFirstResult(itemsPerPage * ((getPage()) - 1)).setMaxResults(itemsPerPage).list();
    }

    public List<Dvd> getDvdmusic() {
        String sqlQuery = "FROM Dvd d WHERE d.type = 'music' and d.isDeleted = 0 ORDER BY d.id DESC";
        return getSession().createQuery(sqlQuery).setFirstResult(itemsPerPage * ((getPage()) - 1)).setMaxResults(itemsPerPage).list();
    }

    public List<Dvd> getDvdgame() {
        String sqlQuery = "FROM Dvd d WHERE d.type = 'game' and d.isDeleted = 0 ORDER BY d.id DESC";
        return getSession().createQuery(sqlQuery).setFirstResult(itemsPerPage * ((getPage()) - 1)).setMaxResults(itemsPerPage).list();
    }

    public Session getSession() {
        return DvdStoreHibernateUtil.getSessionFactory().openSession();
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
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
        int number = getLength(s) / itemsPerPage;
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

    public List<Dvd> getProductList() {
        //DucVM - Add
//        FacesContext context = FacesContext.getCurrentInstance();
//        Map<String, String> params =
//                context.getExternalContext().getRequestParameterMap();
//        String type = params.get("type");
//        String hqlQuery = "From Dvd d Where d.isDeleted=0 ";
//        if (!type.equals(AppConstant.DVD_TYPE_ALL)) {
//            hqlQuery += " and d.type='" + type + "'";
//        }
//        Query query = getSession().createQuery(hqlQuery).setFirstResult(itemsPerPage * ((getPage()) - 1)).setMaxResults(itemsPerPage);
//        return query.list();

        try {
            FacesContext context = FacesContext.getCurrentInstance();
            Map<String, String> params =
                    context.getExternalContext().getRequestParameterMap();
            int currCateId = Integer.parseInt(params.get("cateId"));
            System.out.printf("id = " + currCateId);
            Category cate = cate_helper.searchById(currCateId);
//            cate_helper.close();
            return cate_helper.getProductsInCateDetail(cate, getPage(), itemsPerPage);
        } catch (Exception ex) {
            //show all :
            String hqlQuery = "From Dvd d Where d.isDeleted=0 ";
            Query query = getSession().createQuery(hqlQuery).setFirstResult(itemsPerPage * ((getPage()) - 1)).setMaxResults(itemsPerPage);
            return query.list();
        }

        //DucVM - End
    }

    public int getTotalPage() {

        FacesContext context = FacesContext.getCurrentInstance();
        Map<String, String> params =
                context.getExternalContext().getRequestParameterMap();
        int currCateId = Integer.parseInt(params.get("cateId"));
        System.out.printf("id = " + currCateId);
        Category cate = cate_helper.searchById(currCateId);
//            cate_helper.close();
        int total = cate_helper.getProductsInCateDetailTotal(cate);
        totalPage = (total % itemsPerPage == 0) ? (total / itemsPerPage) : ((total / itemsPerPage) + 1);
        return totalPage == 0 ? 1 : totalPage;
    }

    public String getType() {
        FacesContext context = FacesContext.getCurrentInstance();
        Map<String, String> params =
                context.getExternalContext().getRequestParameterMap();
        return params.get("type");
    }
}
