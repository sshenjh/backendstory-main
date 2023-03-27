package com.example.mongodb;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.repository.MongoRepository;

import javax.management.Query;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Queue;

@SpringBootApplication
public class MongoDbApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongoDbApplication.class, args);
    }


    @Bean
    CommandLineRunner runner(StudentRepository repository, MongoRepository mongoRepository){
        return args -> {
            Address address = new Address(
                    "us",
                    "irvine",
                    "92612"
            );
            Student student = new Student(
                    "James",
                    "Shen",
                    "jamesshen@gmail.com",
                    Gender.MALE,
                    address,
                    List.of("Computer Science","Math"),
                    BigDecimal.TEN,
                    LocalDateTime.now()
            );


            repository.insert(student);
        };
    }
}
