/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.bean.other;

import g3.bean.utility.DvdStoreHibernateUtil;
import g3.hibernate.entity.Dvd;
import g3.hibernate.entity.Member;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author lab
 */
public class ReportHelper {

    public ReportHelper() {
    }

    private static Session getSession() {
        return DvdStoreHibernateUtil.getSessionFactory().openSession();
    }

    public static int getTotalOrder(String day, String month, String year) {
        try {
            if (day.equals("--") && !month.equals("--")) {
                return (Integer) getSession().createSQLQuery("select count(id) from Bill b where DATEPART(mm, b.CreatedDate)=" + month + " and DATEPART(YYYY, b.CreatedDate)=" + year).uniqueResult();
            } else if (day.equals("--") && month.equals("--")) {
                return (Integer) getSession().createSQLQuery("select count(id) from Bill b where DATEPART(YYYY, b.CreatedDate)=" + year).uniqueResult();
            } else {
                return (Integer) getSession().createSQLQuery("select count(id) from Bill b where DATEPART(dd, b.CreatedDate)=" + day + " and DATEPART(mm, b.CreatedDate)=" + month + " and DATEPART(YYYY, b.CreatedDate)=" + year).uniqueResult();
            }
        } catch (Exception ex) {
            return 0;
        }
    }

    public static int getDoneOrder(String day, String month, String year) {
        try {
            String s = "";
            int x = 0;
            if (year != null && year != "") {
                if (day.equals("--") && !month.equals("--")) {
                    s = "select count(id) from Bill b where [Status] = 2 and b.IsDeleted = 0 and DATEPART(mm, b.CreatedDate)=" + month + " and DATEPART(YYYY, b.CreatedDate)=" + year;
                } else if (day.equals("--") && month.equals("--")) {
                    s = "select count(id) from Bill b where [Status] = 2 and b.IsDeleted = 0 and DATEPART(YYYY, b.CreatedDate)=" + year;
                } else {
                    s = "select count(id) from Bill b where [Status] = 2 and b.IsDeleted = 0 and DATEPART(dd, b.CreatedDate)=" + day + " and DATEPART(mm, b.CreatedDate)=" + month + " and DATEPART(YYYY, b.CreatedDate)=" + year;
                }
            }
            x = (Integer) getSession().createSQLQuery(s).uniqueResult();
            return x;
        } catch (Exception ex) {
            return 0;
        }
    }

    public static int getWaitingOrder(String day, String month, String year) {
        try {
            String s = "";
            int x = 0;
            if (year != null && year != "") {
                if (day.equals("--") && !month.equals("--")) {
                    s = "select count(id) from Bill b where [Status] = 1 and b.IsDeleted = 0 and DATEPART(mm, b.CreatedDate)=" + month + " and DATEPART(YYYY, b.CreatedDate)=" + year;
                } else if (day.equals("--") && month.equals("--")) {
                    s = "select count(id) from Bill b where [Status] = 1 and b.IsDeleted = 0 and DATEPART(YYYY, b.CreatedDate)=" + year;
                } else {
                    s = "select count(id) from Bill b where [Status] = 1 and b.IsDeleted = 0 and DATEPART(dd, b.CreatedDate)=" + day + " and DATEPART(mm, b.CreatedDate)=" + month + " and DATEPART(YYYY, b.CreatedDate)=" + year;
                }
            }
            x = (Integer) getSession().createSQLQuery(s).uniqueResult();
            return x;
        } catch (Exception ex) {
            return 0;
        }
    }

    public static int getCanceledOrder(String day, String month, String year) {
        try {
            String s = "";
            int x = 0;
            if (year != null && year != "") {
                if (day.equals("--") && !month.equals("--")) {
                    s = "select count(id) from Bill b where [Status] = 0 and b.IsDeleted = 0 and DATEPART(mm, b.CreatedDate)=" + month + " and DATEPART(YYYY, b.CreatedDate)=" + year;
                } else if (day.equals("--") && month.equals("--")) {
                    s = "select count(id) from Bill b where [Status] = 0 and b.IsDeleted = 0 and DATEPART(YYYY, b.CreatedDate)=" + year;
                } else {
                    s = "select count(id) from Bill b where [Status] = 0 and b.IsDeleted = 0 and DATEPART(dd, b.CreatedDate)=" + day + " and DATEPART(mm, b.CreatedDate)=" + month + " and DATEPART(YYYY, b.CreatedDate)=" + year;
                }
            }
            x = (Integer) getSession().createSQLQuery(s).uniqueResult();
            return x;
        } catch (Exception ex) {
            return 0;
        }
    }

    public static BigDecimal incomeMonth(String day, Integer month, String year, String type) {
        String sql = "";
        BigDecimal val = null;
        try {
            if (year != null && !year.equals("")) {
                if (day.equals("--") && !month.equals("--")) {
                    sql = "select SUM(b.Total) from Bill b join BillDetail d on b.Id = d.BillId join DVD v on d.dvdId = v.Id where v.Type = '" + type + "' and b.Status = 2 and DATEPART(mm, b.CreatedDate)=" + month + " and DATEPART(YYYY, b.CreatedDate)=" + year;
                } else if (day.equals("--") && month.equals("--")) {
                    sql = "select SUM(b.Total) from Bill b join BillDetail d on b.Id = d.BillId join DVD v on d.dvdId = v.Id where v.Type = '" + type + "' and b.Status = 2 and DATEPART(YYYY, b.CreatedDate)=" + year;
                } else {
                    sql = "select SUM(b.Total) from Bill b join BillDetail d on b.Id = d.BillId join DVD v on d.dvdId = v.Id where v.Type = '" + type + "' and b.Status = 2 and DATEPART(dd, b.CreatedDate)=" + day + " and DATEPART(mm, b.CreatedDate)=" + month + " and DATEPART(YYYY, b.CreatedDate)=" + year;
                }
                val = (BigDecimal) getSession().createSQLQuery(sql).uniqueResult();
            }
            if (val == null) {
                return new BigDecimal(0);
            }
            return val;
        } catch (Exception ex) {
            return new BigDecimal(0);
        }
    }

    public static String[] income(String day, String month, String year) {
        List<BigDecimal> listmusic = new ArrayList<BigDecimal>();
        String smusic = "";
        for (int i = 1; i < 13; i++) {
            BigDecimal x = incomeMonth(day, i, year, "music");
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
            BigDecimal x = incomeMonth(day, i, year, "game");
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
            BigDecimal x = incomeMonth(day, i, year, "movie");
            listmovie.add(x);
        }
        for (int i = 0; i < listmovie.size(); i++) {
            if (i != listmovie.size() - 1) {
                smovie += listmovie.get(i) + ",";
            } else {
                smovie += listmovie.get(i);
            }
        }
        String ss[] = {smusic, smovie, sgame};
        return ss;
    }

    public static int topSellId(String day, String month, String year, String type) {
        String sql = "";
        try {
            if (year != null && year != "") {
                if (day.equals("--") && !month.equals("--")) {
                    sql = "select TOP(1) d.dvdId from Bill b join BillDetail d on b.Id = d.BillId join DVD v on d.dvdId = v.Id where b.Status = 2 and DATEPART(mm, b.CreatedDate)=" + month + " and DATEPART(YYYY, b.CreatedDate)=" + year + " and v.Type = '" + type + "' GROUP BY(d.dvdId) order by (SUM(d.Quantity)) desc";
                } else if (day.equals("--") && month.equals("--")) {
                    sql = "select TOP(1) d.dvdId from Bill b join BillDetail d on b.Id = d.BillId join DVD v on d.dvdId = v.Id where b.Status = 2 and DATEPART(YYYY, b.CreatedDate)=" + year + " and v.Type = '" + type + "' GROUP BY(d.dvdId) order by (SUM(d.Quantity)) desc";
                } else {
                    sql = "select TOP(1) d.dvdId from Bill b join BillDetail d on b.Id = d.BillId join DVD v on d.dvdId = v.Id where b.Status = 2 and DATEPART(dd, b.CreatedDate)=" + day + " and DATEPART(mm, b.CreatedDate)=" + month + " and DATEPART(YYYY, b.CreatedDate)=" + year + " and v.Type = '" + type + "' GROUP BY(d.dvdId) order by (SUM(d.Quantity)) desc";
                }
            }
            return (Integer) getSession().createSQLQuery(sql).uniqueResult();
        } catch (Exception ex) {
            return 0;
        }
    }

    public static Dvd topDVD(String day, String month, String year, String type) {
        String sql = "select * from DVD d where d.Id = " + topSellId(day, month, year, type);
        try {
            return (Dvd) getSession().createSQLQuery(sql).uniqueResult();
        } catch (Exception ex) {
            return null;
        }
    }

    public static int topSellCount(String day, String month, String year, String type) {
        String sql = "";
        Integer x = 0;
        try {
            if (year != null && year != "") {
                if (day.equals("--") && !month.equals("--")) {
                    sql = "select TOP(1) SUM(d.Quantity) as total from Bill b join BillDetail d on b.Id = d.BillId join DVD v on d.dvdId = v.Id where b.Status = 2 and DATEPART(mm, b.CreatedDate)=" + month + " and DATEPART(YYYY, b.CreatedDate)=" + year + " and v.Type = '" + type + "' GROUP BY(d.dvdId) order by (total) desc";
                } else if (day.equals("--") && month.equals("--")) {
                    sql = "select TOP(1) SUM(d.Quantity) as total from Bill b join BillDetail d on b.Id = d.BillId join DVD v on d.dvdId = v.Id where b.Status = 2 and DATEPART(YYYY, b.CreatedDate)=" + year + " and v.Type = '" + type + "' GROUP BY(d.dvdId) order by (total) desc";
                } else {
                    sql = "select TOP(1) SUM(d.Quantity) as total from Bill b join BillDetail d on b.Id = d.BillId join DVD v on d.dvdId = v.Id where b.Status = 2 and DATEPART(dd, b.CreatedDate)=" + day + " and DATEPART(mm, b.CreatedDate)=" + month + " and DATEPART(YYYY, b.CreatedDate)=" + year + " and v.Type = '" + type + "' GROUP BY(d.dvdId) order by (total) desc";
                }
            }
            x = (Integer) getSession().createSQLQuery(sql).uniqueResult();
            return x;
        } catch (Exception ex) {
            return 0;
        }
    }

    public static Dvd[] topdvdDetail(String day, String month, String year) {
        Dvd dmusic = topDVD(day, month, year, "music");
        Dvd dmovie = topDVD(day, month, year, "movie");
        Dvd dgame = topDVD(day, month, year, "game");
        Dvd[] dl = {dmusic, dmovie, dgame};
        return dl;
    }

    public static int[] topnumber(String day, String month, String year) {
        int countmusic = topSellCount(day, month, year, "music");
        int countmovie = topSellCount(day, month, year, "movie");
        int countgame = topSellCount(day, month, year, "game");
        int[] tl = {countmusic, countmovie, countgame};
        return tl;
    }

    public static int cutomerQuantity(String day, String month, String year) {
        String sql = "";
        Integer x = 0;
        try {
            if (year != null && year != "") {
                if (day.equals("--") && !month.equals("--")) {
                    sql = "select TOP(1) SUM(d.Quantity) as q from Bill b join Member m on b.MemberId = m.Id join BillDetail d on d.BillId = b.Id where b.Status = 2 and DATEPART(mm, b.CreatedDate)=" + month + " and DATEPART(YYYY, b.CreatedDate)=" + year + " GROUP BY (b.MemberId) ORDER BY (q) desc";
                } else if (day.equals("--") && month.equals("--")) {
                    sql = "select TOP(1) SUM(d.Quantity) as q from Bill b join Member m on b.MemberId = m.Id join BillDetail d on d.BillId = b.Id where b.Status = 2 and DATEPART(YYYY, b.CreatedDate)=" + year + " GROUP BY (b.MemberId) ORDER BY (q) desc";
                } else {
                    sql = "select TOP(1) SUM(d.Quantity) as q from Bill b join Member m on b.MemberId = m.Id join BillDetail d on d.BillId = b.Id where b.Status = 2 and DATEPART(dd, b.CreatedDate)=" + day + " and DATEPART(mm, b.CreatedDate)=" + month + " and DATEPART(YYYY, b.CreatedDate)=" + year + " GROUP BY (b.MemberId) ORDER BY (q) desc";
                }
                x = (Integer) getSession().createSQLQuery(sql).uniqueResult();
            }
            return x;
        } catch (Exception ex) {
            return 0;
        }
    }

    public static int cutomerId(String day, String month, String year) {
        String sql = "";
        int x = 0;
        try {
            if (year != null && year != "") {
                if (day.equals("--") && !month.equals("--")) {
                    sql = "select TOP(1) b.MemberId from Bill b join Member m on b.MemberId = m.Id join BillDetail d on d.BillId = b.Id where b.Status = 2 and DATEPART(mm, b.CreatedDate)=" + month + " and DATEPART(YYYY, b.CreatedDate)=" + year + " GROUP BY (b.MemberId) ORDER BY (SUM(d.Quantity)) desc";
                } else if (day.equals("--") && month.equals("--")) {
                    sql = "select TOP(1) b.MemberId from Bill b join Member m on b.MemberId = m.Id join BillDetail d on d.BillId = b.Id where b.Status = 2 and DATEPART(YYYY, b.CreatedDate)=" + year + " GROUP BY (b.MemberId) ORDER BY (SUM(d.Quantity)) desc";
                } else {
                    sql = "select TOP(1) b.MemberId from Bill b join Member m on b.MemberId = m.Id join BillDetail d on d.BillId = b.Id where b.Status = 2 and DATEPART(dd, b.CreatedDate)=" + day + " and DATEPART(mm, b.CreatedDate)=" + month + " and DATEPART(YYYY, b.CreatedDate)=" + year + " GROUP BY (b.MemberId) ORDER BY (SUM(d.Quantity)) desc";
                }
                System.out.println("KQ: " + sql);
                x = (Integer) getSession().createSQLQuery(sql).uniqueResult();
            }
            return x;
        } catch (Exception ex) {
            return x;
        }
    }

    public static Member cutomerName(String day, String month, String year) {
        String sql = "FROM Member m where m.id = " + cutomerId(day, month, year);
        Member x = null;
        try {
            x = (Member) getSession().createQuery(sql).uniqueResult();
            return x;
        } catch (Exception ex) {
            return x;
        }
    }
    //Overview

    public static long totalDVD() {
        String sql = "SELECT COUNT(d.id) FROM Dvd d where d.isDeleted = 0";
        long x = 0;
        try {
            x = (Long) getSession().createQuery(sql).uniqueResult();
            return x;
        } catch (Exception ex) {
            return x;
        }
    }

    public static long totalMember() {
        String sql = "SELECT COUNT(d.id) FROM Member d where d.isLock = 0";
        long x = 0;
        try {
            x = (Long) getSession().createQuery(sql).uniqueResult();
            return x;
        } catch (Exception ex) {
            return x;
        }
    }

    public static long totalUnreadFeedback() {
        String sql = "SELECT COUNT(d.id) FROM Feedback d where d.isDeleted = 0 and d.isRead = 0";
        long x = 0;
        try {
            x = (Long) getSession().createQuery(sql).uniqueResult();
            return x;
        } catch (Exception ex) {
            return x;
        }
    }

    public static long totalSong() {
        String sql = "SELECT COUNT(d.id) FROM Song d where d.isDeleted = 0";
        long x = 0;
        try {
            x = (Long) getSession().createQuery(sql).uniqueResult();
            return x;
        } catch (Exception ex) {
            return x;
        }
    }

    public static BigDecimal incomeToday() {
        String sql = "select SUM(b.Total) from Bill b join BillDetail d on b.Id = d.BillId join DVD v on d.dvdId = v.Id where b.Status = 2 and DATEPART(dd, b.CreatedDate)=" + getDay() + " and DATEPART(mm, b.CreatedDate)=" + getMonth() + " and DATEPART(YYYY, b.CreatedDate)=" + getYear();
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

    public static int totalSoldToday() {
        String sql = "select SUM(d.Quantity) from Bill b join BillDetail d on b.Id = d.BillId join DVD v on d.dvdId = v.Id where b.Status = 2 and DATEPART(dd, b.CreatedDate)=" + getDay() + " and DATEPART(mm, b.CreatedDate)=" + getMonth() + " and DATEPART(YYYY, b.CreatedDate)=" + getYear();
        try {
            Integer val = (Integer) getSession().createSQLQuery(sql).uniqueResult();
            if (val == null) {
                return 0;
            }
            return val;
        } catch (Exception ex) {
            return 0;
        }
    }

    public static int getMonth() {
        Date d = new Date();
        return d.getMonth() + 1;
    }

    public static int getDay() {
        Date d = new Date();
        return d.getDate();
    }

    public static int getYear() {
        Date d = new Date();
        return d.getYear() + 1900;
    }
}
