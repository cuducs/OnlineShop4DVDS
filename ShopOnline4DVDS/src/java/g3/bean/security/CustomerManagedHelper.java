/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.bean.security;

import g3.bean.utility.BaseHelper;
import g3.hibernate.entity.Member;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;

/**
 *
 * @author Administrator
 */
public class CustomerManagedHelper extends BaseHelper {

    private static CustomerManagedHelper instance;

    private CustomerManagedHelper() {
    }

    public static CustomerManagedHelper getInstance() {
        if (instance == null) {
            instance = new CustomerManagedHelper();
        }
        return instance;
    }

    List<Member> search(Member searchCustomer) {
        Criteria criteria = session.createCriteria(Member.class);
        if (searchCustomer.getName() != "") {
            criteria.add(Expression.ilike("name", "%" + searchCustomer.getName() + "%"));
        }
        if (searchCustomer.getEmail() != "") {
            criteria.add(Expression.ilike("email", "%" + searchCustomer.getEmail() + "%"));
        }
        criteria.add(Expression.eq("isLock", searchCustomer.isIsLock()));
        return criteria.list();
    }
}
