/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.bean.client;

import g3.bean.utility.DvdStoreHibernateUtil;
import g3.hibernate.entity.Bill;
import g3.hibernate.entity.Member;
import java.lang.reflect.Constructor;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;

/**
 *
 * @author kiendv
 */
@ManagedBean
@RequestScoped
public class MemberBean {

    private String name;
    private String email;
    private String password;
    private String repassword;
    private Date joinedDate;
    private Date modifiedDate;
    private boolean isLock;
    private List<Member> members;
    Session session = null;

    public MemberBean() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public boolean isIsLock() {
        return isLock;
    }

    public void setIsLock(boolean isLock) {
        this.isLock = isLock;
    }

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

    public Session getSession() {
        return DvdStoreHibernateUtil.getSessionFactory().openSession();
    }

    public List<Member> getMembers() {
        return getSession().createQuery("FROM Member").list();
    }

    public String getProfileName() {
        String s = "";
        HttpSession ss = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        if (ss.getAttribute("member") != null) {
            Member m = (Member) ss.getAttribute("member");
            name = m.getName();
            password = m.getPassword();
            repassword = m.getPassword();
            s = m.getEmail();
        } else {
            s = "You must login.";
        }
        return s;
    }

    //Functions
    public String registry() {
        String page = "";
        boolean vname = ValidateBean.validEmpty(name);
        boolean vemail = ValidateBean.validEmail(email);
        boolean vpass1 = ValidateBean.validEmpty(password);
        boolean vpass = ValidateBean.compare(password, repassword);
        if (vname && vemail && vpass && !isExisted(email)) {
            try {
                String joined = DvdStoreHibernateUtil.currenrTime();
                String sql = "insert into Member values (N'" + name + "', '" + email + "', '" + password + "',null, '" + joined + "', '" + joined + "', 0)";
                getSession().createSQLQuery(sql).executeUpdate();
                getSession().beginTransaction().commit();
                page = "login";
            } catch (Exception ex) {
                FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("result", "Can not registry at this time.");
            }
        } else {
            if (!vname) {
                FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("result", "Name invalid.");
            }
            if (!vemail) {
                FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("result", "Email invalid.");
            }
            if (!vpass1 || !vpass) {
                FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("result", "Password not match.");
            }
            if (isExisted(email)) {
                FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("result", "This email was registed.");
            }
        }
        return page;
    }
    //Check existed this account or not

    public boolean isExisted(String mail) {
        Member mem = (Member) getSession().createQuery("FROM Member m WHERE m.email = '" + mail + "'").uniqueResult();
        if (mem == null) {
            return false;
        } else {
            return true;
        }
    }

    //Login
    public Member loginCode(String mail, String pass) {
        return (Member) getSession().createQuery("FROM Member m WHERE m.email = '" + mail + "' and m.password = '" + pass + "' and m.isLock = 0").uniqueResult();
    }

    public String login() {
        String page = "";
        boolean vemail = ValidateBean.validEmail(email);
        boolean vpass = ValidateBean.validEmpty(password);
        if (vemail && vpass) {
            Member mem = loginCode(email, password);
            if (mem != null) {
                HttpSession ss = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                ss.setAttribute("member", mem);
                return "profile";
            } else {
                FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("result", "Not exist this member or locked, please retry.");
            }
        } else {
            if (!vemail) {
                FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("result", "Email invalid.");
            }
            if (!vpass) {
                FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("result", "Password so short!");
            }
        }
        return page;
    }
    //Change Profile

    public void modify() {
        String page = "";
        boolean vname = ValidateBean.validEmpty(name);
        boolean vpass1 = ValidateBean.validEmpty(password);
        boolean vpass = ValidateBean.compare(password, repassword);
        if (vname && vpass) {
            try {
                HttpSession ss = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                String mail = ((Member) ss.getAttribute("member")).getEmail();
                String modified = DvdStoreHibernateUtil.currenrTime();
                String sql = "update Member set name = '" + name + "', password = '" + password + "', modifiedDate = '" + modified + "' where email = '" + mail + "'";
                getSession().createSQLQuery(sql).executeUpdate();
                getSession().beginTransaction().commit();
                FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("result ok", "Change info successful!");
                ss.setAttribute("member", loginCode(mail, password));
            } catch (Exception ex) {
                FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("result", "Can not change profile at this time.");
            }
        } else {
            if (!vname) {
                FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("result", "Name invalid.");
            }
            if (!vpass1 || !vpass) {
                FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("result", "Password not match.");
            }
        }
    }
    //Logout

    public String logout() {
        HttpSession ss = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        ss.setAttribute("member", null);
        return "../index.xhtml?faces-redirect=true";
    }
}
