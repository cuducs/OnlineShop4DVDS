/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.bean.client;

import g3.bean.utility.DvdStoreHibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Administrator
 */
public class BaseHelper {

    protected Session session = null;

    protected BaseHelper() {
        session = DvdStoreHibernateUtil.getSessionFactory().openSession();
    }

    public void close() {
        if (session != null) {
            if (session.isOpen()) {
                session.close();
            }
        }

    }

    public Session getSession() {
        return session;
    }

    public void save(Object item) {
        session.save(item);
    }

    public void del(Object item) {
        session.delete(item);

    }

    public void update(Object item) {
        session.update(item);
    }
}
