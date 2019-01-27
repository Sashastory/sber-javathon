package ru.javathon.springbootvuejs.config;

import com.mongodb.MongoClient;
import ru.javathon.springbootvuejs.repository.GeoJsonObjectRepository;
import ru.javathon.springbootvuejs.repository.MessageRepository;
import ru.javathon.springbootvuejs.repository.UserRepository;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackageClasses = { UserRepository.class, MessageRepository.class, GeoJsonObjectRepository.class})
public class MongoConfig {
    @Bean
    public MongoClient mongo(final MongoProperties mongoProperties) {
        return new MongoClient(mongoProperties.getHost(), mongoProperties.getPort());
    }

    @Bean
    public MongoTemplate mongoTemplate(final MongoProperties mongoProperties) throws Exception {
        return new MongoTemplate(mongo(mongoProperties), mongoProperties.getDatabase());
    }
}
