/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.server.bean;

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
    
}
