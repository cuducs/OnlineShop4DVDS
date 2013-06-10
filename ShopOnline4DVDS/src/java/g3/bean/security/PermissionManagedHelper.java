/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.bean.security;

import g3.bean.utility.BaseHelper;
import g3.hibernate.entity.Permission;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Transaction;

/**
 *
 * @author Administrator
 */
public class PermissionManagedHelper extends BaseHelper{
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
        String hql = "FROM Permission g WHERE g.isDeleted=0";
        Query query = session.createQuery(hql);
        beginTransaction.commit();
        return query.list();
    }

    List<Permission> getAllPermissionsDeleted() {
        Transaction beginTransaction = session.beginTransaction();
        String hql = "FROM Permission g WHERE g.isDeleted=1";
        Query query = session.createQuery(hql);
        beginTransaction.commit();
        return query.list();
    }

    List<Permission> search(Permission searchPermission) {
        Criteria criteria = session.createCriteria(Permission.class);
        if (searchPermission.getId() > 0) {
            criteria.add(org.hibernate.criterion.Expression.eq("id", searchPermission.getId()));
        }
        if (searchPermission.getTitle() != "") {
            criteria.add(org.hibernate.criterion.Expression.ilike("title", "%" + searchPermission.getTitle() + "%"));
        }
//        if (searchPermission.getLyrics() != "") {
//            criteria.add(org.hibernate.criterion.Expression.ilike("lyrics", "%" + searchPermission.getLyrics() + "%"));
//        }
//        criteria.add(org.hibernate.critersion.Expression.eq("isFree", searchPermission.isIsFree()));
        return criteria.list();
    }
}
