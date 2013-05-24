/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.server.bean;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 *
 * @author kiendv
 */
public class ValidateBean {

    public static boolean validEmail(String email) {
        try {
            InternetAddress idd = new InternetAddress(email, true);
            if(validEmpty(email)){
                return true;
            }else{
                return false;
            }
        } catch (AddressException ex) {
            return false;
        }
    }

    public static boolean validEmpty(String s) {
        if(s=="" || s==null || s.length()<3){
            return false;
        }
        else{
            return true;
        }
    }
    public static boolean compare(String s1, String s2){
        if(validEmpty(s1)&&validEmpty(s2)&&s1.equals(s2)){
            return true;
        }else{
            return false;
        }
    }
}
