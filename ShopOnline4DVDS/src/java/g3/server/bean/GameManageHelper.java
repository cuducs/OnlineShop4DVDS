/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.server.bean;

import g3.hibernate.entity.Game;
import java.beans.Expression;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Administrator
 */
public class GameManageHelper extends BaseHelper {

    private static GameManageHelper instance;

    private GameManageHelper() {
    }

    public static GameManageHelper getInstance() {
        if (instance == null) {
            instance = new GameManageHelper();
        }
        return instance;
    }

    public List<Game> getAllGames() {
        Transaction beginTransaction = session.beginTransaction();
        String hql = "FROM Game g WHERE g.isDeleted=0";
        Query query = session.createQuery(hql);
        beginTransaction.commit();
        return query.list();
    }

    public boolean save(Game curGame) {
        Transaction beginTransaction = session.beginTransaction();
        session.save(curGame);
        beginTransaction.commit();
        if (curGame.getId() != 0) {
            return true;
        }
        return false;
    }

    void del(Game item) {
        Transaction beginTransaction = session.beginTransaction();
        session.delete(item);
        beginTransaction.commit();

    }

    void update(Game item) {
        Transaction beginTransaction = session.beginTransaction();
        session.update(item);
    }

    List<Game> getAllGamesDeleted() {
        Transaction beginTransaction = session.beginTransaction();
        String hql = "FROM Game g WHERE g.isDeleted=1";
        Query query = session.createQuery(hql);
        beginTransaction.commit();
        return query.list();
    }

    List<Game> search(Game searchGame) {
        Criteria criteria = session.createCriteria(Game.class);
        if (searchGame.getId() > 0) {
            criteria.add(org.hibernate.criterion.Expression.eq("id", searchGame.getId()));
        }
        if (searchGame.getTitle() != "") {
            criteria.add(org.hibernate.criterion.Expression.ilike("title", "%" + searchGame.getTitle() + "%"));
        }
        if (searchGame.getLanguage() != "") {
            criteria.add(org.hibernate.criterion.Expression.ilike("language", "%" + searchGame.getLanguage() + "%"));
        }
        if (searchGame.getPlatform() != "") {
            criteria.add(org.hibernate.criterion.Expression.ilike("platform", "%" + searchGame.getPlatform() + "%"));
        }
        if (searchGame.getBrand() != "") {
            criteria.add(org.hibernate.criterion.Expression.ilike("brand", "%" + searchGame.getBrand() + "%"));
        }
        return criteria.list();
    }
}
