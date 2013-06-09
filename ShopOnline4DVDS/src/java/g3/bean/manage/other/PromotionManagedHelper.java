/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.bean.manage.other;

import g3.bean.utility.BaseHelper;
import g3.hibernate.entity.Promotion;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Transaction;

/**
 *
 * @author Administrator
 */
public class PromotionManagedHelper extends BaseHelper{
    private static PromotionManagedHelper instance;

    private PromotionManagedHelper() {
    }

    public static PromotionManagedHelper getInstance() {
        if (instance == null) {
            instance = new PromotionManagedHelper();
        }
        return instance;
    }

    public List<Promotion> getAllPromotions() {
        Transaction beginTransaction = session.beginTransaction();
        String hql = "FROM Promotion g WHERE g.isDeleted=0";
        Query query = session.createQuery(hql);
        beginTransaction.commit();
        return query.list();
    }

    List<Promotion> getAllPromotionsDeleted() {
        Transaction beginTransaction = session.beginTransaction();
        String hql = "FROM Promotion g WHERE g.isDeleted=1";
        Query query = session.createQuery(hql);
        beginTransaction.commit();
        return query.list();
    }

    List<Promotion> search(Promotion searchPromotion) {
        Criteria criteria = session.createCriteria(Promotion.class);
        if (searchPromotion.getId() > 0) {
            criteria.add(org.hibernate.criterion.Expression.eq("id", searchPromotion.getId()));
        }
        if (searchPromotion.getTitle() != "") {
            criteria.add(org.hibernate.criterion.Expression.ilike("title", "%" + searchPromotion.getTitle() + "%"));
        }
//        if (searchPromotion.getLyrics() != "") {
//            criteria.add(org.hibernate.criterion.Expression.ilike("lyrics", "%" + searchPromotion.getLyrics() + "%"));
//        }
//        criteria.add(org.hibernate.critersion.Expression.eq("isFree", searchPromotion.isIsFree()));
        return criteria.list();
    }
}
