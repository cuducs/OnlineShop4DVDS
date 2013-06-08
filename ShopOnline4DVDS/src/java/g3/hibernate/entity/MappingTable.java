/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.hibernate.entity;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author DUCVM
 */
public class MappingTable {
    int id;
    String tableA;
    String tableB;
    String queryToJoin;

    public MappingTable() {
    }

    public MappingTable(int id, String tableA, String tableB, String queryToJoin) {
        this.id = id;
        this.tableA = tableA;
        this.tableB = tableB;
        this.queryToJoin = queryToJoin;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getTableA() {
        return tableA;
    }

    public void setTableA(String tableA) {
        this.tableA = tableA;
    }

    public String getTableB() {
        return tableB;
    }

    public void setTableB(String tableB) {
        this.tableB = tableB;
    }

    public String getQueryToJoin() {
        return queryToJoin;
    }

    public void setQueryToJoin(String queryToJoin) {
        this.queryToJoin = queryToJoin;
    }
   
    
}
