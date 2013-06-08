/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.server.bean;

/**
 *
 * @author Administrator
 */
public class UserHelper extends BaseHelper {

    private static UserHelper instance;

    private UserHelper() {
    }

    public static UserHelper getInstance() {
        if (instance == null) {
            instance = new UserHelper();
        }
        return instance;
    }
}
