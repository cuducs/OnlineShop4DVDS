/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.bean.security;

import g3.bean.utility.BaseHelper;
import g3.bean.utility.JsfUtilBean;
import g3.hibernate.entity.Manage;
import g3.hibernate.entity.ManagePermissionMapping;
import g3.hibernate.entity.ManagePermissionMappingId;
import g3.hibernate.entity.Permission;
import java.util.Arrays;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Administrator
 */
public class ManageManagedHelper extends BaseHelper {

    private static ManageManagedHelper instance;

    private ManageManagedHelper() {
    }

    public static ManageManagedHelper getInstance() {
        if (instance == null) {
            instance = new ManageManagedHelper();
        }
        return instance;
    }

    public List<Manage> getAllManages() {
        Transaction beginTransaction = session.beginTransaction();
        Manage manage = JsfUtilBean.getCurrentManageStatic();
        String hql = "FROM Manage g WHERE g.isLock=0 and g.position > " + manage.getPosition();
        Query query = session.createQuery(hql);
        beginTransaction.commit();
        return query.list();
    }

    List<Manage> getAllManagesDeleted() {
        Transaction beginTransaction = session.beginTransaction();
        Manage manage = JsfUtilBean.getCurrentManageStatic();
        String hql = "FROM Manage g WHERE g.isLock=1 and g.position > " + manage.getPosition();
        Query query = session.createQuery(hql);
        beginTransaction.commit();
        return query.list();
    }

    List<Manage> search(Manage searchManage) {
        Criteria criteria = session.createCriteria(Manage.class);
        if (searchManage.getName() != "") {
            criteria.add(org.hibernate.criterion.Expression.ilike("name", "%" + searchManage.getName() + "%"));
        }
        if (searchManage.getInfo() != "") {
            criteria.add(org.hibernate.criterion.Expression.ilike("info", "%" + searchManage.getInfo() + "%"));
        }
        Manage manage = JsfUtilBean.getCurrentManageStatic();
        criteria.add(Expression.gt("position", manage.getPosition()));
        criteria.add(Expression.eq("isLock", searchManage.isIsLock()));
        return criteria.list();
    }

    void mappingPer(Manage curManage, Permission item) {
        ManagePermissionMappingId id = new ManagePermissionMappingId(curManage.getId(), item.getId());
        ManagePermissionMapping mapping = new ManagePermissionMapping(id);
        session.save(mapping);
    }

    List<Permission> getListPerAdded(Manage curManage) {
        Transaction beginTransaction = session.beginTransaction();
        //list id added
        List lstCannotAddId = session.createQuery("Select a.id.permissionId From ManagePermissionMapping a Where a.id.manageId=" + curManage.getId()).list();
        Criteria lstCanAdd = session.createCriteria(Permission.class);
        if (lstCannotAddId.size() == 0) {
            return lstCannotAddId;
        }
        lstCanAdd.add(Expression.eq("isDeleted", false));
        lstCanAdd.add(Restrictions.in("id", lstCannotAddId));
        beginTransaction.commit();
        return lstCanAdd.list();
    }

    List<Permission> getListPerCanAdd(Manage curManage) {
        Transaction beginTransaction = session.beginTransaction();
        List lstCannotAddId = session.createQuery("Select a.id.permissionId From ManagePermissionMapping a Where a.id.manageId=" + curManage.getId()).list();
        Criteria lstCanAdd = session.createCriteria(Permission.class);
        if (lstCannotAddId.size() > 0) {
            lstCanAdd.add(Restrictions.not(Restrictions.in("id", lstCannotAddId)));
        }
        Manage manage = JsfUtilBean.getCurrentManageStatic();
        lstCanAdd.add(Expression.gt("position", manage.getPosition()));
        lstCanAdd.add(Expression.eq("isDeleted", false));
        beginTransaction.commit();

        return lstCanAdd.list();
    }

    void addPer(Manage curManage, Permission item) {
        ManagePermissionMapping mapping = new ManagePermissionMapping();
        ManagePermissionMappingId mappingId = new ManagePermissionMappingId(curManage.getId(), item.getId());
        mapping.setId(mappingId);
        session.save(mapping);
        checkAndUpdateDegree(curManage);
        
    }

    void removePer(Manage curManage, Permission item) {
        ManagePermissionMappingId mappingId = new ManagePermissionMappingId(curManage.getId(), item.getId());
        ManagePermissionMapping mapping = (ManagePermissionMapping) session.get(ManagePermissionMapping.class, mappingId);
        session.delete(mapping);
        checkAndUpdateDegree(curManage);
        
    }

    public void checkAndUpdateDegree(Manage manage) {
        List<Permission> lst = getListPerAdded(manage);
        int lv = 3;
        for (Permission permission : lst) {
            if (permission.getPosition() < lv) {
                lv = permission.getPosition();
            }
        }
        manage.setPosition(lv);
    }
}
