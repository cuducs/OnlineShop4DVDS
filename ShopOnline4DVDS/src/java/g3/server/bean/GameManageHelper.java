/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.server.bean;

import g3.hibernate.entity.Game;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Administrator
 */
public class GameManageHelper {
    private static GameManageHelper instance;
    private GameManageHelper(){
        
    }
    public static GameManageHelper getInstance(){
        if(instance==null){
            instance=new GameManageHelper();
        }
        return instance;
    }

    List<Game> getAllGames() {
        SessionFactory factory=DvdStoreHibernateUtil.getSessionFactory();
        Session session=factory.getCurrentSession();
        String hql="FROM Game g WHERE g.isDeleted=0";
        Query query=session.createQuery(hql);
        return query.list();
    }
}
