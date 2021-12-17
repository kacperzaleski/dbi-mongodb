package at.spengergasse.albummanager.persistence;

import at.spengergasse.albummanager.domain.Song;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SongRepository extends MongoRepository<Song, String> {
}
