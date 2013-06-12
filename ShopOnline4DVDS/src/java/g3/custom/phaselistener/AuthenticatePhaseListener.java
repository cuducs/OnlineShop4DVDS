/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.custom.phaselistener;

import g3.bean.security.ManageManagedBean;
import g3.bean.security.PermissionManagedBean;
import g3.hibernate.entity.Manage;
import g3.hibernate.entity.Member;
import g3.hibernate.entity.Permission;
import java.util.List;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Administrator
 */
public class AuthenticatePhaseListener implements PhaseListener {

    public static final String USER_SESSION_KEY = "member";
    public static final String ADMIN_SESSION_KEY = "manage";
    public static final int AREA_FREE = 0;
    public static final int AREA_MANAGE = 1;
    public static final int AREA_CUSTOMER = 2;
    public static final String ERROR_ADMIN = "adminerror";
    public static final String ERROR_CUSTOMER = "customererror";
    public static final String LOGIN_ADMIN = "adminlogin";
    public static final String LOGIN_CUSTOMER = "customerlogin";

    @Override
    public void afterPhase(PhaseEvent event) {
        FacesContext context = event.getFacesContext();
        String requestPath = context.getExternalContext().getRequestPathInfo();
        int areaAccess = getAreaAccess(requestPath);
        switch (areaAccess) {
            //area free can access free
            case AREA_FREE:
                break;
            // area only for manage
            case AREA_MANAGE:
                //check if user login a manage account
                Manage manage = (Manage) isUserLogin(context, areaAccess);
                if (manage != null) {
                    //user login so check authority
                    if (!isAdminCanAccess(manage, requestPath)) {
                        //to error page if not allow
                        context.responseComplete();
                        context.getApplication().
                                getNavigationHandler().handleNavigation(context, null, ERROR_ADMIN);
                    }
                } else {
                    //user not login so to login page
                    context.responseComplete();
                    context.getApplication().
                            getNavigationHandler().handleNavigation(context, null, LOGIN_ADMIN);
                }
                break;
            case AREA_CUSTOMER:
                Member member = (Member) isUserLogin(context, areaAccess);
                //member just check login
                if (member == null) {
                    context.responseComplete();
                    context.getApplication().
                            getNavigationHandler().handleNavigation(context, null, LOGIN_CUSTOMER);
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void beforePhase(PhaseEvent event) {
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }

    public int getAreaAccess(String url) {
        if (url.indexOf("admin") != -1) {
            if (url.indexOf("free") != -1) {
                return AREA_FREE;
            }
            return AREA_MANAGE;
        } else if (url.indexOf("member") != -1) {
            return AREA_CUSTOMER;
        } else {
            return AREA_FREE;
        }
    }

    private Object isUserLogin(FacesContext context, int areaAccess) {
        ExternalContext extContext = context.getExternalContext();
        if (areaAccess == AREA_MANAGE) {
            return (extContext.getSessionMap().get(ADMIN_SESSION_KEY));
        } else if (areaAccess == AREA_CUSTOMER) {
            return (extContext.getSessionMap().get(USER_SESSION_KEY));
        } else {
            return null;
        }
    }

    private boolean isAdminCanAccess(Manage manage, String requestPath) {
        boolean isAllow = false;
        if (requestPath.indexOf("common") != -1) {
            return true;
        }
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        ManageManagedBean bean = (ManageManagedBean) request.getSession().getAttribute("manageManagedBean");
        if (bean == null) {
            bean = new ManageManagedBean();
            request.getSession().setAttribute("manageManagedBean", bean);
        }
        List<Permission> lstPer = bean.getListPerAdded(manage);

        for (Permission permission : lstPer) {
            String urlPattern = permission.getUrlPattern();
            String per = permission.getUrlPattern().substring(0, urlPattern.length() - 1);
            if (requestPath.contains(per)) {
                isAllow = true;
                break;
            }
        }
        return isAllow;
    }
}
