/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.bean.utility;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;

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

    public Object getObjectById(Class clss, String id) {
        Query query=session.createQuery("From "+clss.getName()+" c where c.id="+id);
        
        Object test=query.uniqueResult();
        return query.uniqueResult();
    }
}
