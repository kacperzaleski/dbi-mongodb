package at.spengergasse.albummanager.domain;

import com.mongodb.lang.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("artists")
@Data
@Builder
public class Artist extends Persistable{


    private String artistName;

    @Nullable
    private float rating;

    @Nullable
    private List<Album> albums;



}
