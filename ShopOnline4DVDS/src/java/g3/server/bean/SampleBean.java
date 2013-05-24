/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.server.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Administrator
 */
@ManagedBean
@RequestScoped
public class SampleBean {

    private SampleHelper helper;
    private String mes;
    
    /**
     * Creates a new instance of SampleBean
     */
    public SampleBean() {
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    @PostConstruct
    public void init() {
        helper = SampleHelper.getInstance();
        mes = "";
    }
    public String testvarchar(){
        return "no co gi";
    }
    public String generate() {
        helper.generate();
        mes = "Generate Succesfull";
        return null;
    }
}
