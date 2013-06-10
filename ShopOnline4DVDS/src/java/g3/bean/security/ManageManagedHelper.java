/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.bean.security;

import g3.bean.utility.BaseHelper;
import g3.hibernate.entity.Manage;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Transaction;

/**
 *
 * @author Administrator
 */
public class ManageManagedHelper extends BaseHelper {

    private static ManageManagedHelper instance;

    private ManageManagedHelper() {
    }

    public static ManageManagedHelper getInstance() {
        if (instance == null) {
            instance = new ManageManagedHelper();
        }
        return instance;
    }

    public List<Manage> getAllManages() {
        Transaction beginTransaction = session.beginTransaction();
        String hql = "FROM Manage g WHERE g.isLock=0";
        Query query = session.createQuery(hql);
        beginTransaction.commit();
        return query.list();
    }

    List<Manage> getAllManagesDeleted() {
        Transaction beginTransaction = session.beginTransaction();
        String hql = "FROM Manage g WHERE g.isLock=1";
        Query query = session.createQuery(hql);
        beginTransaction.commit();
        return query.list();
    }

    List<Manage> search(Manage searchManage) {
        Criteria criteria = session.createCriteria(Manage.class);
        if (searchManage.getId() > 0) {
            criteria.add(org.hibernate.criterion.Expression.eq("id", searchManage.getId()));
        }
        if (searchManage.getName() != "") {
            criteria.add(org.hibernate.criterion.Expression.ilike("title", "%" + searchManage.getName() + "%"));
        }
//        if (searchManage.getLyrics() != "") {
//            criteria.add(org.hibernate.criterion.Expression.ilike("lyrics", "%" + searchManage.getLyrics() + "%"));
//        }
//        criteria.add(org.hibernate.critersion.Expression.eq("isFree", searchManage.isIsFree()));
        return criteria.list();
    }
}
