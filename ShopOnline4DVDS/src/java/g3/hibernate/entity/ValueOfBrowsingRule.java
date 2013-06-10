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
public class ValueOfBrowsingRule  implements java.io.Serializable{
    private int id;
    private String value;

    public ValueOfBrowsingRule() {
    }

    public ValueOfBrowsingRule(int id, String value) {
        this.id = id;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
    
}
