/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.bean.manage.product;

import g3.hibernate.entity.Song;
import g3.bean.utility.BaseHelper;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;

/**
 *
 * @author Administrator
 */
public class SongManagedHelper extends BaseHelper {

    private static SongManagedHelper instance;

    private SongManagedHelper() {
    }

    public static SongManagedHelper getInstance() {
        if (instance == null) {
            instance = new SongManagedHelper();
        }
        return instance;
    }

    public List<Song> getAllSongs() {
        Transaction beginTransaction = session.beginTransaction();
        String hql = "FROM Song g WHERE g.isDeleted=0";
        Query query = session.createQuery(hql);
        beginTransaction.commit();
        return query.list();
    }

    List<Song> getAllSongsDeleted() {
        Transaction beginTransaction = session.beginTransaction();
        String hql = "FROM Song g WHERE g.isDeleted=1";
        Query query = session.createQuery(hql);
        beginTransaction.commit();
        return query.list();
    }

    List<Song> search(Song searchSong) {
        Criteria criteria = session.createCriteria(Song.class);
        if (searchSong.getTitle() != "") {
            criteria.add(org.hibernate.criterion.Expression.ilike("title", "%" + searchSong.getTitle() + "%"));
        }
        if (searchSong.getLyrics() != "") {
            criteria.add(org.hibernate.criterion.Expression.ilike("lyrics", "%" + searchSong.getLyrics() + "%"));
        }
        if (searchSong.getInfo() != "") {
            criteria.add(org.hibernate.criterion.Expression.ilike("info", "%" + searchSong.getInfo() + "%"));
        }
        if (searchSong.getSingerId() != null) {
            criteria.add(org.hibernate.criterion.Expression.eq("singerId", searchSong.getSingerId()));
        }
        if (searchSong.getComposerId() != null) {
            criteria.add(org.hibernate.criterion.Expression.eq("composerId", searchSong.getComposerId()));
        }
        criteria.add(Expression.eq("isFree", searchSong.isIsFree()));
        criteria.add(Expression.eq("isDeleted", searchSong.isIsDeleted()));
        criteria.add(org.hibernate.criterion.Expression.eq("isFree", searchSong.isIsFree()));
        return criteria.list();
    }
}
