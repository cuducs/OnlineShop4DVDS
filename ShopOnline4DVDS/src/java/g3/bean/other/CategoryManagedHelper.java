/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.bean.other;
import g3.hibernate.entity.Category;
import g3.bean.utility.BaseHelper;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Transaction;
/**
 *
 * @author Administrator
 */
class CategoryManagedHelper extends BaseHelper {
      private static CategoryManagedHelper instance;
      
      private CategoryManagedHelper() {
    }

    public static CategoryManagedHelper getInstance() {
        if (instance == null) {
            instance = new CategoryManagedHelper();
        }
        return instance;
    }

    public List<Category> getAllCategories() {
        Transaction beginTransaction = session.beginTransaction();
        String hql = "FROM Category g WHERE g.isDeleted=0 order by g.woodenLeg asc";
        Query query = session.createQuery(hql);
        beginTransaction.commit();
        return query.list();
    }

    public boolean save(Category curCate) {
        Transaction beginTransaction = session.beginTransaction();
        session.save(curCate);
        beginTransaction.commit();
        if (curCate.getId() != 0) {
            return true;
        }
        return false;
    }

    void del(Category item) {
        Transaction beginTransaction = session.beginTransaction();
//        session.delete(item);
        item.setIsDeleted(true);
        beginTransaction.commit();

    }

    void update(Category item) {
        Transaction beginTransaction = session.beginTransaction();
        session.update(item);
    }

    List<Category> getAllCategoriesDeleted() {
        Transaction beginTransaction = session.beginTransaction();
        String hql = "FROM Category g WHERE g.isDeleted=1";
        Query query = session.createQuery(hql);
        beginTransaction.commit();
        return query.list();
    }

    Category searchById(int id) {
         Transaction beginTransaction = session.beginTransaction();
        String hql = "FROM Category g WHERE g.isDeleted=0 and g.id=" + id;
        Query query = session.createQuery(hql);
        beginTransaction.commit();
        return (Category) query.list().get(0);
    }
    
     int getMaxId() {
         Transaction beginTransaction = session.beginTransaction();
        String hql = "FROM Category g WHERE g.isDeleted=0 order by g.id desc";
        Query query = session.createQuery(hql);
        beginTransaction.commit();
        return ((Category) query.list().get(0)).getId();
    }
}
