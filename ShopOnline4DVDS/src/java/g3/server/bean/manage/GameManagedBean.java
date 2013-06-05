/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.server.bean.manage;

import g3.server.bean.utility.AppConstant;
import g3.hibernate.entity.ver2.FileData;
import g3.hibernate.entity.ver2.Game;
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
public class GameManagedBean {

    private Game curGame;
    private int formMode;
    private GameManagedHelper helper;
    private String returnFromDetails;
    private Game searchGame;
    private List<Game> resustSearch;

    /**
     * Creates a new instance of GameManageBean
     */
    public GameManagedBean() {
    }

    @PostConstruct
    public void init() {
        helper = GameManagedHelper.getInstance();
    }

    @PreDestroy
    public void end() {
        helper.close();
    }

    public List<Game> getResustSearch() {
        return resustSearch;
    }

    public void setResustSearch(List<Game> resustSearch) {
        this.resustSearch = resustSearch;
    }

    public Game getSearchGame() {
        if (searchGame == null) {
            searchGame = new Game();
        }
        return searchGame;
    }

    public String search() {

        if (searchGame != null) {
            resustSearch = helper.search(searchGame);
        }
        return null;
    }

    public void setSearchGame(Game searchGame) {
        this.searchGame = searchGame;
    }

    public int getMode() {
        return formMode;
    }

    public void setMode(int mode) {
        this.formMode = mode;
    }

    public Game getCurGame() {
        return curGame;
    }

    public void setCurGame(Game curGame) {
        this.curGame = curGame;
    }

    public String create() {
        curGame = new Game();
        formMode = AppConstant.FORM_MODE_CREATE;
        return "gameform";
    }

    public String edit(Game item) {
        curGame = item;
        formMode = AppConstant.FORM_MODE_EDIT;
        return "form";
    }

    public String details(Game item) {
        curGame = item;
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        returnFromDetails = params.get("from");
        return "details";
    }

    public String back() {
        return returnFromDetails;
    }

    public String save() {
        curGame.setCreatedDate(new Date());
        curGame.setModifiedDate(new Date());
        helper.save(curGame);
        curGame = null;
        return "show";
    }

    public String del(Game item) {
        item.setIsDeleted(true);
        item.setModifiedDate(new Date());
        helper.update(item);
        return "show";
    }

    public String update() {
        curGame.setModifiedDate(new Date());
        helper.update(curGame);
        return "show";
    }

    public List<Game> getAllGames() {
        return helper.getAllGames();
    }

    public List<Game> getAllGamesDeleted() {
        return helper.getAllGamesDeleted();
    }

    public String recovery(Game item) {
        item.setIsDeleted(false);
        item.setModifiedDate(new Date());
        helper.update(item);
        return "recovery";
    }
    public String cancel(){
        curGame=new Game();
        return "show";
    }
    
    public String addFile(FileData file){
        curGame.setTrailerId(file.getId());
        curGame.setModifiedDate(new Date());
        helper.update(curGame);
        return "details";
    }
}
