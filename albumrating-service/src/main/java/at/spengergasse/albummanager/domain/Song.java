package at.spengergasse.albummanager.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("songs")
@Data
@Builder
public class Song extends Persistable{


    private String songTitle;
    private Artist artist;
    private int songduration;

}
