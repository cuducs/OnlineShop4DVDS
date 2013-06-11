/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.bean.utility;

import java.util.Arrays;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import org.hibernate.mapping.Collection;

/**
 *
 * @author Administrator
 */
@ManagedBean
@ApplicationScoped
public class JsfUtilBean {

    public static final String SEMICOLON = ";";
    public static final String COLON = ":";
    public static final String COMMA = ",";

    /**
     * Creates a new instance of JsfUtilBean
     */
    public JsfUtilBean() {
    }

    public static String shortString() {
        return null;
    }

    public static List<String> splitString(String source, String pattern) {

        return Arrays.asList(source.split(pattern));
    }

    public List<String> splitToRow(String source) {
        return JsfUtilBean.splitString(source, SEMICOLON);
    }

    public String splitToNameValue(String source) {
        return JsfUtilBean.splitString(source, COLON).get(0);
    }

    public String splitToValue(String source) {
        return JsfUtilBean.splitString(source, COLON).get(1);
    }

    public List<String> splitToListValue(String source) {
        return JsfUtilBean.splitString(source, COMMA);
    }

    public String shortString(String source) {
        if (source.length() > 30) {
            String shortSource = source.substring(0, 29);
            shortSource += "...";
            return shortSource;
        } else {
            return source;
        }
    }
}
