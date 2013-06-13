/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.bean.utility;

import g3.custom.phaselistener.AuthenticatePhaseListener;
import g3.hibernate.entity.Manage;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

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

    public static Manage getCurrentManageStatic() {
        HttpSession ss = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        return (Manage) ss.getAttribute(AuthenticatePhaseListener.ADMIN_SESSION_KEY);
    }

    private static String convertedToHex(byte[] data) {
        StringBuffer buf = new StringBuffer();

        for (int i = 0; i < data.length; i++) {
            int halfOfByte = (data[i] >>> 4) & 0x0F;
            int twoHalfBytes = 0;

            do {
                if ((0 <= halfOfByte) && (halfOfByte <= 9)) {
                    buf.append((char) ('0' + halfOfByte));
                } else {
                    buf.append((char) ('a' + (halfOfByte - 10)));
                }

                halfOfByte = data[i] & 0x0F;

            } while (twoHalfBytes++ < 1);
        }
        return buf.toString();
    }

    public static String MD5(String text)
            throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md;
        md = MessageDigest.getInstance("MD5");
        byte[] md5 = new byte[64];
        md.update(text.getBytes("iso-8859-1"), 0, text.length());
        md5 = md.digest();
        return convertedToHex(md5);
    }
}
