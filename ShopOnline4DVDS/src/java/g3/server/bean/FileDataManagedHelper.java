/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.server.bean;

import g3.hibernate.entity.FileData;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Transaction;

/**
 *
 * @author Administrator
 */
public class FileDataManagedHelper extends BaseHelper{
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

    public boolean save(FileData curFileData) {
        Transaction beginTransaction = session.beginTransaction();
        session.save(curFileData);
        beginTransaction.commit();
        if (curFileData.getId() != 0) {
            return true;
        }
        return false;
    }

    void del(FileData item) {
        Transaction beginTransaction = session.beginTransaction();
        session.delete(item);
        beginTransaction.commit();

    }

    void update(FileData item) {
        Transaction beginTransaction = session.beginTransaction();
        session.update(item);
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
        if (searchFileData.getId() > 0) {
            criteria.add(org.hibernate.criterion.Expression.eq("id", searchFileData.getId()));
        }
        if (!"".equals(searchFileData.getTitle())) {
            criteria.add(org.hibernate.criterion.Expression.ilike("title", "%" + searchFileData.getTitle() + "%"));
        }
        if (!"".equals(searchFileData.getUrl())) {
            criteria.add(org.hibernate.criterion.Expression.ilike("url", "%" + searchFileData.getUrl() + "%"));
        }
        if (!"".equals(searchFileData.getType())) {
            criteria.add(org.hibernate.criterion.Expression.ilike("type", "%" + searchFileData.getType() + "%"));
        }
        return criteria.list();
    }
}
