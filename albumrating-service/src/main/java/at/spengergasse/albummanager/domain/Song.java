package at.spengergasse.albummanager.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("songs")
@AllArgsConstructor
public class Song extends Persistable{

    @Getter
    private String songTitle;
    @Getter
    private Artist artist;
    private int songduration;

}
