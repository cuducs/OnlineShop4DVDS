/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.bean.client;

import g3.hibernate.entity.Bill;
import g3.hibernate.entity.BillDetail;
import org.hibernate.Transaction;

/**
 *
 * @author TrungDuc
 */
public class BillDetailHelper extends BaseHelper{
    private static BillDetailHelper instance;

    private BillDetailHelper() {
    }

    public static BillDetailHelper getInstance() {
        if (instance == null) {
            instance = new BillDetailHelper();
        }
        return instance;
    }
    public void save(BillDetail billDetail) {
        Transaction beginTransaction = session.beginTransaction();
        session.save(billDetail);
        beginTransaction.commit();
    }
}
