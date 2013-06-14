/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.bean.manage.other;

import g3.bean.utility.BaseHelper;
import g3.hibernate.entity.Dvd;
import g3.hibernate.entity.Producer;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;

/**
 *
 * @author Administrator
 */
public class ProducerManagedHelper extends BaseHelper {

    private static ProducerManagedHelper instance;

    private ProducerManagedHelper() {
    }

    public static ProducerManagedHelper getInstance() {
        if (instance == null) {
            instance = new ProducerManagedHelper();
        }
        return instance;
    }

    public List<Producer> getAllProducers() {
        Transaction beginTransaction = session.beginTransaction();
        String hql = "FROM Producer g WHERE g.isDeleted=0";
        Query query = session.createQuery(hql);
        beginTransaction.commit();
        return query.list();
    }

    List<Producer> getAllProducersDeleted() {
        Transaction beginTransaction = session.beginTransaction();
        String hql = "FROM Producer g WHERE g.isDeleted=1";
        Query query = session.createQuery(hql);
        beginTransaction.commit();
        return query.list();
    }

    List<Producer> search(Producer searchProducer) {
        Criteria criteria = session.createCriteria(Producer.class);
        if (searchProducer.getTitle() != "") {
            criteria.add(Expression.ilike("title", "%" + searchProducer.getTitle() + "%"));
        }
        if (searchProducer.getInfo() != "") {
            criteria.add(Expression.ilike("info", "%" + searchProducer.getInfo() + "%"));
        }
        criteria.add(Expression.eq("isDeleted", searchProducer.isIsDeleted()));
        return criteria.list();
    }

    public void updateRateing(Dvd product) {
        Transaction beginTransaction = session.beginTransaction();
        session.update(product);
        beginTransaction.commit();
    }
}
