package at.spengergasse.albummanager.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("albums")
@AllArgsConstructor
@Getter
public class Album extends Persistable {


    private String albumName;
    private int length;
    private Artist artist;


    private List<Song> songs;


}
