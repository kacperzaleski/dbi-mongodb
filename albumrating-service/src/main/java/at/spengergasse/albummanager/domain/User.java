package at.spengergasse.albummanager.domain;

import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("users")
public class User extends Persistable{

    @Getter
    private String username;
}
