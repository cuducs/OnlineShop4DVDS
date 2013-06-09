/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.bean.client;

import g3.hibernate.entity.Bill;
import g3.hibernate.entity.Dvd;
import org.hibernate.Transaction;

/**
 *
 * @author TrungDuc
 */
public class BillHelper extends BaseHelper{
    private static BillHelper instance;

    private BillHelper() {
    }

    public static BillHelper getInstance() {
        if (instance == null) {
            instance = new BillHelper();
        }
        return instance;
    }
    public boolean save(Bill bill) {
        Transaction beginTransaction = session.beginTransaction();
        session.save(bill);
        beginTransaction.commit();
        if (bill.getId() != 0) {
            return true;
        }
        return false;
    }
}
