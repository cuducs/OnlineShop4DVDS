/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.hibernate.entity.ver2;


public class ObjectOfBrowsingRule {

    private int id;
    private String name;
    private boolean isBase;

   
    private String queryToGetValue;
    private String collToMapping;
    private String tableToMapping;

    public String getCollToMapping() {
        return collToMapping;
    }

    public void setCollToMapping(String collToMapping) {
        this.collToMapping = collToMapping;
    }

    public String getTableToMapping() {
        return tableToMapping;
    }

    public void setTableToMapping(String tableToMapping) {
        this.tableToMapping = tableToMapping;
    }

    public ObjectOfBrowsingRule() {
    }

    public ObjectOfBrowsingRule(int id, String name, boolean isBase, String queryToGetValue) {
        this.id = id;
        this.name = name;
        this.isBase = isBase;
        this.queryToGetValue = queryToGetValue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

     public boolean isIsBase() {
        return isBase;
    }
     
    public void setIsBase(boolean isBase) {
        this.isBase = isBase;
    }

    public String getQueryToGetValue() {
        return queryToGetValue;
    }

    public void setQueryToGetValue(String queryToGetValue) {
        this.queryToGetValue = queryToGetValue;
    }
   
}
