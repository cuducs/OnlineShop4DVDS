/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.server.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author TrungDuc
 */
public class DvdStoreHibernateUtil {

    private static final SessionFactory sessionFactory;
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            
            sessionFactory = new Configuration().configure(
					"/g3/hibernate/config/dvdStore.cfg.xml")
					.buildSessionFactory();
            
//            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    public static String currenrTime() {
        Date d = new Date();
        String s = (d.getMonth() + 1) + "/" + d.getDate() + "/" + (d.getYear() + 1900);
        return s;
    }
}
