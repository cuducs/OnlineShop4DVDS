/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.bean.utility;

/**
 *
 * @author kiendv_c00505
 */
public class AlbumObject {
    private int id;
    private String title;
    private String singer;
    private String url;

    public AlbumObject() {
    }

    public AlbumObject(int id, String title, String singer, String url) {
        this.id = id;
        this.title = title;
        this.singer = singer;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
