/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.server.bean;

import g3.hibernate.entity.Dvd;
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
public class UserBean {

    private UserHelper helper;
    private Dvd curDvd;

    /**
     * Creates a new instance of UserBean
     */
    public UserBean() {
    }

    @PostConstruct
    public void init() {
        helper = UserHelper.getInstance();
    }

    @PreDestroy
    public void end() {
        helper.close();
    }

    public Dvd getCurDvd() {
        return curDvd;
    }

    public void setCurDvd(Dvd curDvd) {
        this.curDvd = curDvd;
    }

    public Dvd getProductDetails() {
        FacesContext context = FacesContext.getCurrentInstance();
        Map<String, String> params =
                context.getExternalContext().getRequestParameterMap();
        String id = params.get("productid");
        String hqlQuery = "From Dvd d Where d.id=" + id;
        return (Dvd) helper.getSession().createQuery(hqlQuery).uniqueResult();
    }
}
