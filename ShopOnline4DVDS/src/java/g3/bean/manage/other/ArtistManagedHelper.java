/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.bean.manage.other;

import g3.bean.utility.BaseHelper;
import g3.hibernate.entity.Artist;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;

/**
 *
 * @author Administrator
 */
public class ArtistManagedHelper extends BaseHelper {

    private static ArtistManagedHelper instance;

    private ArtistManagedHelper() {
    }

    public static ArtistManagedHelper getInstance() {
        if (instance == null) {
            instance = new ArtistManagedHelper();
        }
        return instance;
    }

    public List<Artist> getAllArtists() {
        Transaction beginTransaction = session.beginTransaction();
        String hql = "FROM Artist g WHERE g.isDeleted=0";
        Query query = session.createQuery(hql);
        beginTransaction.commit();
        return query.list();
    }

    List<Artist> getAllArtistsDeleted() {
        Transaction beginTransaction = session.beginTransaction();
        String hql = "FROM Artist g WHERE g.isDeleted=1";
        Query query = session.createQuery(hql);
        beginTransaction.commit();
        return query.list();
    }

    List<Artist> search(Artist searchArtist) {
        Criteria criteria = session.createCriteria(Artist.class);
        if (searchArtist.getTitle() != "") {
            criteria.add(Expression.ilike("title", "%" + searchArtist.getTitle() + "%"));
        }
        if (searchArtist.getInfo() != "") {
            criteria.add(Expression.ilike("info", "%" + searchArtist.getInfo() + "%"));
        }
        if (searchArtist.getWorkAs() != null && searchArtist.getWorkAs() != "") {
            criteria.add(Expression.ilike("workAs", "%" + searchArtist.getWorkAs() + "%"));
        }
        criteria.add(Expression.eq("isDeleted", searchArtist.isIsDeleted()));
        return criteria.list();
    }
}
