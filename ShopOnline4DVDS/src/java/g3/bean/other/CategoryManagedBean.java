/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.bean.other;


import g3.bean.utility.AppConstant;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import g3.hibernate.entity.Category;
import g3.hibernate.entity.Dvd;
import g3.hibernate.entity.Node;
import g3.hibernate.entity.ObjectOfBrowsingRule;
import g3.hibernate.entity.ValueOfBrowsingRule;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Stack;
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
    private Category curCate = new Category();
    private int formMode;    
    private int objectOfBrowsingRule;
    private String operaterOfBrowsingRule = "";
    private String valueOfBrowsingRule = "";
    private String valueOfBrowsingRule2 = "";
    private String hinting1 = "";
    private String hinting2 = "";
    private boolean showHinting = false;
    private List<Dvd> productsInCateDetail;
    
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

    public String getHinting1() {
        return hinting1;
    }

    public void setHinting1(String hinting1) {
        this.hinting1 = hinting1;
    }

    public String getHinting2() {
        return hinting2;
    }

    public void setHinting2(String hinting2) {
        this.hinting2 = hinting2;
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

    public List<Dvd> getProductsInCateDetail() {
        return productsInCateDetail;
    }

    public void setProductsInCateDetail(List<Dvd> productsInCateDetail) {
        this.productsInCateDetail = productsInCateDetail;
    }
    
  
    
    public String save() {
        System.out.print("Da vao ham save");
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
       executeDeleteCate(item);
        return "show";
    }
    
    private void executeDeleteCate(Category cate)
    {
        try
        {
        cate.setIsDeleted(true);
        cate.setModifiedDate(new Date());
        helper.update(cate);
        List<Category> lst = helper.getChildCategories(cate);
        if(lst != null)
        {
            for(int i = 0; i < lst.size(); i++)
            {
                executeDeleteCate(lst.get(i));
            }
        }
        }catch(Exception ex)
        {
            System.out.printf("Loi " + ex.toString());
        }
    }

    public String update() {
        curCate.setModifiedDate(new Date());
        helper.update(curCate);
        return "show";
    }
    
    public String create() {
      curCate = new Category();
      return "create";
    }

    public String details(Category cate)
    {
        try
        {
            productsInCateDetail = helper.getProductsInCateDetail(cate);
            curCate = cate;
        }
        catch(Exception ex)
        {
            productsInCateDetail = new ArrayList<Dvd>();
        }
        return "details";
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
    
    public List<SelectItem> getListValueOfBrowsingRule()
    {
        ObjectOfBrowsingRule obj = obj_helper.getObjectOfBrowsingRule(objectOfBrowsingRule);
//        System.out.print("object la " + objectOfBrowsingRule);
       
        if(obj != null)
        {
            try{
                List<SelectItem> result = new ArrayList<SelectItem>();
                List<ValueOfBrowsingRule> lst = obj_helper.getListValueOfBrowsingRule(obj);
                if(lst != null)
                {
                    for(int i = 0; i < lst.size(); i++)
                    {
                        result.add(new SelectItem(lst.get(i).getId(), lst.get(i).getValue()));
                    }
                }
                 return result;
            }catch(Exception ex)
            {
                System.out.print("Loi : " + ex.toString());
               return null;
            }
        }
    //System.out.print("cau truy van " + obj.getQueryToGetValue());
        return null;
    }
    
    public void hintingListener()
    {
        valueOfBrowsingRule = hinting1;
        valueOfBrowsingRule2 = hinting2;
    }
    
    public boolean isShowHinting()
    {
       return showHinting;
    }
    
    public boolean isShowHinting2()
    {
       return showHinting && operaterOfBrowsingRule.equals(AppConstant.OPERATOR_BETWEEN);
    }
    
    public void changeHintListener()
    {
        try
        {
            ObjectOfBrowsingRule obj = obj_helper.getObjectOfBrowsingRule(objectOfBrowsingRule);
            showHinting = (!obj.isIsBase()) && (("".endsWith(operaterOfBrowsingRule)  ? AppConstant.OPERATOR_TOP != null : !operaterOfBrowsingRule.equals(AppConstant.OPERATOR_TOP)));
        }
        catch(Exception ex){
            showHinting = false;
        }
    }
    
//    public void changeCurrentCate(int id)
//    {
//        try
//        {
//            Category new_cate = helper.searchById(id);
//            if(new_cate != null) {
//                curCate = new_cate;
//            }
//        }
//        catch(Exception ex)
//        {
//            System.out.printf(ex.toString());
//        }
//    }
    
    public List<Node> getListMenu()
    {
        List<Category> all = helper.getAllCategories();
         
        List<Node> lstMenu = new ArrayList<Node>();
        Stack<Node> lstParent = new Stack<Node>();
        Node prvNode = new Node(all.get(0));
        for (int i = 1; i < all.size(); i++) {
            Node currNode = new Node(all.get(i));
            
            if(currNode.getCateLevel() == 1)
            {
                lstMenu.add(currNode);
            }
            if(currNode.getCateLevel() > prvNode.getCateLevel())
            { 
                lstParent.push(prvNode);
                lstParent.peek().getChildren().add(currNode);   
                currNode.setOrder(lstParent.peek().getChildren().size());
            }
            else 
            {
               // System.out.print("name : " + currNode.getName());
                while(currNode.getCateLevel() < lstParent.peek().getCateLevel() + 1)
                {
                    lstParent.pop();
                }
                currNode.setOrder(lstParent.peek().getChildren().size());
                lstParent.peek().getChildren().add(currNode);
            }
            prvNode = currNode;
        }
        
        
        return lstMenu;
    }
}
