/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.bean.manage.other;

import g3.bean.utility.AppConstant;
import g3.hibernate.entity.Artist;
import java.util.Date;
import java.util.HashMap;
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
public class ArtistManagedBean {
private Artist curArtist;
    private int formMode;
    private ArtistManagedHelper helper;
    private String returnFromDetails;
    private Artist searchArtist;
    private List<Artist> resustSearch;

    /**
     * Creates a new instance of MusicManagedBean
     */
    public ArtistManagedBean() {
    }

    @PostConstruct
    public void init() {
        helper = ArtistManagedHelper.getInstance();
    }

    @PreDestroy
    public void end() {
        helper.close();
    }

    public List<Artist> getResustSearch() {
        return resustSearch;
    }

    public void setResustSearch(List<Artist> resustSearch) {
        this.resustSearch = resustSearch;
    }

    public Artist getSearchArtist() {
        if (searchArtist == null) {
            searchArtist = new Artist();
        }
        return searchArtist;
    }

    public String search() {

        if (searchArtist != null) {
            resustSearch = helper.search(searchArtist);
        }
        return null;
    }

    public void setSearchArtist(Artist searchArtist) {
        this.searchArtist = searchArtist;
    }

    public int getMode() {
        return formMode;
    }

    public void setMode(int mode) {
        this.formMode = mode;
    }

    public Artist getCurArtist() {
        return curArtist;
    }

    public void setCurArtist(Artist curArtist) {
        this.curArtist = curArtist;
    }

    public String create() {
        curArtist = new Artist();
        formMode = AppConstant.FORM_MODE_CREATE;
        return "form";
    }

    public String edit(Artist item) {
        curArtist = item;
        formMode = AppConstant.FORM_MODE_EDIT;
        return "form";
    }

    public String details(Artist item) {
        curArtist = item;
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        returnFromDetails = params.get("from");
        return "details";
    }

    public String save() {
        curArtist.setCreatedDate(new Date());
        curArtist.setModifiedDate(new Date());
        helper.save(curArtist);
        curArtist = null;
        return "show";
    }

    public String del(Artist item) {
        item.setIsDeleted(true);
        item.setModifiedDate(new Date());
        helper.update(item);
        return null;
    }

    public String update() {
        curArtist.setModifiedDate(new Date());
        helper.update(curArtist);
        return "show";
    }

    public List<Artist> getAllArtists() {
        return helper.getAllArtists();
    }

    public List<Artist> getAllArtistsDeleted() {
        return helper.getAllArtistsDeleted();
    }

    public String recovery(Artist item) {
        item.setIsDeleted(false);
        item.setModifiedDate(new Date());
        helper.update(item);
        return null;
    }

    public String cancel() {
        curArtist = new Artist();
        return "show";
    }
    
    public Map<String, Integer> getListArtist() {
        Map<String, Integer> lst = new HashMap<String, Integer>();
        for (Artist artist : getAllArtists()) {
            lst.put(artist.getTitle(), artist.getId());
        }
        return lst;
    }
}
