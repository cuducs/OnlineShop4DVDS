/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.server.bean;

import g3.server.bean.utility.AppConstant;
import g3.hibernate.entity.ver2.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;

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
    Date today = new Date();
    Producer producer1 = new Producer(0, "Square Enix", "Website:www.square-enix.com;", today, today, false);
    Producer producer2 = new Producer(0, "Walt Disney", "Website:www.disneyinternational.com;", today, today, false);
    Producer producer3 = new Producer(0, "Sony", "Website:Sony.net;", today, today, false);
    Supplier supplier1 = new Supplier(0, "20th Century Fox", "Website:www.foxmovies.com;", today, today, false);
    Supplier supplier2 = new Supplier(0, "Walt Disney", "Website:www.disneyinternational.com;", today, today, false);
    Supplier supplier3 = new Supplier(0, "cduniverse", "Website:www.cduniverse.com/;", today, today, false);
    FileData fileData1 = new FileData(0, "Iron Man 3", "<iframe width='560' height='315' src='http://www.youtube.com/embed/YoSLyg1m-JE' frameborder='0' allowfullscreen></iframe>", AppConstant.FILE_TYPE_YOUTUBE, 0, today, today, false);
    FileData fileData2 = new FileData(0, "Wreck-It Ralph Blu-ray", "<iframe width='560' height='315' src='http://www.youtube.com/embed/87E6N7ToCxs' frameborder='0' allowfullscreen></iframe>", AppConstant.FILE_TYPE_YOUTUBE, 0, today, today, false);
    FileData fileData3 = new FileData(0, "Flight", "<iframe width='560' height='315' src='http://www.youtube.com/embed/MlFMZ5D8FNc' frameborder='0' allowfullscreen></iframe>", AppConstant.FILE_TYPE_YOUTUBE, 0, today, today, false);
    FileData fileData4 = new FileData(0, "Football Manager 2013 PC", "<iframe width='560' height='315' src='http://www.youtube.com/embed/GcyHvtTqcd4' frameborder='0' allowfullscreen></iframe>", AppConstant.FILE_TYPE_YOUTUBE, 0, today, today, false);
    FileData fileData5 = new FileData(0, "The Sims 3 PC", "<iframe width='560' height='315' src='http://www.youtube.com/embed/LPnK9JHoddc' frameborder='0' allowfullscreen></iframe>", AppConstant.FILE_TYPE_YOUTUBE, 0, today, today, false);
    FileData fileData6 = new FileData(0, "Call of Duty: Black Ops 2 PC", "<iframe width='560' height='315' src='http://www.youtube.com/embed/YDJBPk0-TSk' frameborder='0' allowfullscreen></iframe>", AppConstant.FILE_TYPE_YOUTUBE, 0, today, today, false);
    FileData fileData7 = new FileData(0, "Lodi", "http://images.amplified.com/FLVStream/Catalog/141734a5-4d3f-46fe-86cc-edb7c07346c4/Product/230e1c9a-c747-4dbe-a891-909844af8acb/015707829250_01_003_mp3_128k_30sec_0001_102.mp3", AppConstant.FILE_TYPE_SOUND_INTERNET, 0, today, today, false);
    FileData fileData8 = new FileData(0, "Fortunate Son", "http://images.amplified.com/FLVStream/Catalog/141734a5-4d3f-46fe-86cc-edb7c07346c4/Product/230e1c9a-c747-4dbe-a891-909844af8acb/015707829250_01_001_mp3_128k_30sec_0001_102.mp3", AppConstant.FILE_TYPE_SOUND_INTERNET, 0, today, today, false);
    FileData fileData9 = new FileData(0, "Mystic Highway", "http://images.amplified.com/FLVStream/Catalog/141734a5-4d3f-46fe-86cc-edb7c07346c4/Product/230e1c9a-c747-4dbe-a891-909844af8acb/015707829250_01_004_mp3_128k_30sec_0001_102.mp3", AppConstant.FILE_TYPE_SOUND_INTERNET, 0, today, today, false);
    Artist artist1=new Artist(0, "John Fogerty", "John Fogerty", AppConstant.ARTIST_BOTH, today, today, false);
    Artist artist2=new Artist(0, "Alice In Chains", "Alice In Chains", AppConstant.ARTIST_SINGER, today, today, false);
    Artist artist3=new Artist(0, "Rodriguez", "Rodriguez", AppConstant.ARTIST_COMPOSER, today, today, false);
    public void generate() {

        session.save(producer1);
        session.save(producer2);
        session.save(producer3);

        session.save(supplier1);
        session.save(supplier2);
        session.save(supplier3);

        List<FileData> lstFileData = new ArrayList<FileData>();
        lstFileData.add(fileData1);
        lstFileData.add(fileData2);
        lstFileData.add(fileData3);

        lstFileData.add(fileData4);
        lstFileData.add(fileData5);
        lstFileData.add(fileData6);

        lstFileData.add(fileData7);
        lstFileData.add(fileData8);
        lstFileData.add(fileData9);
        for (FileData fileData : lstFileData) {
            session.save(fileData);
        }
        
        session.save(artist1);
        session.save(artist2);
        session.save(artist3);

        Song song1 = new Song(0, "Lodi", artist1.getId(), artist1.getId(), "lyrics", true, fileData7.getId(), "info ab", today, today, false);
        Song song2 = new Song(0, "Fortunate Son", artist1.getId(), artist1.getId(), "lyrics", false, fileData8.getId(), "info ab", today, today, false);
        Song song3 = new Song(0, "Mystic Highway", artist1.getId(), artist1.getId(), "lyrics", false, fileData9.getId(), "info ab", today, today, false);
        List<Song> lstSong = new ArrayList<Song>();
        lstSong.add(song1);
        lstSong.add(song2);
        lstSong.add(song3);
        for (Song song : lstSong) {
            session.save(song);
        }

        Album album = new Album(0, "Wrote a Song for Everyone", "John Fogerty", 0, 3, "description", true, today, today, false);
        session.save(album);

        AlbumMusicMapping mapping = new AlbumMusicMapping(new AlbumMusicMappingId(album.getId(), song1.getId()), 1);
        session.save(mapping);
        mapping = new AlbumMusicMapping(new AlbumMusicMappingId(album.getId(), song2.getId()), 2);
        session.save(mapping);
        mapping = new AlbumMusicMapping(new AlbumMusicMappingId(album.getId(), song3.getId()), 3);
        session.save(mapping);

        List<Genre> lstGenre = new ArrayList<Genre>();
        lstGenre.add(new Genre(0, "Rock", AppConstant.DVD_TYPE_MUSIC, "description", today, today, false));
        lstGenre.add(new Genre(0, "Country", AppConstant.DVD_TYPE_MUSIC, "description", today, today, false));
        lstGenre.add(new Genre(0, "Rap", AppConstant.DVD_TYPE_MUSIC, "description", today, today, false));
        for (Genre genre : lstGenre) {
            session.save(genre);
        }
//        List<Dvd> lstDvd = new ArrayList<Dvd
//        for (Dvd dvd : lstDvd) {
//            session.save(dvd);
//        }
    }
}
