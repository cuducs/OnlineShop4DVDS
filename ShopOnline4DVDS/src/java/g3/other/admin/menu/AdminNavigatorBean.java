/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.other.admin.menu;

import javax.faces.application.ViewHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

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

    public void loadSideMenu(int menuType, String outcome) {
        boolean isReload = false;
        switch (menuType) {
            case HOME:
                if (curMenu != HOME) {
                    curMenu = HOME;
                    isReload = true;
                }
                break;
            case PRODUCT:
                if (curMenu != PRODUCT) {
                    curMenu = PRODUCT;
                    isReload = true;
                }
                break;
            case ORDER:
                if (curMenu != ORDER) {
                    curMenu = ORDER;
                    isReload = true;
                }
                break;
            case FILE:
                if (curMenu != FILE) {
                    curMenu = FILE;
                    isReload = true;
                }
                break;
            case USER:
                if (curMenu != USER) {
                    curMenu = USER;
                    isReload = true;
                }
                break;
            case REPORT:
                if (curMenu != REPORT) {
                    curMenu = REPORT;
                    isReload = true;
                }
                break;
        }
        if (isReload) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.responseComplete();
            context.getApplication().
                    getNavigationHandler().handleNavigation(context, null, outcome);
        }

    }

    public void redirect(String outcome, Object value, Object expect) {
        if (value==expect) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.responseComplete();
            context.getApplication().
                    getNavigationHandler().handleNavigation(context, null, outcome);
        }

    }
}
