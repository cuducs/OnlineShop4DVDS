/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.server.bean;

import g3.hibernate.entity.File;
import g3.hibernate.entity.Genre;
import java.util.Date;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Administrator
 */
public class SampleHelper extends BaseHelper {

    private static SampleHelper instance;

    private SampleHelper() {
    }

    public static SampleHelper getInstance() {
        if (instance == null) {
            instance = new SampleHelper();
        }
        return instance;
    }

    void generate() {
        generateTableGenre();
    }

    private void generateTableFile() {
        Transaction beginTransaction = session.beginTransaction();

        File f1 = new File();
        f1.setTitle("File1");
        f1.setType(AppConstant.FILE_TYPE_SOUND);
        f1.setUrl("Url1");
        f1.setViewCount(0);
        f1.setCreatedDate(new Date());
        f1.setModifiedDate(new Date());
        f1.setIsDeleted(false);
        session.save(f1);

        beginTransaction.commit();
    }
    
    private void generateTableGenre() {
        Transaction beginTransaction = session.beginTransaction();

        Genre g=new Genre();
        g.setName("Test2");
        g.setType("test3");
        session.save(g);
        beginTransaction.commit();
    }
}
