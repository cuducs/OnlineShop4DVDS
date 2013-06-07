/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.server.bean.utility;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Administrator
 */
@ManagedBean
@ApplicationScoped
public class AppConstant {

    public static final String PRODUCT_IMAGE_PATH = "/ShopOnline4DVDS/resources/product/images/";
    public static final String FILE_TYPE_SOUND = "sound";
    public static final String FILE_TYPE_VIDEO = "video";
    public static final String FILE_TYPE_VIDEO_NET = "video-net";
    public static final String FILE_TYPE_SOUND_NET = "sound-net";
    public static final int BILL_STATUS_WAIT = 1;
    public static final int BILL_STATUS_DONE = 2;
    public static final int BILL_STATUS_CANCEL = 0;
    public static final String DVD_TYPE_MUSIC = "music";
    public static final String DVD_TYPE_MOVIE = "movie";
    public static final String DVD_TYPE_GAME = "game";
    public static final String DVD_TYPE_ALL = "all";
    public static final int FORM_MODE_CREATE = 1;
    public static final int FORM_MODE_EDIT = 2;
    public static final String ARTIST_COMPOSER = "composer";
    public static final String ARTIST_SINGER = "singer";
    public static final String ARTIST_BOTH = "both";
    public static final String OPERATOR_EQUAL = "=";
    public static final String OPERATOR_LARGER = ">";
    public static final String OPERATOR_LARGER_EQUAL = ">=";
    public static final String OPERATOR_LESSER = "<";
    public static final String OPERATOR_LESSER_EQUAL = "<=";
    public static final String OPERATOR_TOP = "top";
    public static final String OPERATOR_BETWEEN = "between";
    public static final String OPERATOR_CONTAIN = "like";
    public static final String OPERATOR_NONE = "none";

    public int getModeCreate() {
        return FORM_MODE_CREATE;
    }

    public int getModeEdit() {
        return FORM_MODE_EDIT;
    }

    public String getOPERATOR_EQUAL() {
        return OPERATOR_EQUAL;
    }

    public String getOPERATOR_LARGER() {
        return OPERATOR_LARGER;
    }

    public String getOPERATOR_LARGER_EQUAL() {
        return OPERATOR_LARGER_EQUAL;
    }

    public String getOPERATOR_LESSER() {
        return OPERATOR_LESSER;
    }

    public String getOPERATOR_LESSER_EQUAL() {
        return OPERATOR_LESSER_EQUAL;
    }

    public String getOPERATOR_TOP() {
        return OPERATOR_TOP;
    }

    public String getOPERATOR_BETWEEN() {
        return OPERATOR_BETWEEN;
    }

    public String getOPERATOR_CONTAIN() {
        return OPERATOR_CONTAIN;
    }

    public String getDVD_TYPE_MUSIC() {
        return DVD_TYPE_MUSIC;
    }

    public String getDVD_TYPE_MOVIE() {
        return DVD_TYPE_MOVIE;
    }

    public String getDVD_TYPE_GAME() {
        return DVD_TYPE_GAME;
    }

    public String getDVD_TYPE_ALL() {
        return DVD_TYPE_ALL;
    }

    public String getPRODUCT_IMAGE_PATH() {
        return PRODUCT_IMAGE_PATH;
    }
    
}
