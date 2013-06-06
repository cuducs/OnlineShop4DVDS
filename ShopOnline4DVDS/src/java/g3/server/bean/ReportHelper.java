/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.server.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author lab
 */
public class ReportHelper {

    private static Session getSession() {
        return DvdStoreHibernateUtil.getSessionFactory().openSession();
    }

    public static int getTotalOrder() {
        try {
            return (Integer) getSession().createSQLQuery("select count(id) from Bill").uniqueResult();
        } catch (Exception ex) {
            return 0;
        }
    }

    public static int getDoneOrder() {
        try {
            return (Integer) getSession().createSQLQuery("select count(id) from Bill where [Status] = 2").uniqueResult();
        } catch (Exception ex) {
            return 0;
        }
    }

    public static int getWaitingOrder() {
        try {
            return (Integer) getSession().createSQLQuery("select count(id) from Bill where [Status] = 1").uniqueResult();
        } catch (Exception ex) {
            return 0;
        }
    }

    public static int getCanceledOrder() {
        try {
            return (Integer) getSession().createSQLQuery("select count(id) from Bill where [Status] = 0").uniqueResult();
        } catch (Exception ex) {
            return 0;
        }
    }

    public static String drawPie() {
        return "<script>\n"
                + "            var pieData = [\n"
                + "                {\n"
                + "                    value: " + getDoneOrder() + ",\n"
                + "                    color:\"#F38630\"\n"
                + "                },\n"
                + "                {\n"
                + "                    value : " + getWaitingOrder() + ",\n"
                + "                    color : \"#E0E4CC\"\n"
                + "                },\n"
                + "                {\n"
                + "                    value : " + getCanceledOrder() + ",\n"
                + "                    color : \"#69D2E7\"\n"
                + "                }\n"
                + "			\n"
                + "            ];\n"
                + "            var myPie = new Chart(document.getElementById(\"canvas\").getContext(\"2d\")).Pie(pieData);\n"
                + "        </script>";
    }

    public static String drawBarMonth(int year) {
        List<BigDecimal> list = new ArrayList<BigDecimal>();
        String s = "";
        for (int i = 1; i < 13; i++) {
            BigDecimal x = incomeMonth(i, year);
            list.add(x);
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println("KQ: " + list.get(i));
            if (i != list.size() - 1) {
                s += list.get(i) + ",";
            } else {
                s += list.get(i);
            }
        }
        return "<script>\n"
                + "var barChartData = {\n"
                + "labels : [\"January\",\"February\",\"March\",\"April\",\"May\",\"June\",\"July\", \"August\", \"September\", \"October\", \"Nvember\", \"December\"], \n"
                + "datasets : ["
                + "{"
                + "fillColor : \"rgba(220,220,220,0.5)\",\n"
                + "strokeColor : \"rgba(220,220,220,1)\",\n"
                + "data : [" + s + "]\n"
                + "}"
                + "]\n"
                + "}\n"
                + "var myLine = new Chart(document.getElementById(\"canvas2\").getContext(\"2d\")).Bar(barChartData);\n"
                + "</script>";
    }

    public static BigDecimal incomeMonth(int month, int year) {
        String sql = "select SUM(b.Total) from Bill b where b.Status = 2 and DATEPART(mm, b.OrderDate)=" + month + " and DATEPART(YYYY, '10/10/2010')=" + year;
        try {
            BigDecimal val = (BigDecimal) getSession().createSQLQuery(sql).uniqueResult();
            if (val == null) {
                return new BigDecimal(0);
            }
            return val;
        } catch (Exception ex) {
            return new BigDecimal(0);
        }
    }
}
