/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.server.bean.manage;

import g3.hibernate.entity.ver2.Dvd;
import g3.server.bean.BaseHelper;
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

    public boolean save(Dvd curDvd) {
        Transaction beginTransaction = session.beginTransaction();
        session.save(curDvd);
        beginTransaction.commit();
        if (curDvd.getId() != 0) {
            return true;
        }
        return false;
    }

    public void del(Dvd item) {
        Transaction beginTransaction = session.beginTransaction();
        session.delete(item);
        beginTransaction.commit();

    }

    public void update(Dvd item) {
        Transaction beginTransaction = session.beginTransaction();
        session.update(item);
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
        if (searchDvd.getId() > 0) {
            criteria.add(Expression.eq("id", searchDvd.getId()));
        }
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
//        if (searchDvd.getImageCoverUrl() != "" && searchDvd.getImageCoverUrl() != null) {
//            criteria.add(Expression.ilike("imageCoverUrl", "%" + searchDvd.getImageCoverUrl() + "%"));
//        }
        if (searchDvd.getAuthor() != "" && searchDvd.getAuthor() != null) {
            criteria.add(Expression.ilike("author", "%" + searchDvd.getAuthor() + "%"));
        }
        if (searchDvd.getDiscNumber() != null) {
            criteria.add(Expression.eq("discNumber", searchDvd.getDiscNumber()));
        }
        if (searchDvd.getType() != null) {
            criteria.add(Expression.eq("type", searchDvd.getType()));
        }
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
}
