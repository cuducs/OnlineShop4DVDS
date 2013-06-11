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
import org.hibernate.criterion.Expression;

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
        if (searchSupplier.getTitle() != "") {
            criteria.add(Expression.ilike("title", "%" + searchSupplier.getTitle() + "%"));
        }
        if (searchSupplier.getInfo() != "") {
            criteria.add(Expression.ilike("info", "%" + searchSupplier.getInfo() + "%"));
        }
        criteria.add(Expression.eq("isDeleted", searchSupplier.isIsDeleted()));
        return criteria.list();
    }
}
