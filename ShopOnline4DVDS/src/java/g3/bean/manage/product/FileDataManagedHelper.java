/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.bean.manage.product;

import g3.hibernate.entity.FileData;
import g3.bean.utility.BaseHelper;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Transaction;

/**
 *
 * @author Administrator
 */
public class FileDataManagedHelper extends BaseHelper {

    private static FileDataManagedHelper instance;

    private FileDataManagedHelper() {
    }

    public static FileDataManagedHelper getInstance() {
        if (instance == null) {
            instance = new FileDataManagedHelper();
        }
        return instance;
    }

    public List<FileData> getAllFileDatas() {
        Transaction beginTransaction = session.beginTransaction();
        String hql = "FROM FileData g WHERE g.isDeleted=0";
        Query query = session.createQuery(hql);
        beginTransaction.commit();
        return query.list();
    }

    List<FileData> getAllFileDatasDeleted() {
        Transaction beginTransaction = session.beginTransaction();
        String hql = "FROM FileData g WHERE g.isDeleted=1";
        Query query = session.createQuery(hql);
        beginTransaction.commit();
        return query.list();
    }

    List<FileData> search(FileData searchFileData) {
        Criteria criteria = session.createCriteria(FileData.class);
        if (!"".equals(searchFileData.getTitle())) {
            criteria.add(org.hibernate.criterion.Expression.ilike("title", "%" + searchFileData.getTitle() + "%"));
        }
        if (!"".equals(searchFileData.getUrl())) {
            criteria.add(org.hibernate.criterion.Expression.ilike("url", "%" + searchFileData.getUrl() + "%"));
        }
        if (!"".equals(searchFileData.getType()) && searchFileData.getType() != null) {
            criteria.add(org.hibernate.criterion.Expression.ilike("type", "%" + searchFileData.getType() + "%"));
        }
        return criteria.list();
    }
}
