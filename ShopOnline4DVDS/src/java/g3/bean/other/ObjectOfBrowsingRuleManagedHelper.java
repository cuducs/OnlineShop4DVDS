/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.bean.other;
import g3.bean.utility.BaseHelper;
import g3.hibernate.entity.ObjectOfBrowsingRule;
import g3.hibernate.entity.ValueOfBrowsingRule;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Transaction;
/**
 *
 * @author Administrator
 */
class ObjectOfBrowsingRuleManagedHelper extends BaseHelper {
      private static ObjectOfBrowsingRuleManagedHelper instance;
      
      private ObjectOfBrowsingRuleManagedHelper() {
    }

    public static ObjectOfBrowsingRuleManagedHelper getInstance() {
        if (instance == null) {
            instance = new ObjectOfBrowsingRuleManagedHelper();
        }
        return instance;
    }

    public List<ObjectOfBrowsingRule> getAllObjectsOfBrowsingRule() {
        Transaction beginTransaction = session.beginTransaction();
        String hql = "FROM ObjectOfBrowsingRule";
        Query query = session.createQuery(hql);
        beginTransaction.commit();
        return query.list();
    }

    public ObjectOfBrowsingRule getObjectOfBrowsingRule(int id)
    {
        if(id > 0)
        {
            ObjectOfBrowsingRule result;
            Transaction beginTransaction = session.beginTransaction();
            String hql = "FROM ObjectOfBrowsingRule g WHERE g.id=" + id;
            Query query = session.createQuery(hql);
            beginTransaction.commit();
            result = (ObjectOfBrowsingRule) (query.list().get(0));
            return result;
        }
        else {
            return null;
        }
    }
   
    public List<ValueOfBrowsingRule> getListValueOfBrowsingRule(ObjectOfBrowsingRule obj) {        
        try
        {
            Query query = session.createSQLQuery(obj.getQueryToGetValue()).addEntity(ValueOfBrowsingRule.class);
            List results = query.list();


            return results;
        }
        catch(Exception ex)
        {
            System.out.printf(ex.toString());
        }
        return null;
    }
}
