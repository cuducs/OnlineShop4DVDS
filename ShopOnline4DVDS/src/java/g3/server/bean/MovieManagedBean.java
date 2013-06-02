/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.server.bean;

import g3.hibernate.entity.FileData;
import g3.hibernate.entity.Movie;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
public class MovieManagedBean {

    private Movie curMovie;
    private int formMode;
    private MovieManagedHelper helper;
    private String returnFromDetails;
    private Movie searchMovie;
    private List<Movie> resustSearch;
    /**
     * Creates a new instance of MovieManagedBean
     */
    public MovieManagedBean() {
    }

    @PostConstruct
    public void init() {
        helper = MovieManagedHelper.getInstance();
    }

    @PreDestroy
    public void end() {
        helper.close();
    }

    public List<Movie> getResustSearch() {
        return resustSearch;
    }

    public void setResustSearch(List<Movie> resustSearch) {
        this.resustSearch = resustSearch;
    }

    public Movie getSearchMovie() {
        if (searchMovie == null) {
            searchMovie = new Movie();
        }
        return searchMovie;
    }

    public String search() {

        if (searchMovie != null) {
            resustSearch = helper.search(searchMovie);
        }
        return null;
    }

    public void setSearchMovie(Movie searchMovie) {
        this.searchMovie = searchMovie;
    }

    public int getMode() {
        return formMode;
    }

    public void setMode(int mode) {
        this.formMode = mode;
    }

    public Movie getCurMovie() {
        return curMovie;
    }

    public void setCurMovie(Movie curMovie) {
        this.curMovie = curMovie;
    }

    public String create() {
        curMovie = new Movie(0, false);
        formMode = AppConstant.FORM_MODE_CREATE;
        return "movieform";
    }

    public String edit(Movie item) {
        curMovie = item;
        formMode = AppConstant.FORM_MODE_EDIT;
        return "form";
    }

    public String details(Movie item) {
        curMovie = item;
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        returnFromDetails = params.get("from");
        return "details";
    }

    public String back() {
        return returnFromDetails;
    }

    public String save() {
        
        curMovie.setCreatedDate(new Date());
        curMovie.setModifiedDate(new Date());
        helper.save(curMovie);
        curMovie = null;
        return "show";
    }

    public String del(Movie item) {
        item.setIsDeleted(true);
        item.setModifiedDate(new Date());
        helper.update(item);
        return "show";
    }

    public String update() {
        curMovie.setModifiedDate(new Date());
        helper.update(curMovie);
        return "show";
    }

    public List<Movie> getAllMovies() {
        return helper.getAllMovies();
    }

    public List<Movie> getAllMoviesDeleted() {
        return helper.getAllMoviesDeleted();
    }

    public String recovery(Movie item) {
        item.setIsDeleted(false);
        item.setModifiedDate(new Date());
        helper.update(item);
        return "recovery";
    }

    public String cancel() {
        curMovie = new Movie();
        return "show";
    }
    public String addFile(FileData file){
        curMovie.setTrailerId(file.getId());
        curMovie.setModifiedDate(new Date());
        helper.update(curMovie);
        return "details";
    }
}
