/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.bean.other;

import g3.bean.utility.BaseHelper;
import g3.hibernate.entity.Category;
import g3.hibernate.entity.Dvd;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Transaction;

/**
 *
 * @author Administrator
 */
public class CategoryManagedHelper extends BaseHelper {
    
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
    
    public Category searchById(int id) {
        Transaction beginTransaction = session.beginTransaction();
        String hql = "FROM Category g WHERE g.isDeleted=0 and g.id=" + id;
        Query query = session.createQuery(hql);
        beginTransaction.commit();
        return (Category) query.list().get(0);
    }
    
    List<Category> getChildCategories(Category cate) {
        Transaction beginTransaction = session.beginTransaction();
        String hql = "FROM Category g WHERE g.isDeleted=0 and g.categoryParentId=" + cate.getId();
        Query query = session.createQuery(hql);
        beginTransaction.commit();
        return query.list();
    }
    
    int getMaxId() {
        Transaction beginTransaction = session.beginTransaction();
        String hql = "FROM Category g WHERE g.isDeleted=0 order by g.id desc";
        Query query = session.createQuery(hql);
        beginTransaction.commit();
        return ((Category) query.list().get(0)).getId();
    }
     
    public List<Dvd> getProductsInCateDetail(Category cate) {        
        try
        {
            Query query = session.createSQLQuery(cate.getQuery()).addEntity(Dvd.class);
            List results = query.list();
            return results;
        }
        catch(Exception ex)
        {
            System.out.printf(ex.toString());
        }
        return null;
    }
      
    public List<Dvd> getProductsInCateDetail(Category cate, int page, int itemsPerPage) {        
        try
        {
            Query query = session.createSQLQuery(cate.getQuery()).addEntity(Dvd.class).setFirstResult(itemsPerPage * ((page) - 1)).setMaxResults(itemsPerPage);
            List results = query.list();
            return results;
        }
        catch(Exception ex)
        {
            System.out.printf(ex.toString());
        }
        return null;
    }
    public int getProductsInCateDetailTotal(Category cate) {
        Query query = session.createSQLQuery(cate.getQuery()).addEntity(Dvd.class);
        List results = query.list();
        return query.list().size();
    }
}
