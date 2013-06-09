/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.bean.other;

import g3.bean.utility.DvdStoreHibernateUtil;
import g3.hibernate.entity.Dvd;
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

    public static int getTotalOrder(String year) {
        try {
            return (Integer) getSession().createSQLQuery("select count(id) from Bill where DATEPART(YYYY, OrderDate)="+year).uniqueResult();
        } catch (Exception ex) {
            return 0;
        }
    }

    public static int getDoneOrder(String year) {
        try {
            return (Integer) getSession().createSQLQuery("select count(id) from Bill where [Status] = 2 and DATEPART(YYYY, OrderDate)="+year).uniqueResult();
        } catch (Exception ex) {
            return 0;
        }
    }

    public static int getWaitingOrder(String year) {
        try {
            return (Integer) getSession().createSQLQuery("select count(id) from Bill where [Status] = 1 and DATEPART(YYYY, OrderDate)="+year).uniqueResult();
        } catch (Exception ex) {
            return 0;
        }
    }

    public static int getCanceledOrder(String year) {
        try {
            return (Integer) getSession().createSQLQuery("select count(id) from Bill where [Status] = 0").uniqueResult();
        } catch (Exception ex) {
            return 0;
        }
    }

    public static String drawPie(String year) {
        return "<script type=\"text/javascript\">$(function () { $('#container').highcharts({ chart: { plotBackgroundColor: null, plotBorderWidth: null, plotShadow: false }, title: { text: 'Order status, "+year+"' }, tooltip: { pointFormat: '{series.name}: {point.percentage}%', percentageDecimals: 1 }, plotOptions: { pie: { allowPointSelect: true, cursor: 'pointer', dataLabels: { enabled: true, color: '#000000', connectorColor: '#000000', formatter: function() { return ''+ this.point.name +': '+ this.percentage +' %'; } } } }, series: [{ type: 'pie', name: 'Order status', data: [ ['Done', "+getDoneOrder(year)+"], ['Waiting', "+getWaitingOrder(year)+"], { name: 'Canceled', y: "+getCanceledOrder(year)+", sliced: true, selected: true } ] }] }); });</script>";
    }
    public static String drawBarMonth(String year) {
        List<BigDecimal> list = new ArrayList<BigDecimal>();
        String s = "";
        for (int i = 1; i < 13; i++) {
            BigDecimal x = incomeMonth(i, year, "music");
            list.add(x);
        }
        for (int i = 0; i < list.size(); i++) {
            if (i != list.size() - 1) {
                s += list.get(i) + ",";
            } else {
                s += list.get(i);
            }
        }
        return "<script>\n"
                + "var barChartData = {\n"
                + "labels : [\"January(" + list.get(0) + ")\",\"February\",\"March\",\"April\",\"May\",\"June\",\"July\", \"August\", \"September\", \"October\", \"November\", \"December\"], \n"
                + "datasets : ["
                + "{"
                + "fillColor : \"rgba(151,187,205,0.5)\",\n"
                + "strokeColor : \"rgba(151,187,205,1)\",\n"
                + "data : [" + s + "]\n"
                + "}"
                + "]\n"
                + "}\n"
                + "var myLine = new Chart(document.getElementById(\"canvas2\").getContext(\"2d\")).Bar(barChartData);\n"
                + "</script>";
    }

    public static BigDecimal incomeMonth(int month, String year, String type) {
        String sql = "select SUM(b.Total) from Bill b join BillDetail d on b.Id = d.BillId join DVD v on d.ProductId = v.Id where v.Type = '"+type+"' and b.Status = 2 and DATEPART(mm, b.OrderDate)="+month+" and DATEPART(YYYY, '10/10/2010')="+year;
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

    public static String incomeMonthbyYearMusic(String year) {
        List<BigDecimal> listmusic = new ArrayList<BigDecimal>();
        String smusic = "";
        for (int i = 1; i < 13; i++) {
            BigDecimal x = incomeMonth(i, year, "music");
            listmusic.add(x);
        }
        for (int i = 0; i < listmusic.size(); i++) {
            if (i != listmusic.size() - 1) {
                smusic += listmusic.get(i) + ",";
            } else {
                smusic += listmusic.get(i);
            }
        }
        
        List<BigDecimal> listgame = new ArrayList<BigDecimal>();
        String sgame = "";
        for (int i = 1; i < 13; i++) {
            BigDecimal x = incomeMonth(i, year, "game");
            listgame.add(x);
        }
        for (int i = 0; i < listgame.size(); i++) {
            if (i != listgame.size() - 1) {
                sgame += listgame.get(i) + ",";
            } else {
                sgame += listgame.get(i);
            }
        }
        
        
        
        List<BigDecimal> listmovie = new ArrayList<BigDecimal>();
        String smovie = "";
        for (int i = 1; i < 13; i++) {
            BigDecimal x = incomeMonth(i, year, "movie");
            listmovie.add(x);
        }
        for (int i = 0; i < listmovie.size(); i++) {
            if (i != listmovie.size() - 1) {
                smovie += listmovie.get(i) + ",";
            } else {
                smovie += listmovie.get(i);
            }
        }
        
        return "<script type=\"text/javascript\">\n"
                + "$(function () {\n"
                + "        $('#container').highcharts({\n"
                + "            chart: {\n"
                + "                type: 'line'\n"
                + "            },\n"
                + "            title: {\n"
                + "                text: 'Income months by year, "+year+"'\n"
                + "            },\n"
                + "            subtitle: {\n"
                + "                text: 'Source: DVDShop'\n"
                + "            },\n"
                + "            xAxis: {\n"
                + "                categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']\n"
                + "            },\n"
                + "            yAxis: {\n"
                + "                title: {\n"
                + "                    text: 'Income of month by year'\n"
                + "                }\n"
                + "            },\n"
                + "            tooltip: {\n"
                + "                enabled: false,\n"
                + "                formatter: function() {\n"
                + "                    return '<b>'+ this.series.name +'</b><br/>'+\n"
                + "                        this.x +': '+ this.y +'°C';\n"
                + "                }\n"
                + "            },\n"
                + "            plotOptions: {\n"
                + "                line: {\n"
                + "                    dataLabels: {\n"
                + "                        enabled: true\n"
                + "                    },\n"
                + "                    enableMouseTracking: false\n"
                + "                }\n"
                + "            },\n"
                + "            series: [{\n"
                + "                name: 'Music DVD',\n"
                + "                data: ["+smusic+"]\n"
                + "            }, {\n"
                + "                name: 'Movie DVD',\n"
                + "                data: ["+smovie+"]\n"
                + "            }, {\n"
                + "                name: 'Game DVD',\n"
                + "                data: ["+sgame+"]\n"
                + "            }\n"
                + "        ]\n"
                + "        });\n"
                + "    });\n"
                + "    \n"
                + "\n"
                + "		</script>";
    }
    
    public static int topSellId(String type){
        String sql = "select TOP(1) d.ProductId from Bill b join BillDetail d on b.Id = d.BillId join DVD v on d.ProductId = v.Id where b.Status = 2 and DATEPART(mm, b.OrderDate)=10 and DATEPART(YYYY, b.OrderDate)=2010 and v.Type = '"+type+"' GROUP BY(d.ProductId) order by (SUM(d.Quantity)) desc";
        try {
             return (Integer)getSession().createSQLQuery(sql).uniqueResult();
        } catch (Exception ex) {
            return 0;
        }
    }
    public static Dvd topDVD(String type){
        String sql = "select * from DVD d where d.Id = "+topSellId(type);
        try {
             return (Dvd)getSession().createSQLQuery(sql).uniqueResult();
        } catch (Exception ex) {
            return null;
        }
    }
    public static int topSellCount(String type){
        String sql = "select TOP(1) SUM(d.Quantity) as total from Bill b join BillDetail d on b.Id = d.BillId join DVD v on d.ProductId = v.Id where b.Status = 2 and DATEPART(mm, b.OrderDate)=10 and DATEPART(YYYY, b.OrderDate)=2010 and v.Type = '"+type+"' GROUP BY(d.ProductId) order by (total) desc";
        try {
             return (Integer)getSession().createSQLQuery(sql).uniqueResult();
        } catch (Exception ex) {
            return 0;
        }
    }
    public static String prin(){
        int topmusic = topSellId("music");
        int countmusic = topSellCount("music");
        Dvd dmusic = topDVD("music");
        
        int topmovie = topSellId("music");
        int countmovie = topSellCount("music");
        Dvd dmovie = topDVD("music");
        
        int topgame = topSellId("music");
        int countgame = topSellCount("music");
        Dvd dgame = topDVD("music");
        
        String s = "<script>$(function () { $('#container').highcharts({ chart: { type: 'column', margin: [ 50, 50, 100, 80] }, title: { text: 'The best selling' }, xAxis: { categories: [ 'Music', 'Movie', 'Game' ], labels: { rotation: -45, align: 'right', style: { fontSize: '13px', fontFamily: 'Verdana, sans-serif' } } }, yAxis: { min: 0, title: { text: 'Number' } }, legend: { enabled: false }, tooltip: { formatter: function() { return ''+ this.x +''+ 'Population in 2008: '+ Highcharts.numberFormat(this.y, 1) + ' millions'; } }, series: [{ name: 'Population', data: [34.4, 21.8, 20.1], dataLabels: { enabled: true, rotation: -90, color: '#FFFFFF', align: 'right', x: 4, y: 10, style: { fontSize: '13px', fontFamily: 'Verdana, sans-serif' } } }] }); });</script>";
        return s;
    
    }
}
