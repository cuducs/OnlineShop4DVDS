/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.bean.client;

import g3.bean.utility.BaseHelper;
import g3.hibernate.entity.Comment;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Transaction;

/**
 *
 * @author DUCVM
 */
public class CommentHelper extends BaseHelper{
     private static CommentHelper instance;

    private CommentHelper() {
    }

    public static CommentHelper getInstance() {
        if (instance == null) {
            instance = new CommentHelper();
        }
        return instance;
    }
    
    public List<Comment> getCommentsByProduct(String productId)
    {
        Transaction beginTransaction = session.beginTransaction();
        String hql = "FROM Comment g WHERE g.isDeleted=0 AND g.dvdId=" + productId;
        Query query = session.createQuery(hql);
        beginTransaction.commit();
        return query.list();
    }
}
