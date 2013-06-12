/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.bean.security;

import g3.bean.utility.AppConstant;
import g3.custom.phaselistener.AuthenticatePhaseListener;
import g3.hibernate.entity.Manage;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Administrator
 */
@ManagedBean
@RequestScoped
public class SecurityBean {
    
    private String username;
    private String password;

    /**
     * Creates a new instance of SecurityBean
     */
    public SecurityBean() {
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String login() {
        if (username != null && password != null && !username.equals("") && !password.equals("")) {
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            ManageManagedBean bean = (ManageManagedBean) request.getSession().getAttribute("manageManagedBean");
            if (bean == null) {
                bean = new ManageManagedBean();
                bean.init();
                request.getSession().setAttribute("manageManagedBean", bean);
            }
            Manage matchManage = bean.findManageByName(username);
            if (matchManage == null) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Wrong name!", "Cannot find manage");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            } else {
                if (matchManage.getPassword().equals(password)) {
                    HttpSession ss = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                    ss.setAttribute(AuthenticatePhaseListener.ADMIN_SESSION_KEY, matchManage);
                    matchManage.setLastLogin(matchManage.getNewLogin());
                    matchManage.setNewLogin(new Date());
                    return "adminwelcome";
                } else {
                    FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Wrong Password!", "Password does not match");
                    FacesContext.getCurrentInstance().addMessage(null, msg);
                }
            }
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Name and password is required", "Please, Input name and password");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        return null;
    }
    
    public String logout() {
        HttpSession ss = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        Manage manage = (Manage) ss.getAttribute(AuthenticatePhaseListener.ADMIN_SESSION_KEY);
        if (manage != null) {
            ss.setAttribute(AuthenticatePhaseListener.ADMIN_SESSION_KEY, null);
        }
        return "adminlogin";
    }
}
