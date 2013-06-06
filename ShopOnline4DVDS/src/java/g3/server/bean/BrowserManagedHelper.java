/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.server.bean;

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

    public boolean save(Browser curBrowser) {
        Transaction beginTransaction = session.beginTransaction();
        session.save(curBrowser);
        beginTransaction.commit();
        if (curBrowser.getId() != 0) {
            return true;
        }
        return false;
    }

    void del(Browser item) {
        Transaction beginTransaction = session.beginTransaction();
        session.delete(item);
        beginTransaction.commit();

    }

    void update(Browser item) {
        Transaction beginTransaction = session.beginTransaction();
        session.update(item);
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
