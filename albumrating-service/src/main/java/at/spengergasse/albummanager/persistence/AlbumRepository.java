package at.spengergasse.albummanager.persistence;


import at.spengergasse.albummanager.domain.Album;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AlbumRepository extends MongoRepository<Album, String> {


    Album findAlbumByAlbumName(String albumname);

    void deleteAlbumByAlbumName(String albumname);



}
