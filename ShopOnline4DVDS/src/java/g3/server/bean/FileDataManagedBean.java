/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g3.server.bean;

import g3.hibernate.entity.FileData;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
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
        curFileData = new FileData(0, false);
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
    
    public String back() {
        return returnFromDetails;
    }
    
    public String save() {
        curFileData.setCreatedDate(new Date());
        curFileData.setModifiedDate(new Date());
        helper.save(curFileData);
        moveFileWhenNew();
        curFileData = null;
        return "show";
    }

    public void moveFileWhenNew() {
        File source = new File(getPath() + "/" + 0 + "/" + curFileData.getUrl());
        if (source.exists()) {
            File directory = new File(getPath() + "/" + curFileData.getId());
            if (!directory.exists()) {
                directory.mkdir();
            }
            source.renameTo(new File(getPath() + "/" + curFileData.getId() + "/" + source.getName()));
        }
    }

    public String del(FileData item) {
        item.setIsDeleted(true);
        item.setModifiedDate(new Date());
        helper.update(item);
        return "show";
    }
    
    public String update() {
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
        return "recovery";
    }
    
    public String cancel() {
        curFileData = new FileData();
        return "show";
    }
    
    public void handleFileUpload(FileUploadEvent event) {
        String fileName = event.getFile().getFileName();
        saveFile(event.getFile(), getPath(), curFileData.getId());
        curFileData.setUrl(fileName);
        curFileData.setType(getExtension(fileName));
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Succesful", fileName + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public String getPath() {
        return FacesContext.getCurrentInstance().getExternalContext().getRealPath("//resources//files");
    }
    
    public String getExtension(String fileName) {
        String ext = null;
        String s = fileName;
        int i = s.lastIndexOf('.');
        
        if (i > 0 && i < s.length() - 1) {
            ext = s.substring(i + 1).toLowerCase();
        }
        return ext;
    }
    
    private void saveFile(UploadedFile file, String path, int fileId) {
        InputStream in = null;
        OutputStream out = null;
        try {
            File directory = new File(path + "/" + fileId);
            if (!directory.exists()) {
                directory.mkdir();
            }
            File result = new File(path + "/" + fileId + "/" + file.getFileName());
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
    private DefaultStreamedContent download;
    
    public DefaultStreamedContent getDownload() {
        InputStream stream = null;
        try {
            stream = new FileInputStream(getPath() + "/" + curFileData.getId() + "/" + curFileData.getUrl());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileDataManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        download = new DefaultStreamedContent(stream);
        
        return download;
    }
}
