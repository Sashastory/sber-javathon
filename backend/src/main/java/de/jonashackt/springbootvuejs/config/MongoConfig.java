package de.jonashackt.springbootvuejs.config;

import com.mongodb.MongoClient;
import de.jonashackt.springbootvuejs.repository.GeoJsonObjectRepository;
import de.jonashackt.springbootvuejs.repository.MessageRepository;
import de.jonashackt.springbootvuejs.repository.UserRepository;
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
