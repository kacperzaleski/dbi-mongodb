package at.spengergasse.albummanager.domain;


public class AlbumRating {

    private String albumRatingId;

    private float rating;

    private User user;
    private Album album;

    public AlbumRating(float rating, User user, Album album){
        this.rating = rating;
        this.user = user;
        this.album = album;

        this.albumRatingId = user.getUsername()+album.getAlbumName()+rating;
    }
}
