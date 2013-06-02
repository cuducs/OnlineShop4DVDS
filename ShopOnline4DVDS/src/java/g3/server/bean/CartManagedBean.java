/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.server.bean;

import g3.hibernate.entity.CartItem;
import g3.hibernate.entity.Dvd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author TrungDuc
 */
@ManagedBean
@SessionScoped
public class CartManagedBean {
    private ProductManagedHelper helper;
    private HashMap<Integer,CartItem> cart = new HashMap<Integer,CartItem>();
    private int count = 1;
    
    /**
     * Creates a new instance of CartManagedBean
     */
    public CartManagedBean() {
    }
    @PostConstruct
    public void init() {
        helper = ProductManagedHelper.getInstance();
    }

    @PreDestroy
    public void end() {
        helper.close();
    }
    public HashMap<Integer,CartItem> getCart() {
        return cart;
    }

    public void setCart(HashMap<Integer,CartItem> cart) {
        this.cart = cart;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    /*function*/
    public void add(int id){
        CartItem ci = cart.get(id);
        if(ci==null){
            CartItem newCI = new CartItem();
            newCI.setProduct(helper.getById(id));
            newCI.setCount(count);
            cart.put(id, newCI);
        }else{
            ci.setCount(ci.getCount()+count);
            cart.remove(id);
            cart.put(id, ci);
        }
    }
    public double getTotal(){
        double result = 0;
        Set<Integer> set = cart.keySet();
        Iterator<Integer> it =  set.iterator();
        while(it.hasNext()){
            int id = it.next();
            CartItem ci = cart.get(id);
            result = result + ci.getCount()*ci.getProduct().getPrice();
        }
        return result;
    }
    public int getTotalItems(){
        int result = 0;
        Set<Integer> set = cart.keySet();
        Iterator<Integer> it =  set.iterator();
        while(it.hasNext()){
            int id = it.next();
            CartItem ci = cart.get(id);
            result = result + ci.getCount();
        }
        return result;
    }
    public List<CartItem> getListCart(){
        List<CartItem> listCart = new ArrayList<CartItem>();
        Set<Integer> set = cart.keySet();
        Iterator<Integer> it =  set.iterator();
        while(it.hasNext()){
            int id = it.next();
            listCart.add(cart.get(id));
        }
        return listCart;
    }
    public void removeOne(int id){
        CartItem ci = cart.get(id);
        if(ci!=null && ci.getCount() > 0 ){
            ci.setCount(ci.getCount()-1);
            cart.remove(id);
            cart.put(id, ci);
        }
    }
    public void addOne(int id){
        CartItem ci = cart.get(id);
        if(ci!=null){
            ci.setCount(ci.getCount()+1);
            cart.remove(id);
            cart.put(id, ci);
        }
    }
    public void removeAll(int id){
        CartItem ci = cart.get(id);
        if(ci!=null){
            cart.remove(id);
        }
    }
}
