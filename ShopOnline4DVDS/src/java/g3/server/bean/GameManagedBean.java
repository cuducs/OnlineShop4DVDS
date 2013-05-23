/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.server.bean;

import g3.hibernate.entity.Game;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Administrator
 */
@ManagedBean
@SessionScoped
public class GameManagedBean {
    private GameManageHelper helper;
    /**
     * Creates a new instance of GameManageBean
     */
    public GameManagedBean() {
    }
    
    @PostConstruct
    public void init(){
        helper=GameManageHelper.getInstance();
    }
    
    public List<Game> getAllGames(){
        return helper.getAllGames();
    }
}
