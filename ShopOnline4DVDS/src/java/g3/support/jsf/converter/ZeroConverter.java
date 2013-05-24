/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.support.jsf.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Administrator
 */
@FacesConverter("ZeroConverter")
public class ZeroConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value==""){
            return 0;
        }
        return Integer.valueOf(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return String.valueOf(value);
    }
    
}
