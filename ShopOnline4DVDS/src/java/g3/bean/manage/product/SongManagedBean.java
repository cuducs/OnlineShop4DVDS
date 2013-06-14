/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.bean.manage.product;

import g3.bean.utility.AppConstant;
import g3.hibernate.entity.Artist;
import g3.hibernate.entity.FileData;
import g3.hibernate.entity.Song;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Administrator
 */
@ManagedBean
@SessionScoped
public class SongManagedBean {

    private Song curSong;
    private int formMode;
    private SongManagedHelper helper;
    private String returnFromDetails;
    private Song searchSong;
    private List<Song> resustSearch;
    private String singer;
    private String composer;

    /**
     * Creates a new instance of MusicManagedBean
     */
    public SongManagedBean() {
    }

    @PostConstruct
    public void init() {
        helper = SongManagedHelper.getInstance();
    }

    @PreDestroy
    public void end() {
        helper.close();
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public List<Song> getResustSearch() {
        return resustSearch;
    }

    public void setResustSearch(List<Song> resustSearch) {
        this.resustSearch = resustSearch;
    }

    public Song getSearchSong() {
        if (searchSong == null) {
            searchSong = new Song();
        }
        return searchSong;
    }

    public String search() {

        if (searchSong != null) {
            resustSearch = helper.search(searchSong);
        }
        return null;
    }

    public void setSearchSong(Song searchSong) {
        this.searchSong = searchSong;
    }

    public int getMode() {
        return formMode;
    }

    public void setMode(int mode) {
        this.formMode = mode;
    }

    public Song getCurSong() {
        return curSong;
    }

    public void setCurSong(Song curSong) {
        this.curSong = curSong;
    }

    public String create() {
        curSong = new Song();
        singer = "";
        composer = "";
        formMode = AppConstant.FORM_MODE_CREATE;
        return "form";
    }

    public String edit(Song item) {
        curSong = item;
        Artist artist1 = (Artist) helper.getSession().createCriteria(Artist.class).add(Expression.eq("id", item.getSingerId())).uniqueResult();
        Artist artist2 = (Artist) helper.getSession().createCriteria(Artist.class).add(Expression.eq("id", item.getComposerId())).uniqueResult();
        singer = (artist1 == null ? "" : artist1.getTitle());
        composer = (artist2 == null ? "" : artist2.getTitle());
        formMode = AppConstant.FORM_MODE_EDIT;
        return "form";
    }

    public String details(Song item) {
        curSong = item;
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        returnFromDetails = params.get("from");
        return "details";
    }

    public String back() {
        return returnFromDetails;
    }

    public String save() {
        if (singer != null && !singer.equals("")) {
            Artist inputarArtist = getOrCreateArtist(singer, true);
            curSong.setSingerId(inputarArtist.getId());
        }
        if (composer != null && !composer.equals("")) {
            Artist inputarArtist2 = getOrCreateArtist(composer, false);
            curSong.setComposerId(inputarArtist2.getId());
        }
        curSong.setCreatedDate(new Date());
        curSong.setModifiedDate(new Date());
        helper.save(curSong);
        curSong = null;
        return "show";
    }

    public String del(Song item) {
        item.setIsDeleted(true);
        item.setModifiedDate(new Date());
        helper.update(item);
        return null;
    }

    public String update() {
        if (singer != null && !singer.equals("")) {
            Artist inputarArtist = getOrCreateArtist(singer, true);
            curSong.setSingerId(inputarArtist.getId());
        }
        if (composer != null && !composer.equals("")) {
            Artist inputarArtist2 = getOrCreateArtist(composer, false);
            curSong.setComposerId(inputarArtist2.getId());
        }
        curSong.setModifiedDate(new Date());
        helper.update(curSong);
        return "show";
    }

    public List<Song> getAllSongs() {
        return helper.getAllSongs();
    }

    public List<Song> getAllSongsDeleted() {
        return helper.getAllSongsDeleted();
    }

    public String recovery(Song item) {
        item.setIsDeleted(false);
        item.setModifiedDate(new Date());
        helper.update(item);
        return null;
    }

    public String cancel() {
        curSong = new Song();
        return "show";
    }

    public String addFile(FileData file) {
        curSong.setFileId(file.getId());
        curSong.setModifiedDate(new Date());
        helper.update(curSong);
        return "details";
    }

    public String removeFile() {
        curSong.setFileId(0);
        curSong.setModifiedDate(new Date());
        helper.update(curSong);
        return "details";
    }

    public String removeFile(Song item) {
        item.setFileId(0);
        item.setModifiedDate(new Date());
        helper.update(item);
        return null;
    }

    public String prepareAddFile(Song item) {
        curSong = item;
        return "mappingfile";
    }

    public List<String> autoCompleteArtistComposer(String query) {
        Session session = helper.getSession();
        List<String> lst = new ArrayList<String>();
        if (query.length() > 0 && query.length() < 2) {
            for (Object sger : session.createCriteria(Artist.class).
                    add(Restrictions.in("workAs", Arrays.asList(AppConstant.ARTIST_COMPOSER, AppConstant.ARTIST_BOTH))).
                    add(Expression.eq("isDeleted",false)).
                    list()) {

                lst.add(((Artist) sger).getTitle());
            }
        } else if (query.length() > 2) {
            for (Object sger : session.createCriteria(Artist.class).
                    add(Expression.ilike("title", "%" + query + "%")).
                    add(Restrictions.in("workAs", Arrays.asList(AppConstant.ARTIST_COMPOSER, AppConstant.ARTIST_BOTH))).
                    add(Expression.eq("isDeleted", false)).
                    list()) {

                lst.add(((Artist) sger).getTitle());
            }


        }
        return lst;
    }

    public List<String> autoCompleteArtistSinger(String query) {
        Session session = helper.getSession();
        List<String> lst = new ArrayList<String>();
        if (query.length() > 0 && query.length() < 2) {
            for (Object sger : session.createCriteria(Artist.class).
                    add(Restrictions.in("workAs", Arrays.asList(AppConstant.ARTIST_SINGER, AppConstant.ARTIST_BOTH))).
                    add(Expression.eq("isDeleted", false)).
                    list()) {

                lst.add(((Artist) sger).getTitle());
            }
        } else if (query.length() > 2) {
            for (Object sger : session.createCriteria(Artist.class).
                    add(Expression.ilike("title", "%" + query + "%")).
                    add(Restrictions.in("workAs", Arrays.asList(AppConstant.ARTIST_SINGER, AppConstant.ARTIST_BOTH))).
                    add(Expression.eq("isDeleted", false)).
                    list()) {

                lst.add(((Artist) sger).getTitle());
            }


        }
        return lst;
    }

    private Artist getOrCreateArtist(String title, boolean isSinger) {
        Session session = helper.getSession();
        Artist getArt = null;
        if (isSinger) {
            getArt = (Artist) session.createCriteria(Artist.class).add(Expression.eq("title", title))
                    .add(Restrictions.in("workAs", Arrays.asList(AppConstant.ARTIST_SINGER, AppConstant.ARTIST_BOTH))).uniqueResult();
        } else {
            getArt = (Artist) session.createCriteria(Artist.class).add(Expression.eq("title", title))
                    .add(Restrictions.in("workAs", Arrays.asList(AppConstant.ARTIST_COMPOSER, AppConstant.ARTIST_BOTH))).uniqueResult();
        }

        if (getArt != null) {
            return getArt;
        }
        getArt = (Artist) session.createCriteria(Artist.class).add(Expression.eq("title", title))
                .add(Restrictions.in("workAs", Arrays.asList(AppConstant.ARTIST_COMPOSER, AppConstant.ARTIST_SINGER, AppConstant.ARTIST_BOTH))).uniqueResult();
        if (getArt != null) {
            getArt.setWorkAs(AppConstant.ARTIST_BOTH);
            session.update(getArt);
            return getArt;
        }
        getArt = new Artist();
        getArt.setTitle(title);
        getArt.setCreatedDate(new Date());
        getArt.setModifiedDate(new Date());
        getArt.setIsDeleted(false);
        if (isSinger) {
            getArt.setWorkAs(AppConstant.ARTIST_SINGER);
        } else {
            getArt.setWorkAs(AppConstant.ARTIST_COMPOSER);
        }
        session.save(getArt);
        return getArt;
    }
}
