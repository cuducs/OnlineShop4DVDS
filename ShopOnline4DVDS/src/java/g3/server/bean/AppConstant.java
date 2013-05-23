/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.server.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Administrator
 */
@ManagedBean
@SessionScoped
public class AppConstant {
    public static final String FILE_TYPE_SOUND="sound";
    public static final String FILE_TYPE_VIDEO="video";
    public static final int BILL_STATUS_WAIT=1;
    public static final int BILL_STATUS_DONE=2;
    public static final int BILL_STATUS_CANCEL=0;
    public static final String DVD_TYPE_MUSIC="music";
    public static final String DVD_TYPE_MOVIE="movie";
    public static final String DVD_TYPE_GAME="game";
    public static final int FORM_MODE_CREATE=1;
    public static final int FORM_MODE_EDIT=2;
    
    public int getModeCreate(){
        return FORM_MODE_CREATE;
    }
    public int getModeEdit(){
        return FORM_MODE_EDIT;
    }
}
