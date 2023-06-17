package ru.hits.lecturehosting.hall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class LectureHostingHallApplication {

    public static void main(String[] args) {
        SpringApplication.run(LectureHostingHallApplication.class, args);
    }

}
