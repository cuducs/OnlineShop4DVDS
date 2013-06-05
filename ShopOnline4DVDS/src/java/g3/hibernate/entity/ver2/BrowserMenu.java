/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.hibernate.entity.ver2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Administrator
 */
public class BrowserMenu {

    private List<Browser> menuLv1 = new ArrayList<Browser>();
    private Map<Integer, List<Browser>> menuLv2 = new HashMap<Integer, List<Browser>>();

    public List<Browser> getMenuLv1() {
        return menuLv1;
    }

    public void setMenuLv1(List<Browser> menuLv1) {
        this.menuLv1 = menuLv1;
    }

    public Map<Integer, List<Browser>> getMenuLv2() {
        return menuLv2;
    }

    public void setMenuLv2(Map<Integer, List<Browser>> menuLv2) {
        this.menuLv2 = menuLv2;
    }
}
