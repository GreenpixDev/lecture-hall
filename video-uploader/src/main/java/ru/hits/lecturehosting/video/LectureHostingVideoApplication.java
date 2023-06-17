package ru.hits.lecturehosting.video;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class LectureHostingVideoApplication {

    public static void main(String[] args) {
        SpringApplication.run(LectureHostingVideoApplication.class, args);
    }

}
