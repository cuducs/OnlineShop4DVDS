/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.bean.manage.product;

import g3.hibernate.entity.Dvd;
import g3.bean.utility.BaseHelper;
import g3.hibernate.entity.Producer;
import g3.hibernate.entity.Supplier;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

    public List<Dvd> getAllDvdsDeleted() {
        Transaction beginTransaction = session.beginTransaction();
        String hql = "FROM Dvd d WHERE d.isDeleted=1";
        Query query = session.createQuery(hql);
        beginTransaction.commit();
        return query.list();
    }

    public List<Dvd> search(Dvd searchDvd) {
        Criteria criteria = session.createCriteria(Dvd.class);
        if (searchDvd.getTitle() != "" && searchDvd.getTitle() != null) {
            criteria.add(Expression.ilike("title", "%" + searchDvd.getTitle() + "%"));
        }
        if (searchDvd.getReleaseDate() != null) {
            criteria.add(Expression.eq("releaseDate", searchDvd.getReleaseDate()));
        }
        if (searchDvd.getGenres() != "" && searchDvd.getGenres() != null) {
            criteria.add(Expression.ilike("genres", "%" + searchDvd.getGenres() + "%"));
        }
        if (searchDvd.getDescription() != "" && searchDvd.getDescription() != null) {
            criteria.add(Expression.ilike("description", "%" + searchDvd.getDescription() + "%"));
        }
        if (searchDvd.getPrice() != null) {
            criteria.add(Expression.eq("price", searchDvd.getPrice()));
        }
        if (searchDvd.getAuthor() != "" && searchDvd.getAuthor() != null) {
            criteria.add(Expression.ilike("author", "%" + searchDvd.getAuthor() + "%"));
        }
        if (searchDvd.getDiscNumber() != null) {
            criteria.add(Expression.eq("discNumber", searchDvd.getDiscNumber()));
        }
        if (searchDvd.getType() != null) {
            criteria.add(Expression.eq("type", searchDvd.getType()));
        }
        if (searchDvd.getSupplierId() != null) {
            criteria.add(Expression.eq("supplierId", searchDvd.getSupplierId()));
        }
        if (searchDvd.getProducerId() != null) {
            criteria.add(Expression.eq("producerId", searchDvd.getProducerId()));
        }
        criteria.add(Expression.eq("isDeleted", searchDvd.isIsDeleted()));
        return criteria.list();
    }

    public Dvd getById(int id) {
        Transaction beginTransaction = session.beginTransaction();
        String hql = "FROM Dvd d WHERE d.isDeleted=0 and d.id=" + id;
        Query query = session.createQuery(hql);
        beginTransaction.commit();
        if (query.list().size() > 0) {
            return (Dvd) query.list().get(0);
        }
        return null;
    }

    public boolean addAndIfNeed(StringBuilder str, boolean isFirst) {
        if (!isFirst) {
            str.append(" And ");
        } else {
            str.append(" Where ");
            isFirst = false;
        }
        return isFirst;
    }

    public List<Dvd> getCriteriaSearch(Dvd searchDvd) {
        StringBuilder query = new StringBuilder("From Dvd d ");
        boolean isFirst = true;
        if (searchDvd.getId() > 0) {
            isFirst = addAndIfNeed(query, isFirst);
            query.append(" d.id=" + searchDvd.getId() + " ");
        }
        if (searchDvd.getTitle() != "" && searchDvd.getTitle() != null) {
            isFirst = addAndIfNeed(query, isFirst);
            query.append(" d.title like '%" + searchDvd.getTitle() + "%' ");
        }
        if (searchDvd.getReleaseDate() != null) {
            isFirst = addAndIfNeed(query, isFirst);
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            query.append(" d.releaseDate='" + format.format(searchDvd.getReleaseDate()) + "' ");
        }
        if (searchDvd.getGenres() != "" && searchDvd.getGenres() != null) {
            isFirst = addAndIfNeed(query, isFirst);
            query.append(" d.genres like '%" + searchDvd.getGenres() + "%' ");
        }
        if (searchDvd.getDescription() != "" && searchDvd.getDescription() != null) {
            isFirst = addAndIfNeed(query, isFirst);
            query.append(" d.description like '%" + searchDvd.getDescription() + "%' ");
        }
        if (searchDvd.getPrice() != null) {
            isFirst = addAndIfNeed(query, isFirst);
            query.append(" d.price=" + searchDvd.getPrice() + " ");
        }
//        if (searchDvd.getImageCoverUrl() != "" && searchDvd.getImageCoverUrl() != null) {
//            isFirst = addAndIfNeed(query, isFirst);
//            query.append(" d.imageCoverUrl like '%" + searchDvd.getImageCoverUrl() + "%' ");
//        }
        if (searchDvd.getAuthor() != "" && searchDvd.getAuthor() != null) {
            isFirst = addAndIfNeed(query, isFirst);
            query.append(" d.author like '%" + searchDvd.getAuthor() + "%' ");
        }
        if (searchDvd.getDiscNumber() != null) {
            isFirst = addAndIfNeed(query, isFirst);
            query.append(" d.discNumber=" + searchDvd.getDiscNumber() + " ");
        }
        if (searchDvd.getType() != null) {
            isFirst = addAndIfNeed(query, isFirst);
            query.append(" d.type='" + searchDvd.getType() + "' ");
        }
        return session.createQuery(query.toString()).list();
    }

    List<Producer> getListProducer() {
        return session.createQuery("From Producer p where p.isDeleted=0").list();
    }

    List<Supplier> getListSupplier() {
        return session.createQuery("From Supplier s where s.isDeleted=0").list();
    }
    
    public void updateRateing(Dvd product)
    {
       Transaction beginTransaction = session.beginTransaction();
       session.update(product);
       beginTransaction.commit();
    }
}
