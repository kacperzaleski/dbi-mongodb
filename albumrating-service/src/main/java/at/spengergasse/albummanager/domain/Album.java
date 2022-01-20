package at.spengergasse.albummanager.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("albums")
@Data
@Builder
public class Album extends Persistable {


    private String albumName;
    private int length;
    private Artist artist;
    private float rating;


    private List<Song> songs;


}
