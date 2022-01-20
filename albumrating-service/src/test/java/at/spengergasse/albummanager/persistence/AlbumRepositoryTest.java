package at.spengergasse.albummanager.persistence;

import at.spengergasse.albummanager.domain.Album;
import at.spengergasse.albummanager.domain.Artist;
import at.spengergasse.albummanager.domain.Song;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.TestPropertySource;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureDataMongo
@Testcontainers
//@TestPropertySource(properties = "spring.mongodb.embedded.version=3.5.5")
//@ImportAutoConfiguration(exclude = EmbeddedMongoAutoConfiguration.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AlbumRepositoryTest {

    @Autowired
    private AlbumRepository albumRepository;

    //@Container
    //static final MongoDBContainer mongoDBContainer = new MongoDBContainer(DockerImageName.parse("mongo:4.0.10"));



    @Autowired
    private MongoTemplate mongoTemplate;

    private final Faker faker = new Faker();

    private List<Song> songs;
    private List<Album> albums;
    private List<Artist> artists;

    @BeforeAll
    public void initDB(){
        //mongoDBContainer.start();

        mongoTemplate.dropCollection("songs");
        mongoTemplate.dropCollection("albums");
        mongoTemplate.dropCollection("artists");
        mongoTemplate.createCollection("artists");
        mongoTemplate.createCollection("albums");
        mongoTemplate.createCollection("songs");

        artists = new ArrayList<>();
        for(int i = 0; i < 50; i++){
            artists.add(Artist.builder().artistName(faker.artist().name()).build());
        }


        songs = new ArrayList<>();
        for(int i = 0; i < 50; i++){
            songs.add(Song.builder()
                    .songTitle(faker.book().title())
                    .artist(artists.get((int)(Math.random()*50)))
                    .songduration( (int) (Math.random()*1800))
                    .build());
        }

        albums = new ArrayList<>();
        for(int i = 0; i < 50; i++){
            var artist = artists.get((int)(Math.random()*50));
            albums.add(Album.builder()
                    .albumName(faker.book().title())
                    .length((int) (Math.random()*7200))
                    .artist(artist)
                    .songs(songs.stream()
                            .filter(s -> s.getArtist().getArtistName().equals(artist.getArtistName()))
                            .collect(Collectors.toList()))
                    .build());
        }

        albums = albums.stream().distinct().collect(Collectors.toList());

        mongoTemplate.insertAll(artists);
        mongoTemplate.insertAll(songs);
        mongoTemplate.insertAll(albums);


    }

    @Test @Order(1)
    void findAllAlbumsMongoTemplate(){
        var list = mongoTemplate.findAll(Album.class);
        assertThat(list).isNotEmpty();
    }

    @Test @Order(2)
    void findAllAlbumsMongoRepository(){
        var list = albumRepository.findAll();
        assertThat(list).isNotEmpty();
    }

    @Test @Order(3)
    void insertOneAlbum(){
        var artist = mongoTemplate.findAll(Artist.class).get(5);
        var album = Album.builder()
                .albumName("King")
                .length((int) (Math.random()*7200))
                .artist(artist)
                .songs(songs.stream()
                        .filter(s -> s.getArtist().getArtistName().equals(artist.getArtistName()))
                        .collect(Collectors.toList()))
                .build();
        albumRepository.insert(album);
        assertThat(albumRepository.findAlbumByAlbumName("King").getAlbumName())
                .isEqualTo(album.getAlbumName());

    }

    @Test @Order(4)
    void findAlbumByAlbumName(){
        String albumname = albums.get(0).getAlbumName();
        if(albumname.equals(albumRepository.findAlbumByAlbumName(albumname).getAlbumName())){
            assertThat(albumRepository.findAlbumByAlbumName(albumname).getAlbumName()).isEqualTo(albumname);
        }
    }

    @Test @Order(5)
    void deleteAlbumByAlbumName(){
        var artist = mongoTemplate.findAll(Artist.class).get(6);
        var album = Album.builder()
                .albumName("Illmatic")
                .length((int) (Math.random()*7200))
                .artist(artist)
                .songs(songs.stream()
                        .filter(s -> s.getArtist().getArtistName().equals(artist.getArtistName()))
                        .collect(Collectors.toList()))
                .build();
        albumRepository.insert(album);
        assertThat(albumRepository.findAlbumByAlbumName("Illmatic").getAlbumName().equals("Illmatic"));

        albumRepository.deleteAlbumByAlbumName("Illmatic");

        var deletedAlbum = albumRepository.findAlbumByAlbumName("Illmatic");

        assertThat(deletedAlbum).isNull();
    }


    @Test @Order(6)
    void updateAlbumName(){
        var album = albumRepository.findAlbumByAlbumName("King");

        album.setAlbumName("Bossaura");

        albumRepository.save(album);

        var updatedAlbum = albumRepository.findAlbumByAlbumName("Bossaura");
        assertThat(updatedAlbum.getAlbumName().equals("Bossaura")).isTrue();
    }




}
