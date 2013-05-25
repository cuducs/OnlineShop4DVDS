/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.support.jsf.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Administrator
 */
@FacesConverter("TimeConverter")
public class TimeConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != "") {
            try {
                SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
                Date d = format.parse(value);

                return d;
            } catch (ParseException ex) {
                return null;
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Date d = (Date) value;
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        int hour = c.get(Calendar.HOUR);
        int minute = c.get(Calendar.MINUTE);
        int second = c.get(Calendar.SECOND);
        StringBuilder target = new StringBuilder("");
        if (hour > 9) {
            target.append(hour);
        } else {
            target.append("0" + hour);
        }
        if (minute > 9) {
            target.append(":"+minute);
        } else {
            target.append(":0" + minute);
        }
        if (second > 9) {
            target.append(":"+second);
        } else {
            target.append(":0" + second);
        }
        String output = target.toString();
        return output;
    }
}
