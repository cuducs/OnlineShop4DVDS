/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.bean.client;

import g3.bean.utility.BaseHelper;
import g3.hibernate.entity.Dvd;
import g3.hibernate.entity.Browser;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;

/**
 *
 * @author Administrator
 */
public class BrowserManagedHelper extends BaseHelper {

    private static BrowserManagedHelper instance;

    private BrowserManagedHelper() {
    }

    public static BrowserManagedHelper getInstance() {
        if (instance == null) {
            instance = new BrowserManagedHelper();
        }
        return instance;
    }

    public List<Browser> getAllBrowsers() {
        Transaction beginTransaction = session.beginTransaction();
        String hql = "FROM Browser g";
        Query query = session.createQuery(hql);
        beginTransaction.commit();
        return query.list();
    }

    List<Browser> search(Browser searchBrowser) {
        Criteria criteria = session.createCriteria(Browser.class);
        if (searchBrowser.getId() > 0) {
            criteria.add(org.hibernate.criterion.Expression.eq("id", searchBrowser.getId()));
        }
        if (searchBrowser.getParentId() >= 0) {
            criteria.add(org.hibernate.criterion.Expression.eq("parentId", searchBrowser.getParentId()));
        }
        if (!"".equals(searchBrowser.getQuerySearch())) {
            criteria.add(org.hibernate.criterion.Expression.ilike("query", "%" + searchBrowser.getQuerySearch() + "%"));
        }
        if (!"".equals(searchBrowser.getTitle())) {
            criteria.add(org.hibernate.criterion.Expression.ilike("title", "%" + searchBrowser.getTitle() + "%"));
        }
        return criteria.list();
    }
}
