/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.server.bean;

import g3.hibernate.entity.Dvd;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.hibernate.Session;

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
    public ShowProductBean() {
    }

    public List<Dvd> getDvdvideo() {
        return getSession().createQuery("FROM Dvd d WHERE d.type = 'movie'").list();
    }

    public List<Dvd> getDvdmusic() {
        return getSession().createQuery("FROM Dvd d WHERE d.type = 'music'").list();
    }

    public List<Dvd> getDvdgame() {
        return getSession().createQuery("FROM Dvd d WHERE d.type = 'game'").list();
    }

    public Session getSession() {
        return DvdStoreHibernateUtil.getSessionFactory().openSession();
    }
    
}
