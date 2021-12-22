package at.spengergasse.albummanager.persistence;


import at.spengergasse.albummanager.domain.Album;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AlbumRepository extends MongoRepository<Album, String> {


    Album findAlbumByAlbumName(String albumaname);

    void deleteAlbumByAlbumName(String albumname);


}
