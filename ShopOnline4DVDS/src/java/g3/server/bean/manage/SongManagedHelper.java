/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.server.bean.manage;

import g3.hibernate.entity.Song;
import g3.server.bean.BaseHelper;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Transaction;

/**
 *
 * @author Administrator
 */
public class SongManagedHelper extends BaseHelper{
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

    public boolean save(Song curSong) {
        Transaction beginTransaction = session.beginTransaction();
        session.save(curSong);
        beginTransaction.commit();
        if (curSong.getId() != 0) {
            return true;
        }
        return false;
    }

    void del(Song item) {
        Transaction beginTransaction = session.beginTransaction();
        session.delete(item);
        beginTransaction.commit();

    }

    void update(Song item) {
        Transaction beginTransaction = session.beginTransaction();
        session.update(item);
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
        if (searchSong.getId() > 0) {
            criteria.add(org.hibernate.criterion.Expression.eq("id", searchSong.getId()));
        }
        if (searchSong.getTitle() != "") {
            criteria.add(org.hibernate.criterion.Expression.ilike("title", "%" + searchSong.getTitle() + "%"));
        }
        if (searchSong.getLyrics() != "") {
            criteria.add(org.hibernate.criterion.Expression.ilike("lyrics", "%" + searchSong.getLyrics() + "%"));
        }
        criteria.add(org.hibernate.criterion.Expression.eq("isFree", searchSong.isIsFree()));
        return criteria.list();
    }
}
