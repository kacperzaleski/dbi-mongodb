package at.spengergasse.albummanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class AlbumratingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlbumratingServiceApplication.class, args);
    }

}
