/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.server.bean;

import org.hibernate.Session;

/**
 *
 * @author Administrator
 */
public class BaseHelper {
    protected Session session=null;
    protected BaseHelper(){
        session=DvdStoreHibernateUtil.getSessionFactory().getCurrentSession();
    }
}