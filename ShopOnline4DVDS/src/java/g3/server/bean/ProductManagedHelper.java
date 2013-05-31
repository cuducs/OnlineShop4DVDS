/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.server.bean;

import g3.hibernate.entity.Dvd;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;

/**
 *
 * @author Administrator
 */
public class ProductManagedHelper extends BaseHelper {

    private static ProductManagedHelper instance;

    private ProductManagedHelper() {
    }

    public static ProductManagedHelper getInstance() {
        if (instance == null) {
            instance = new ProductManagedHelper();
        }
        return instance;
    }
    
    
    public List<Dvd> getAllDvds() {
        Transaction beginTransaction = session.beginTransaction();
        String hql = "FROM Dvd d WHERE d.isDeleted=0";
        Query query = session.createQuery(hql);
        beginTransaction.commit();
        return query.list();
    }

    public boolean save(Dvd curDvd) {
        Transaction beginTransaction = session.beginTransaction();
        session.save(curDvd);
        beginTransaction.commit();
        if (curDvd.getId() != 0) {
            return true;
        }
        return false;
    }

    void del(Dvd item) {
        Transaction beginTransaction = session.beginTransaction();
        session.delete(item);
        beginTransaction.commit();

    }

    void update(Dvd item) {
        Transaction beginTransaction = session.beginTransaction();
        session.update(item);
    }

    List<Dvd> getAllDvdsDeleted() {
        Transaction beginTransaction = session.beginTransaction();
        String hql = "FROM Dvd d WHERE d.isDeleted=1";
        Query query = session.createQuery(hql);
        beginTransaction.commit();
        return query.list();
    }

    List<Dvd> search(Dvd searchDvd) {
        Criteria criteria = session.createCriteria(Dvd.class);
        if (searchDvd.getId() > 0) {
            criteria.add(Expression.eq("id", searchDvd.getId()));
        }
        if (searchDvd.getTitle() != "") {
            criteria.add(Expression.ilike("title", "%" + searchDvd.getTitle() + "%"));
        }
        if(searchDvd.getReleaseDate()!=null){
            criteria.add(Expression.eq("releaseDate", searchDvd.getReleaseDate()));
        }
        if(searchDvd.getGenres()!=""){
            criteria.add(Expression.ilike("genres", "%" + searchDvd.getGenres() + "%"));
        }
        if(searchDvd.getDescription()!=""){
            criteria.add(Expression.ilike("description", "%" + searchDvd.getDescription() + "%"));
        }
        if(searchDvd.getPrice()!=null){
            criteria.add(Expression.eq("price", searchDvd.getPrice()));
        }
        if(searchDvd.getImageCoverUrl()!=""){
            criteria.add(Expression.ilike("imageCoverUrl", "%" + searchDvd.getImageCoverUrl() + "%"));
        }
        if(searchDvd.getAuthor()!=""){
            criteria.add(Expression.ilike("author", "%" + searchDvd.getAuthor() + "%"));
        }
        if(searchDvd.getDiscNumber()!=null){
            criteria.add(Expression.eq("discNumber", searchDvd.getDiscNumber()));
        }
        if(searchDvd.getType()!=null){
            criteria.add(Expression.eq("type", searchDvd.getType()));
        }
        return criteria.list();
    }
    Dvd getById(int id){
        Transaction beginTransaction = session.beginTransaction();
        String hql = "FROM Dvd d WHERE d.isDeleted=0 and d.id="+id;
        Query query = session.createQuery(hql);
        beginTransaction.commit();
        if(query.list().size()>0){
            return (Dvd)query.list().get(0);
        }
        return null;
    }
}
