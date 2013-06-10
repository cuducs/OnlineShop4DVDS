/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.bean.manage.other;

import g3.bean.utility.BaseHelper;
import g3.hibernate.entity.Supplier;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Transaction;

/**
 *
 * @author Administrator
 */
public class SupplierManagedHelper extends BaseHelper{
    private static SupplierManagedHelper instance;

    private SupplierManagedHelper() {
    }

    public static SupplierManagedHelper getInstance() {
        if (instance == null) {
            instance = new SupplierManagedHelper();
        }
        return instance;
    }

    public List<Supplier> getAllSuppliers() {
        Transaction beginTransaction = session.beginTransaction();
        String hql = "FROM Supplier g WHERE g.isDeleted=0";
        Query query = session.createQuery(hql);
        beginTransaction.commit();
        return query.list();
    }

    List<Supplier> getAllSuppliersDeleted() {
        Transaction beginTransaction = session.beginTransaction();
        String hql = "FROM Supplier g WHERE g.isDeleted=1";
        Query query = session.createQuery(hql);
        beginTransaction.commit();
        return query.list();
    }

    List<Supplier> search(Supplier searchSupplier) {
        Criteria criteria = session.createCriteria(Supplier.class);
        if (searchSupplier.getId() > 0) {
            criteria.add(org.hibernate.criterion.Expression.eq("id", searchSupplier.getId()));
        }
        if (searchSupplier.getTitle() != "") {
            criteria.add(org.hibernate.criterion.Expression.ilike("title", "%" + searchSupplier.getTitle() + "%"));
        }
//        if (searchSupplier.getLyrics() != "") {
//            criteria.add(org.hibernate.criterion.Expression.ilike("lyrics", "%" + searchSupplier.getLyrics() + "%"));
//        }
//        criteria.add(org.hibernate.critersion.Expression.eq("isFree", searchSupplier.isIsFree()));
        return criteria.list();
    }
}
