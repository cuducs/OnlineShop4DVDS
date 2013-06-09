/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.bean.other;

import g3.hibernate.entity.MappingTable;
import g3.bean.client.BaseHelper;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Transaction;

/**
 *
 * @author DUCVM
 */
public class MappingTableManagedHelper  extends BaseHelper{
     private static MappingTableManagedHelper instance;
      
      private MappingTableManagedHelper() {
    }

    public static MappingTableManagedHelper getInstance() {
        if (instance == null) {
            instance = new MappingTableManagedHelper();
        }
        return instance;
    }

    public List<MappingTable> getAllMappingTables() {
        Transaction beginTransaction = session.beginTransaction();
        String hql = "FROM ObjectOfBrowsingRule";
        Query query = session.createQuery(hql);
        beginTransaction.commit();
        return query.list();
    }

    public MappingTable getMappingTable(String tableA, String tableB)
    {
        try
        {
            MappingTable result;
            Transaction beginTransaction = session.beginTransaction();
            String hql = "FROM MappingTable g WHERE g.tableA=" + tableA + " And g.tableB=" + tableB;
            Query query = session.createQuery(hql);
            beginTransaction.commit();
            result = (MappingTable) (query.list().get(0));
            return result;
        }
        catch(Exception ex) {
            return null;
        }
    }
    
    public String getJoinQuery(String tableA, String tableB)
    {
        try
        {
            String result;
            Transaction beginTransaction = session.beginTransaction();
            String hql = "FROM MappingTable g WHERE g.tableA='" + tableA + "' And g.tableB='" + tableB + "'";
            Query query = session.createQuery(hql);
            beginTransaction.commit();
            List<MappingTable> lst = query.list();
            if (lst.size() > 0) {
                result = lst.get(0).getQueryToJoin();
            }
            else {
                result = null;
            }
            return result;
        }
        catch(Exception ex) {
            System.out.printf("co loi :" + ex.getMessage());
            return null;
        }
    }
}
