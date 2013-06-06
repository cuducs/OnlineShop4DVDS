package g3.hibernate.entity;
// Generated Jun 5, 2013 8:44:18 AM by Hibernate Tools 3.2.1.GA



/**
 * AlbumMusicMappingId generated by hbm2java
 */
public class AlbumMusicMappingId  implements java.io.Serializable {


     private int albumId;
     private int songId;

    public AlbumMusicMappingId() {
    }

    public AlbumMusicMappingId(int albumId, int songId) {
       this.albumId = albumId;
       this.songId = songId;
    }
   
    public int getAlbumId() {
        return this.albumId;
    }
    
    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }
    public int getSongId() {
        return this.songId;
    }
    
    public void setSongId(int songId) {
        this.songId = songId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof AlbumMusicMappingId) ) return false;
		 AlbumMusicMappingId castOther = ( AlbumMusicMappingId ) other; 
         
		 return (this.getAlbumId()==castOther.getAlbumId())
 && (this.getSongId()==castOther.getSongId());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getAlbumId();
         result = 37 * result + this.getSongId();
         return result;
   }   


}


