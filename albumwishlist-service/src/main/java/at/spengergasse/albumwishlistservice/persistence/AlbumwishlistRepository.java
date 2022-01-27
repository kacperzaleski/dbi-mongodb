package at.spengergasse.albumwishlistservice.persistence;

import at.spengergasse.albumwishlistservice.domain.Album;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumwishlistRepository extends CrudRepository<Album, String> {

    List<Album> findAll();

}
