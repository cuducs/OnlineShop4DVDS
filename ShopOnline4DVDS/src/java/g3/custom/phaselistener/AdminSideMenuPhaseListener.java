/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.custom.phaselistener;

import g3.other.admin.menu.AdminNavigatorBean;
import java.io.UnsupportedEncodingException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
public class AdminSideMenuPhaseListener implements PhaseListener {

    @Override
    public void afterPhase(PhaseEvent event) {
        FacesContext context = event.getFacesContext();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        HttpServletResponse res=(HttpServletResponse) context.getExternalContext().getResponse();
        try {
            request.setCharacterEncoding("UTF-8");
            res.setContentType("text/html; charset=UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(AdminSideMenuPhaseListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        AdminNavigatorBean bean = (AdminNavigatorBean) request.getSession().getAttribute("adminNavigatorBean");
        if(bean==null){
            bean=new AdminNavigatorBean();
            request.getSession().setAttribute("adminNavigatorBean", bean);
        }
        int menu = getTypeMenu(context);
        if (bean.getCurMenu() != menu && menu!=-1) {
            bean.setCurMenu(menu);
        }

    }

    @Override
    public void beforePhase(PhaseEvent event) {
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;

    }

    public int getTypeMenu(FacesContext context) {
        ExternalContext extContext = context.getExternalContext();
        String path = extContext.getRequestPathInfo();
        int output = -1;
        for (String str : getUrlProduct()) {
            if (path.indexOf(str) != -1) {
                output = AdminNavigatorBean.PRODUCT;
            }
        }
        return output;
    }

    public List<String> getUrlProduct() {
        List<String> lst = new ArrayList<String>();
        lst.add("admin/product/show");
        lst.add("admin/product/search");
        lst.add("admin/game/show");
        lst.add("admin/game/search");
        lst.add("admin/movie/show");
        lst.add("admin/movie/search");
        lst.add("admin/album/show");
        lst.add("admin/album/search");
        lst.add("admin/song/show");
        lst.add("admin/song/search");
        return lst;
    }
}
