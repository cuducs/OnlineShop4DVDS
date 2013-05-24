/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.server.bean;

import g3.hibernate.entity.Game;
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
    private int mode;
    private GameManageHelper helper;
    private String returnFromDetails;

    /**
     * Creates a new instance of GameManageBean
     */
    public GameManagedBean() {
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public Game getCurGame() {
        return curGame;
    }

    public void setCurGame(Game curGame) {
        this.curGame = curGame;
    }

    @PostConstruct
    public void init() {
        helper = GameManageHelper.getInstance();
    }

    @PreDestroy
    public void end() {
        helper.close();
    }

    public String create() {
        curGame = new Game(0, false);
        mode = AppConstant.FORM_MODE_CREATE;
        return "form";
    }

    public String edit(Game item) {
        curGame = item;
        mode = AppConstant.FORM_MODE_EDIT;
        return "form";
    }

    public String details(Game item) {
        curGame = item;
        Map<String, String> params =FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        returnFromDetails = params.get("from");
        return "details";
    }
    public String back(){
        return returnFromDetails;
    }
    public String save() {
        curGame.setCreatedDate(new Date());
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
}
