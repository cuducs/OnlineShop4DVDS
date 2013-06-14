/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.bean.security;

import g3.bean.utility.BaseHelper;
import g3.hibernate.entity.Permission;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Administrator
 */
public class PermissionManagedHelper extends BaseHelper {

    private static PermissionManagedHelper instance;

    private PermissionManagedHelper() {
    }

    public static PermissionManagedHelper getInstance() {
        if (instance == null) {
            instance = new PermissionManagedHelper();
        }
        return instance;
    }

    public List<Permission> getAllPermissions() {
        Transaction beginTransaction = session.beginTransaction();
        String hql = "FROM Permission g WHERE g.isDeleted=0 and isBase=0";
        Query query = session.createQuery(hql);
        beginTransaction.commit();
        return query.list();
    }

    List<Permission> getAllPermissionsDeleted() {
        Transaction beginTransaction = session.beginTransaction();
        String hql = "FROM Permission g WHERE g.isDeleted=1 and isBase=0";
        Query query = session.createQuery(hql);
        beginTransaction.commit();
        return query.list();
    }

    List<Permission> search(Permission searchPermission) {
        Criteria criteria = session.createCriteria(Permission.class);
        if (searchPermission.getId() > 0) {
            criteria.add(Expression.eq("id", searchPermission.getId()));
        }
        if (searchPermission.getTitle() != "") {
            criteria.add(Expression.ilike("title", "%" + searchPermission.getTitle() + "%"));
        }
//        if (searchPermission.getLyrics() != "") {
//            criteria.add(org.hibernate.criterion.Expression.ilike("lyrics", "%" + searchPermission.getLyrics() + "%"));
//        }
//        criteria.add(org.hibernate.critersion.Expression.eq("isFree", searchPermission.isIsFree()));
        return criteria.list();
    }

    List<Permission> getListPerAdded(Permission curPermission) {
        Criteria criteria = session.createCriteria(Permission.class);
        if (null != curPermission.getUrlPattern()) {
            List<String> lstStr = Arrays.asList(curPermission.getUrlPattern().split(","));
            if (lstStr.size() > 0) {
                criteria.add(Restrictions.in("urlPattern", lstStr));
            }
        } else {
            return null;
        }
        criteria.add(Expression.eq("isBase", true));
        criteria.add(Expression.eq("isDeleted", false));
        return criteria.list();
    }

    List<Permission> getListPerCanAdd(Permission curPermission) {
        Criteria criteria = session.createCriteria(Permission.class);
        if (null != curPermission.getUrlPattern()) {
            List<String> lstStr = Arrays.asList(curPermission.getUrlPattern().split(","));

            if (lstStr.size() > 0) {
                criteria.add(Restrictions.not(Restrictions.in("urlPattern", lstStr)));
            }
        }
        criteria.add(Expression.eq("isBase", true));
        criteria.add(Expression.eq("isDeleted", false));
        return criteria.list();
    }

    void addPer(Permission curPermission, Permission item) {
        if (curPermission.getUrlPattern() == null) {
            curPermission.setUrlPattern(item.getUrlPattern());
        } else {
            String urlPattern = curPermission.getUrlPattern() + "," + item.getUrlPattern();
            curPermission.setUrlPattern(urlPattern);
        }
    }

    void removePer(Permission curPermission, Permission item) {
        if (curPermission.getUrlPattern() == null || item.getUrlPattern() == null) {
            return;
        } else {
            String urlPattern = curPermission.getUrlPattern();
            String removeUrl = item.getUrlPattern();
            if (urlPattern.contains(removeUrl)) {
                int index = urlPattern.indexOf(removeUrl);
                if (index != 0) {
                    String split1 = urlPattern.substring(0, index - 1);
                    String split2 = urlPattern.substring(index + removeUrl.length());
                    curPermission.setUrlPattern(split1 + split2);
                } else {
                    curPermission.setUrlPattern(urlPattern.substring(index + removeUrl.length() + 1));
                }
            }
        }
    }

    List<Permission> searchPerCanAdd(Permission curPermission, List<Permission> lstPer) {
        Transaction beginTransaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(Permission.class);
        if (null != curPermission.getUrlPattern()) {
            List<String> lstStr = Arrays.asList(curPermission.getUrlPattern().split(","));

            if (lstStr.size() > 0) {
                criteria.add(Restrictions.not(Restrictions.in("urlPattern", lstStr)));
            }
        }

        if (lstPer != null) {
            List<Integer> lstInt = new ArrayList<Integer>();
            for (Permission per : lstPer) {
                lstInt.add(per.getId());
            }
            if (lstInt.size() > 0) {
                criteria.add(Restrictions.in("id", lstInt));
            }
        }

        criteria.add(Expression.eq("isBase", true));
        criteria.add(Expression.eq("isDeleted", false));
        beginTransaction.commit();

        return criteria.list();
    }
}
