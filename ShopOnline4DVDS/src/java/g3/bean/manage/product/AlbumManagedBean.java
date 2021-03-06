/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.bean.manage.product;

import g3.hibernate.entity.Album;
import g3.hibernate.entity.Song;
import g3.bean.utility.AppConstant;
import g3.bean.utility.JsfUtilBean;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Administrator
 */
@ManagedBean
@SessionScoped
public class AlbumManagedBean {

    private Album curAlbum;
    private int formMode;
    private AlbumManagedHelper helper;
    private String returnFromDetails;
    private Album searchAlbum;
    private List<Album> resustSearch;

    /**
     * Creates a new instance of AlbumManagedBean
     */
    public AlbumManagedBean() {
    }

    @PostConstruct
    public void init() {
        helper = AlbumManagedHelper.getInstance();
    }

    @PreDestroy
    public void end() {
        helper.close();
    }

    public List<Album> getResustSearch() {
        return resustSearch;
    }

    public void setResustSearch(List<Album> resustSearch) {
        this.resustSearch = resustSearch;
    }

    public Album getSearchAlbum() {
        if (searchAlbum == null) {
            searchAlbum = new Album();
        }
        return searchAlbum;
    }

    public String search() {

        if (searchAlbum != null) {
            resustSearch = helper.search(searchAlbum);
        }
        return null;
    }

    public void setSearchAlbum(Album searchAlbum) {
        this.searchAlbum = searchAlbum;
    }

    public int getMode() {
        return formMode;
    }

    public void setMode(int mode) {
        this.formMode = mode;
    }

    public Album getCurAlbum() {
        return curAlbum;
    }

    public void setCurAlbum(Album curAlbum) {
        this.curAlbum = curAlbum;
    }

    public String create() {
        curAlbum = new Album();
        formMode = AppConstant.FORM_MODE_CREATE;
        return "form";
    }

    public String edit(Album item) {
        curAlbum = item;
        formMode = AppConstant.FORM_MODE_EDIT;
        return "form";
    }

    public String details(Album item) {
        curAlbum = item;
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        returnFromDetails = params.get("from");
        return "details";
    }

    public Album detailAlbum() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String id = params.get("detailid");
        if (id != null) {
            return (Album) helper.getObjectById(Album.class, id);
        }
        return curAlbum;
    }

    public String back() {
        return returnFromDetails;
    }

    public String save() {
        curAlbum.setOwner(JsfUtilBean.getCurrentManageStatic().getName());
        curAlbum.setIsAdminCreated(true);
        curAlbum.setCreatedDate(new Date());
        curAlbum.setModifiedDate(new Date());
        helper.save(curAlbum);
        curAlbum = null;
        return "show";
    }

    public String del(Album item) {
        item.setIsDeleted(true);
        item.setModifiedDate(new Date());
        helper.update(item);
        return null;
    }

    public String update() {
        curAlbum.setModifiedDate(new Date());
        helper.update(curAlbum);
        return "show";
    }

    public List<Album> getAllAlbums() {
        return helper.getAllAlbums();
    }

    public List<Album> getAllAlbumsDeleted() {
        return helper.getAllAlbumsDeleted();
    }

    public String recovery(Album item) {
        item.setIsDeleted(false);
        item.setModifiedDate(new Date());
        helper.update(item);
        return null;
    }

    public String cancel() {
        curAlbum = new Album();
        return "show";
    }

    public String prepareAddSong(Album item) {
        curAlbum = item;
        return "addsong";
    }

    public String addSong(Song item) {
        helper.addSong(curAlbum, item);
        return null;
    }

    public String removeSong(Song item) {
        helper.removeSong(curAlbum, item);
        return null;
    }

    public List<Song> getSongCanAdd() {
        return helper.getSongCanAdd(curAlbum);
    }

    public List<Song> searchSongCanAdd() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        SongManagedBean bean = (SongManagedBean) request.getSession().getAttribute("songManagedBean");
        List<Song> lstSong = bean.getResustSearch();
        return helper.searchSongCanAdd(curAlbum, lstSong);
    }

    public List<Song> getSongAdded() {
        return helper.getSongAdded(curAlbum);
    }

    public Album albumById(String id) {
        Album output = (Album) helper.getObjectById(Album.class, id);
        return output;
    }
}
