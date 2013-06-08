/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.server.bean.manage;

import g3.hibernate.entity.ObjectOfBrowsingRule;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author Administrator
 */
@ManagedBean
@SessionScoped
public class ObjectOfBrowsingRuleManagedBean {
    /**
     * Creates a new instance of CategoryManagedBean
     */
    private ObjectOfBrowsingRuleManagedHelper helper;
//    private ObjectOfBrowsingRule curCate;
    
    public ObjectOfBrowsingRuleManagedBean() {
    }
    
     @PostConstruct
    public void init() {
        helper = ObjectOfBrowsingRuleManagedHelper.getInstance();
    }

    @PreDestroy
    public void end() {
        helper.close();
    } 
    
    public List<SelectItem> getListObjectsOfBrowsingRule() {
        List<SelectItem> result = new ArrayList<SelectItem>();
        List<ObjectOfBrowsingRule> allObj = helper.getAllObjectsOfBrowsingRule();
        for(int i = 0; i < allObj.size(); i++)
        {
            result.add(new SelectItem(allObj.get(i).getId(), allObj.get(i).getName()));
        }
        return result;
    }
    
    public List<ObjectOfBrowsingRule> getAllbjectsOfBrowsingRule() {
        return helper.getAllObjectsOfBrowsingRule();
    }
}
