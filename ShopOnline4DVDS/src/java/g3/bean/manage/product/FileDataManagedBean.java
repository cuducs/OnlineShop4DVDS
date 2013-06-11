/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.bean.manage.product;

import g3.bean.utility.AppConstant;
import g3.hibernate.entity.FileData;
import g3.hibernate.entity.Producer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Administrator
 */
@ManagedBean
@SessionScoped
public class FileDataManagedBean {

    private FileData curFileData;
    private int formMode;
    private FileDataManagedHelper helper;
    private String returnFromDetails;
    private FileData searchFileData;
    private List<FileData> resustSearch;
    private String urlFileUpload;
    private String fileContentType;
    public static final String URL_TO_FILE_FOLDER = "/ShopOnline4DVDS/uploads";
    public static final String URL_TO_FILE_FOLDER_IMAGE = "/ShopOnline4DVDS/uploads/images";
    public static final String URL_TO_FILE_FOLDER_VIDEO = "/ShopOnline4DVDS/uploads/videos";
    public static final String URL_TO_FILE_FOLDER_SOUND = "/ShopOnline4DVDS/uploads/sounds";
    public static final String NO_NAME = "No_Name";
    private DefaultStreamedContent download;

    /**
     * Creates a new instance of FileManagedBean
     */
    public FileDataManagedBean() {
    }

    @PostConstruct
    public void init() {
        helper = FileDataManagedHelper.getInstance();
    }

    @PreDestroy
    public void end() {
        helper.close();
    }

    public List<FileData> getResustSearch() {
        return resustSearch;
    }

    public void setResustSearch(List<FileData> resustSearch) {
        this.resustSearch = resustSearch;
    }

    public FileData getSearchFileData() {
        if (searchFileData == null) {
            searchFileData = new FileData();
        }
        return searchFileData;
    }

    public String search() {

        if (searchFileData != null) {
            resustSearch = helper.search(searchFileData);
        }
        return null;
    }

    public void setSearchFileData(FileData searchFileData) {
        this.searchFileData = searchFileData;
    }

    public int getMode() {
        return formMode;
    }

    public void setMode(int mode) {
        this.formMode = mode;
    }

    public FileData getCurFileData() {
        return curFileData;
    }

    public void setCurFileData(FileData curFileData) {
        this.curFileData = curFileData;
    }

    public String create() {
        curFileData = new FileData();

        formMode = AppConstant.FORM_MODE_CREATE;
        return "fileform";
    }

    public String edit(FileData item) {
        curFileData = item;
        formMode = AppConstant.FORM_MODE_EDIT;
        return "form";
    }

    public String details(FileData item) {
        curFileData = item;
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        returnFromDetails = params.get("from");
        return "details";
    }

    public FileData detailFileData() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String id = params.get("detailid");
        if (id != null) {
            return (FileData) helper.getObjectById(FileData.class, id);
        }
        return curFileData;
    }

    public String back() {
        return returnFromDetails;
    }

    public String save() {
        String ext = getExtension(curFileData.getUrl());
        if (ext.equals("gif") || ext.equals("png") || ext.equals("jpg") || ext.equals("jpe")) {
            curFileData.setType("image");
        } else if (ext.equals("mp4") || ext.equals("flv")) {
            curFileData.setType("video");
        } else if (ext.equals("mp3")) {
            curFileData.setType("sound");
        } else {
            curFileData.setType("link");
        }

        curFileData.setCreatedDate(new Date());
        curFileData.setModifiedDate(new Date());
        helper.save(curFileData);
        curFileData = null;
        return "show";
    }

    public String del(FileData item) {
        item.setIsDeleted(true);
        item.setModifiedDate(new Date());
        helper.update(item);
        return null;
    }

    public String update() {
        String ext = getExtension(curFileData.getUrl());
        if (ext.equals("gif") || ext.equals("png") || ext.equals("jpg") || ext.equals("jpe")) {
            curFileData.setType("image");
        } else if (ext.equals("mp4") || ext.equals("flv")) {
            curFileData.setType("video");
        } else if (ext.equals("mp3")) {
            curFileData.setType("sound");
        } else {
            curFileData.setType("link");
        }

        curFileData.setModifiedDate(new Date());
        helper.update(curFileData);
        return "show";
    }

    public List<FileData> getAllFileDatas() {
        return helper.getAllFileDatas();
    }

    public List<FileData> getAllFileDatasDeleted() {
        return helper.getAllFileDatasDeleted();
    }

    public String recovery(FileData item) {
        item.setIsDeleted(false);
        item.setModifiedDate(new Date());
        helper.update(item);
        return null;
    }

    public String cancel() {
        curFileData = new FileData();
        return "show";
    }

    public void handleFileUpload(FileUploadEvent event) {
        String fileName = event.getFile().getFileName();
        String path = getPath();
        FileData newFile = new FileData();
        newFile.setTitle(NO_NAME);
        newFile.setCreatedDate(new Date());
        newFile.setModifiedDate(new Date());
        newFile.setIsDeleted(false);
        String ext = getExtension(fileName);
        if (ext.equals("gif") || ext.equals("png") || ext.equals("jpg") || ext.equals("jpe")) {
            path += "\\images";
            newFile.setType("image");
            urlFileUpload = URL_TO_FILE_FOLDER_IMAGE;
        } else if (ext.equals("mp4") || ext.equals("flv")) {
            newFile.setType("video");
            path += "\\videos";
            urlFileUpload = URL_TO_FILE_FOLDER_VIDEO;
        } else if (ext.equals("mp3")) {
            newFile.setType("sound");
            path += "\\sounds";
            urlFileUpload = URL_TO_FILE_FOLDER_SOUND;
        }
        saveFile(event.getFile(), path);
        urlFileUpload += "/" + fileName;
        newFile.setUrl(urlFileUpload);
        helper.getSession().save(newFile);
        fileContentType = event.getFile().getContentType();

        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Succesful", "Your Url :" + urlFileUpload);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public String getPath() {
        return FacesContext.getCurrentInstance().getExternalContext().getRealPath("//uploads");
    }

    public String getExtension(String fileName) {
        String ext = null;
        String s = fileName;
        int i = s.lastIndexOf('.');
        if (i == -1) {
            return "link";
        }
        if (i > 0 && i < s.length() - 1) {
            ext = s.substring(i + 1).toLowerCase();
        }
        return ext;
    }

    private void saveFile(UploadedFile file, String path) {
        InputStream in = null;
        OutputStream out = null;
        try {
            File result = new File(path + "\\" + file.getFileName());
            out = new FileOutputStream(result);
            byte[] buffer = new byte[1024];
            int read = 0;
            in = file.getInputstream();
            while ((read = in.read(buffer)) != -1) {
                out.write(buffer, 0, read);
            }
        } catch (IOException ex) {
            Logger.getLogger(FileDataManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {

                in.close();
                out.flush();
                out.close();
            } catch (IOException ex) {
                Logger.getLogger(FileDataManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void prepareDownload(ActionEvent event) {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String id = params.get("download");
        FileData filedata = null;
        if (id != null) {
            filedata = (FileData) helper.getObjectById(FileData.class, id);
        } else {
            filedata = curFileData;
        }
        try {
            if (download != null) {
                download.getStream().close();
            }
        } catch (IOException ex) {
            Logger.getLogger(FileDataManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        InputStream stream = null;
        String filename = getFileNameFromUrl(filedata.getUrl());
        String path = getPath();
        String ext = getExtension(filename);
        if (ext.equals("gif") || ext.equals("png") || ext.equals("jpg") || ext.equals("jpe")) {
            path += "\\images";
        } else if (ext.equals("mp4") || ext.equals("flv")) {
            path += "\\videos";
        } else if (ext.equals("mp3")) {
            path += "\\sounds";
        }
        path = path + "\\" + filename;
        try {
            stream = new FileInputStream(path);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileDataManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        download = new DefaultStreamedContent(stream, FacesContext.getCurrentInstance().getExternalContext().getMimeType(filename), filename);
    }

    public DefaultStreamedContent getDownload() {

        return download;
    }

    private String getFileNameFromUrl(String url) {
        String filename = null;
        String s = url;
        int i = s.lastIndexOf('/');
        if (i > 0 && i < s.length() - 1) {
            filename = s.substring(i + 1);
        }
        return filename;

    }

    public Map<String, Object> getListType() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(AppConstant.FILE_TYPE_SOUND, AppConstant.FILE_TYPE_SOUND);
        map.put(AppConstant.FILE_TYPE_VIDEO, AppConstant.FILE_TYPE_VIDEO);
        map.put(AppConstant.FILE_TYPE_SOUND_NET, AppConstant.FILE_TYPE_SOUND_NET);
        map.put(AppConstant.FILE_TYPE_VIDEO_NET, AppConstant.FILE_TYPE_VIDEO_NET);
        return map;
    }

    public Map<String, Object> getListTypeSearch() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("All", null);
        List<String> lst = helper.getSession().createSQLQuery("select distinct f.type from FileData f").list();
        for (String string : lst) {
            map.put(string.toUpperCase(), string);
        }
        return map;
    }

    public String getType(String filename) {
        String ext = getExtension(filename);
        if (ext.equals("gif") || ext.equals("png") || ext.equals("jpg") || ext.equals("jpe")) {
            return "image";
        } else if (ext.equals("mp4") || ext.equals("flv")) {
            return "video";
        } else if (ext.equals("mp3")) {
            return "sound";
        }
        return "link";
    }
     public FileData fileDataById(String id) {
        FileData output = (FileData) helper.getObjectById(FileData.class, id);
        return output;
    }
}
