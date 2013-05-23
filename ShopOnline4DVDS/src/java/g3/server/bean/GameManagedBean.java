/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.server.bean;

import g3.hibernate.entity.Game;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

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
    public void init(){
        helper=GameManageHelper.getInstance();
    }
    @PreDestroy
    public void end(){
        helper.close();
    }
    public String create(){
        curGame=new Game(0, false);
        mode=AppConstant.FORM_MODE_CREATE;
        return "form";
    }
    public String edit(Game item){
        curGame=item;
        mode=AppConstant.FORM_MODE_EDIT;
        return "form";
    }
    public String details(Game item){
        curGame=item;
        return "details";
    }
    public String save(){
        curGame.setCreatedDate(new Date());
        helper.save(curGame);
        curGame=null;
        return "show";
    }
    public String del(Game item){
        item.setIsDeleted(true);
        item.setModifiedDate(new Date());
        helper.update(item);
        return "show";
    }
    public String update(){
        curGame.setModifiedDate(new Date());
        helper.update(curGame);
        return "show";
    }
    public List<Game> getAllGames(){
        return helper.getAllGames();
    }
}
