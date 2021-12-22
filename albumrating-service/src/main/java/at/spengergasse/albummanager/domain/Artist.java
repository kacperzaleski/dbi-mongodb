package at.spengergasse.albummanager.domain;

import com.mongodb.lang.Nullable;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("artists")
public class Artist extends Persistable{

    @Getter
    private String artistName;

    @Nullable
    private float rating;

    @Nullable
    private List<Album> albums;

    public Artist(String artistName){
        this.artistName = artistName;
    }

}
