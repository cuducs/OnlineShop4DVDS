/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.bean.manage.product;

import g3.bean.utility.AppConstant;
import g3.hibernate.entity.FileData;
import g3.hibernate.entity.Song;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

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
        formMode = AppConstant.FORM_MODE_CREATE;
        return "songform";
    }

    public String edit(Song item) {
        curSong = item;
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
}
