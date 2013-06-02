/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.other.admin.menu;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Administrator
 */
@ManagedBean
@SessionScoped
public class AdminNavigatorBean {

    public final static int HOME = 0;
    public final static int PRODUCT = 1;
    public final static int ORDER = 2;
    public final static int FILE = 4;
    public final static int USER = 8;
    public final static int REPORT = 16;
    private int curMenu = 0;

    /**
     * Creates a new instance of AdminNavigatorBean
     */
    public AdminNavigatorBean() {
    }

    public int getHOME() {
        return HOME;
    }

    public int getPRODUCT() {
        return PRODUCT;
    }

    public int getORDER() {
        return ORDER;
    }

    public int getFILE() {
        return FILE;
    }

    public int getUSER() {
        return USER;
    }

    public int getREPORT() {
        return REPORT;
    }

    public int getCurMenu() {
        return curMenu;
    }

    public void setCurMenu(int curMenu) {
        this.curMenu = curMenu;
    }

    public String navHome() {
        curMenu = HOME;
        return "adminindex";
    }

    public String navProduct() {
        curMenu = PRODUCT;
        return "productshow";
    }

    public String navOrder() {
        curMenu = ORDER;
        return "ordershow";
    }

    public String navFile() {
        curMenu = FILE;
        return "fileshow";
    }
}
