/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.server.bean.manage;

import g3.hibernate.entity.Album;
import g3.hibernate.entity.AlbumMusicMapping;
import g3.hibernate.entity.AlbumMusicMappingId;
import g3.hibernate.entity.Song;
import g3.server.bean.BaseHelper;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Administrator
 */
public class AlbumManagedHelper extends BaseHelper {

    private static AlbumManagedHelper instance;

    private AlbumManagedHelper() {
    }

    public static AlbumManagedHelper getInstance() {
        if (instance == null) {
            instance = new AlbumManagedHelper();
        }
        return instance;
    }

    public List<Album> getAllAlbums() {
        Transaction beginTransaction = session.beginTransaction();
        String hql = "FROM Album g WHERE g.isDeleted=0";
        Query query = session.createQuery(hql);
        beginTransaction.commit();
        return query.list();
    }

    List<Album> getAllAlbumsDeleted() {
        Transaction beginTransaction = session.beginTransaction();
        String hql = "FROM Album g WHERE g.isDeleted=1";
        Query query = session.createQuery(hql);
        beginTransaction.commit();
        return query.list();
    }

    List<Album> search(Album searchAlbum) {
        Criteria criteria = session.createCriteria(Album.class);
        if (searchAlbum.getId() > 0) {
            criteria.add(org.hibernate.criterion.Expression.eq("id", searchAlbum.getId()));
        }
        if (searchAlbum.getTitle() != "") {
            criteria.add(org.hibernate.criterion.Expression.ilike("title", "%" + searchAlbum.getTitle() + "%"));
        }
        if (searchAlbum.getOwner() != "") {
            criteria.add(org.hibernate.criterion.Expression.ilike("owner", "%" + searchAlbum.getOwner() + "%"));
        }
        return criteria.list();
    }

    void addSong(Album curAlbum, Song item) {
        Transaction beginTransaction = session.beginTransaction();
        AlbumMusicMapping mapping = new AlbumMusicMapping();
        AlbumMusicMappingId mappingId = new AlbumMusicMappingId(curAlbum.getId(), item.getId());
        mapping.setId(mappingId);
        session.save(mapping);
        maintainAlbum(curAlbum);
        session.save(curAlbum);
        beginTransaction.commit();
    }

    void maintainAlbum(Album album) {
        List lstMapping = session.createQuery("From AlbumMusicMapping a Where a.id.albumId=" + album.getId()).list();
        int count = 0;
        if (lstMapping.size() > 0) {
            for (int i = 1; i <= lstMapping.size(); i++) {
                AlbumMusicMapping temp = (AlbumMusicMapping) lstMapping.get(i - 1);
                temp.setTrackNumber(i);
                count++;
            }
        }
        album.setNumberItem(count);
    }

    void removeSong(Album curAlbum, Song item) {
        Transaction beginTransaction = session.beginTransaction();

        AlbumMusicMappingId mappingId = new AlbumMusicMappingId(curAlbum.getId(), item.getId());
        AlbumMusicMapping mapping = (AlbumMusicMapping) session.get(AlbumMusicMapping.class, mappingId);
        session.delete(mapping);
        maintainAlbum(curAlbum);
        session.save(curAlbum);
        beginTransaction.commit();
    }

    List<Song> getSongCanAdd(Album item) {
        Transaction beginTransaction = session.beginTransaction();

        Criteria songCanAdd = session.createCriteria(Song.class);
        List lstCannotAddId = session.createQuery("Select a.id.songId From AlbumMusicMapping a Where a.id.albumId=" + item.getId()).list();
        if (lstCannotAddId.size() > 0) {
            songCanAdd.add(Restrictions.not(Restrictions.in("id", lstCannotAddId)));
        }

        beginTransaction.commit();

        return songCanAdd.list();
    }

    List<Song> getSongAdded(Album item) {
        Transaction beginTransaction = session.beginTransaction();
        List lstCannotAddId = session.createQuery("Select a.id.songId From AlbumMusicMapping a Where a.id.albumId=" + item.getId()).list();
        Criteria songCanAdd = session.createCriteria(Song.class);
        if (lstCannotAddId.size() == 0) {
            return lstCannotAddId;
        }
        songCanAdd.add(Restrictions.in("id", lstCannotAddId));
        beginTransaction.commit();
        return songCanAdd.list();
    }

    List<Song> searchSongCanAdd(Album item) {
        Transaction beginTransaction = session.beginTransaction();
        List lstCannotAddId = session.createQuery("Select a.id.songId From AlbumMusicMapping a Where a.id.albumId=" + item.getId()).list();
        Criteria songCanAdd = session.createCriteria(Song.class);
        if (lstCannotAddId.size() > 0) {
            songCanAdd.add(Restrictions.not(Restrictions.in("id", lstCannotAddId)));
        }

        beginTransaction.commit();

        return songCanAdd.list();
    }
}
