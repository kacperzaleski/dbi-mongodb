package at.spengergasse.albummanager.persistence;

import at.spengergasse.albummanager.domain.Album;
import at.spengergasse.albummanager.domain.Artist;
import at.spengergasse.albummanager.domain.Song;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureDataMongo
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AlbumRepositoryTest {

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    private Faker faker = new Faker();

    private List<Song> songs;
    private List<Album> albums;
    private List<Artist> artists;

    @BeforeAll
    public void initDB(){
      /*  mongoTemplate.dropCollection("songs");
        mongoTemplate.dropCollection("albums");
        mongoTemplate.dropCollection("artists");
        mongoTemplate.createCollection("artists");
        mongoTemplate.createCollection("albums");
        mongoTemplate.createCollection("songs"); */

        artists = new ArrayList<>();
        for(int i = 0; i < 50; i++){
            artists.add(new Artist(faker.artist().name()));
        }


        songs = new ArrayList<>();
        for(int i = 0; i < 50; i++){
            songs.add(new Song(faker.book().title(), artists.get((int)(Math.random()*50)),
                    (int) (Math.random()*1800)));
        }

        albums = new ArrayList<>();
        for(int i = 0; i < 50; i++){
            var artist = artists.get((int)(Math.random()*50));
            albums.add(new Album(faker.book().title(), (int) (Math.random()*7200),
                    artist,
                    null,
                    songs
                            .stream()
                            .filter(s -> s.getArtist().getArtistName().equals(artist.getArtistName()))
                            .collect(Collectors.toList())));
        }

        System.out.println(albums.get(5).getAlbumName());

        albums.forEach(a -> System.out.println(a.getAlbumName()));
        albums.get(5).getSongs().forEach(s -> System.out.println(s.getArtist().getArtistName()));

        mongoTemplate.insertAll(artists);
        mongoTemplate.insertAll(songs);
        mongoTemplate.insertAll(albums);

    }

    @Test
    void findAllAlbumsMongoTemplate(){
        var list = mongoTemplate.findAll(Album.class);
        assertThat(list).isNotEmpty();
    }

    @Test
    void findAllAlbumsMongoRepository(){
        var list = albumRepository.findAll();
        assertThat(list).isNotEmpty();
    }

    @Test
    void findOneAlbumByAlbumName(){
        Album album = albumRepository.findAlbumByAlbumName("The Little Foxes");
        assertThat(album.getAlbumName()).isEqualTo("The Little Foxes");
    }

    @Test
    void insertOneAlbum(){
        var artist = mongoTemplate.findAll(Artist.class).get(5);
        Album album = new Album("King", (int) (Math.random()*7200),
                artist,
                null,
                songs
                        .stream()
                        .filter(s -> s.getArtist().getArtistName().equals(artist.getArtistName()))
                        .collect(Collectors.toList()));
        albumRepository.insert(album);

        assertThat(albumRepository.findAlbumByAlbumName("King").getAlbumName())
                .isEqualTo(album.getAlbumName());
    }


}
