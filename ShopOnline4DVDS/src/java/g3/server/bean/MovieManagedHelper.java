/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.server.bean;

import g3.hibernate.entity.Movie;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Transaction;

/**
 *
 * @author Administrator
 */
public class MovieManagedHelper extends BaseHelper{
    private static MovieManagedHelper instance;

    private MovieManagedHelper() {
    }

    public static MovieManagedHelper getInstance() {
        if (instance == null) {
            instance = new MovieManagedHelper();
        }
        return instance;
    }

    public List<Movie> getAllMovies() {
        Transaction beginTransaction = session.beginTransaction();
        String hql = "FROM Movie g WHERE g.isDeleted=0";
        Query query = session.createQuery(hql);
        beginTransaction.commit();
        return query.list();
    }

    public boolean save(Movie curMovie) {
        Transaction beginTransaction = session.beginTransaction();
        session.save(curMovie);
        beginTransaction.commit();
        if (curMovie.getId() != 0) {
            return true;
        }
        return false;
    }

    void del(Movie item) {
        Transaction beginTransaction = session.beginTransaction();
        session.delete(item);
        beginTransaction.commit();

    }

    void update(Movie item) {
        Transaction beginTransaction = session.beginTransaction();
        session.update(item);
    }

    List<Movie> getAllMoviesDeleted() {
        Transaction beginTransaction = session.beginTransaction();
        String hql = "FROM Movie g WHERE g.isDeleted=1";
        Query query = session.createQuery(hql);
        beginTransaction.commit();
        return query.list();
    }

    List<Movie> search(Movie searchMovie) {
        Criteria criteria = session.createCriteria(Movie.class);
        if (searchMovie.getId() > 0) {
            criteria.add(org.hibernate.criterion.Expression.eq("id", searchMovie.getId()));
        }
        if (searchMovie.getTitle() != "") {
            criteria.add(org.hibernate.criterion.Expression.ilike("title", "%" + searchMovie.getTitle() + "%"));
        }
        if (searchMovie.getLanguage() != "") {
            criteria.add(org.hibernate.criterion.Expression.ilike("language", "%" + searchMovie.getLanguage() + "%"));
        }
        if (searchMovie.getCast() != "") {
            criteria.add(org.hibernate.criterion.Expression.ilike("cast", "%" + searchMovie.getCast() + "%"));
        }
        if (searchMovie.getCrew() != "") {
            criteria.add(org.hibernate.criterion.Expression.ilike("crew", "%" + searchMovie.getCrew() + "%"));
        }
        if (searchMovie.getStudio() != "") {
            criteria.add(org.hibernate.criterion.Expression.ilike("studio", "%" + searchMovie.getStudio() + "%"));
        }
        return criteria.list();
    }
}
