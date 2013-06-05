/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.server.bean;

import g3.server.bean.utility.AppConstant;
import g3.hibernate.entity.FileData;
import g3.hibernate.entity.Genre;
import java.util.Date;
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
        generateTableFile();
    }

    private void generateTableFile() {
        Transaction beginTransaction = session.beginTransaction();

        FileData f1 = new FileData(0, "Title1", "Url1", AppConstant.FILE_TYPE_SOUND, 0, new Date(), null, false);
        session.save(f1);

        f1 = new FileData(0, "Title2", "Url2", AppConstant.FILE_TYPE_VIDEO, 0, new Date(), null, false);
        session.save(f1);

        f1 = new FileData(0, "Title3", "Url3", AppConstant.FILE_TYPE_SOUND, 0, new Date(), null, false);
        session.save(f1);

        f1 = new FileData(0, "Title4", "Url4", AppConstant.FILE_TYPE_SOUND, 0, new Date(), null, false);
        session.save(f1);

        f1 = new FileData(0, "Title5", "Url5", AppConstant.FILE_TYPE_VIDEO, 0, new Date(), null, false);
        session.save(f1);

        beginTransaction.commit();
    }

    private void generateTableGenre() {
        
    }
}
