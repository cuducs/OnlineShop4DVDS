/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.server.bean.manage;
import g3.hibernate.entity.Category;
import g3.hibernate.entity.ObjectOfBrowsingRule;
import g3.server.bean.utility.AppConstant;
import java.util.ArrayList;
import java.util.Date;
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
public class CategoryManagedBean{
    /**
     * Creates a new instance of CategoryManagedBean
     */
    private CategoryManagedHelper helper;
    private ObjectOfBrowsingRuleManagedHelper obj_helper;
    private MappingTableManagedHelper mapping_helper;
    private Category curCate;
    private int formMode;    
    private int objectOfBrowsingRule;
    private String operaterOfBrowsingRule;
    private String valueOfBrowsingRule;
    private String valueOfBrowsingRule2;
    
    public CategoryManagedBean() {
    }

    public String getValueOfBrowsingRule2() {
        return valueOfBrowsingRule2;
    }

    public void setValueOfBrowsingRule2(String valueOfBrowsingRule2) {
        this.valueOfBrowsingRule2 = valueOfBrowsingRule2;
    }
    
    @PostConstruct
    public void init() {
        helper = CategoryManagedHelper.getInstance();
        obj_helper  = ObjectOfBrowsingRuleManagedHelper.getInstance();
        mapping_helper = MappingTableManagedHelper.getInstance();
    }

    @PreDestroy
    public void end() {
        helper.close();
        obj_helper.close();
        mapping_helper.close();
    } 

    public int getMode() {
        return formMode;
    }

    public void setMode(int mode) {
        this.formMode = mode;
    }

    public Category getCurCate() {
        return curCate;
    }

    public void setCurCate(Category curCate) {
        this.curCate = curCate;
    }

    public String create() {
        curCate = new Category();
        return "create";
    }

    public String save() {
        ObjectOfBrowsingRule obj = obj_helper.getObjectOfBrowsingRule(objectOfBrowsingRule);
        curCate.setCreatedDate(new Date());
        curCate.setModifiedDate(new Date());
        curCate.setIsDeleted(false);
        Category parentCate = helper.searchById(curCate.getCategoryParentId());
        String query = "";
        String joinTableQuery = "";
        String calculateQuery = "";
        String parentQuery = parentCate.getQuery();
        String strAAlias = "";
        String strBAlias = "";
        String strCAlias = "";
        String strColToMap = obj.getCollToMapping();
        
        //set cate level & cate woodenleg
        String strId = Integer.toString(helper.getMaxId() + 1);
        int numZero = 4 - strId.length();
        for(;numZero > 0;numZero--)
        {
            strId = "0" + strId;
        }
        curCate.setCateLevel(parentCate.getCateLevel() + 1);
        curCate.setWoodenLeg(Integer.toString(parentCate.getId()) + strId);
        
        
        //set cate query
        strAAlias = "a" + Integer.toString(curCate.getCateLevel());
        strBAlias = "b" + Integer.toString(curCate.getCateLevel());
        strCAlias = "c" + Integer.toString(curCate.getCateLevel());
        
        joinTableQuery = mapping_helper.getJoinQuery("DVD", obj.getTableToMapping());
        if("Id".endsWith(strColToMap))
        {
            joinTableQuery = "Select DVD.Id, " + obj.getTableToMapping() + "." + strColToMap + " As " + obj.getTableToMapping() + "_Id " + joinTableQuery; 
            strColToMap = obj.getTableToMapping() + "_Id";
        }
        else
        {
           joinTableQuery = "Select DVD.Id, " + obj.getTableToMapping() + "." + strColToMap + " " + joinTableQuery; 
        }
        calculateQuery = getCalculateQuery(joinTableQuery, strCAlias, strColToMap);
        
        query = "SELECT DVD.* FROM DVD inner join (";
        query += calculateQuery;
        query += ") as " + strAAlias + " on DVD.id = " + strAAlias + ".id inner join (";
        query += parentQuery;
        query += ") as " + strBAlias + " on DVD.id = " + strBAlias + ".id";
        
        curCate.setQuery(query);
        
        helper.save(curCate);
        curCate = null;
        return "show";
    }

    private String getCalculateQuery(String joinTableQuery, String strCAlias, String strColToMap)
    {
        String calculateQuery = "";
        String sqlPath1 = "";
        String sqlPath2 = "";
        String selectColls = "";
        
        selectColls = strCAlias + "." + strColToMap + " As " + strColToMap + " , " + strCAlias + ".Id As Id " ;
        
        if(AppConstant.OPERATOR_TOP.endsWith(operaterOfBrowsingRule))
        {
            sqlPath1 = "SELECT DISTINCT TOP " + valueOfBrowsingRule + " " + selectColls + " FROM (";
            sqlPath2 = ") As " + strCAlias + " Group by (" + strCAlias + ".Id) Order by MAX(" + strCAlias + "." + strColToMap + ")";
        }
        else
        {
            sqlPath1 = "SELECT DISTINCT " + selectColls + " FROM (";;
            sqlPath2 = ") As " + strCAlias + " WHERE ";
            
            sqlPath2 += strCAlias + "." + strColToMap  + " " + operaterOfBrowsingRule;
            
            if(AppConstant.OPERATOR_BETWEEN.endsWith(operaterOfBrowsingRule))
            {
                if(valueOfBrowsingRule.compareTo(valueOfBrowsingRule2) > 0)
                {
                    sqlPath2 +=  " " + valueOfBrowsingRule2 + " And " + valueOfBrowsingRule;
                }
                else
                {
                    sqlPath2 +=  " " + valueOfBrowsingRule + " And " + valueOfBrowsingRule2;
                }
            }else  if(AppConstant.OPERATOR_CONTAIN.endsWith(operaterOfBrowsingRule))
            {
               sqlPath2  += " '%" + valueOfBrowsingRule + "%'";
            }
            else 
            {
                sqlPath2 += " '" + valueOfBrowsingRule + "'";
            }
        }
        
        calculateQuery = sqlPath1 + joinTableQuery + sqlPath2;
        return calculateQuery;
    }
    
    public String del(Category item) {
        item.setIsDeleted(true);
        item.setModifiedDate(new Date());
        helper.update(item);
        return "show";
    }

    public String update() {
        curCate.setModifiedDate(new Date());
        helper.update(curCate);
        return "show";
    }

    public List<Category> getAllCategories() {
        return helper.getAllCategories();
    }

    public List<Category> getAllCategoriesDeleted() {
        return helper.getAllCategoriesDeleted();
    }

    public String recovery(Category item) {
        item.setIsDeleted(false);
        item.setModifiedDate(new Date());
        helper.update(item);
        return "recovery";
    }

    public String cancel() {
        curCate = new Category();
        return "show";
    }
    
    public List<SelectItem> getListCategories() {
        List<SelectItem> result = new ArrayList<SelectItem>();
        List<Category> allCate = getAllCategories();
        for(int i = 0; i < allCate.size(); i++)
        {
            result.add(new SelectItem(allCate.get(i).getId(), allCate.get(i).getName()));
        }
        return result;
    }
    
    public int getObjectOfBrowsingRule() {
        return objectOfBrowsingRule;
    }

    public void setObjectOfBrowsingRule(int objectOfBrowsingRule) {
        this.objectOfBrowsingRule = objectOfBrowsingRule;
    }
    public String getOperaterOfBrowsingRule() {
        return operaterOfBrowsingRule;
    }

    public void setOperaterOfBrowsingRule(String operaterOfBrowsingRule) {
        this.operaterOfBrowsingRule = operaterOfBrowsingRule;
    }
    public String getValueOfBrowsingRule() {
        return valueOfBrowsingRule;
    }

    public void setValueOfBrowsingRule(String valueOfBrowsingRule) {
        this.valueOfBrowsingRule = valueOfBrowsingRule;
    }
    

}
