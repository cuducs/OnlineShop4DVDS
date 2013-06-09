/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.bean.manage.other;

import g3.bean.utility.BaseHelper;
import g3.hibernate.entity.Producer;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Transaction;

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
        if (searchProducer.getId() > 0) {
            criteria.add(org.hibernate.criterion.Expression.eq("id", searchProducer.getId()));
        }
        if (searchProducer.getTitle() != "") {
            criteria.add(org.hibernate.criterion.Expression.ilike("title", "%" + searchProducer.getTitle() + "%"));
        }
//        if (searchProducer.getLyrics() != "") {
//            criteria.add(org.hibernate.criterion.Expression.ilike("lyrics", "%" + searchProducer.getLyrics() + "%"));
//        }
//        criteria.add(org.hibernate.critersion.Expression.eq("isFree", searchProducer.isIsFree()));
        return criteria.list();
    }
}
