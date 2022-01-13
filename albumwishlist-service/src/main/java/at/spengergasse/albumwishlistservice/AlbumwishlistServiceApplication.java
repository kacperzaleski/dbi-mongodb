package at.spengergasse.albumwishlistservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@SpringBootApplication
public class AlbumwishlistServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlbumwishlistServiceApplication.class, args);
    }

}
