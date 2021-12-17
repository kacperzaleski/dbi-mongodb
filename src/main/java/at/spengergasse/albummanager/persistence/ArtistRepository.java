package at.spengergasse.albummanager.persistence;

import at.spengergasse.albummanager.domain.Artist;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArtistRepository extends MongoRepository<Artist, String> {
}
