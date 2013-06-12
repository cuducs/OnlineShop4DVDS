/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.hibernate.entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DUCVM
 */
public class Node {
     private int id;
     private String name;
      private int cateLevel;
     private List<Node> children;
     private int order;
     
     public Node(Category cate) {
       this.id = cate.getId();
       this.name = cate.getName();
       this.cateLevel = cate.getCateLevel();
       this.children = new ArrayList<Node>();
       order = 1;
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

    public int getCateLevel() {
        return cateLevel;
    }

    public void setCateLevel(int cateLevel) {
        this.cateLevel = cateLevel;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
     
      public boolean hasChild()
    {
        return children.size() > 0;
    }
}
