package de.jonashackt.springbootvuejs.repository;

import de.jonashackt.springbootvuejs.model.Message;
import de.jonashackt.springbootvuejs.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends MongoRepository<Message, Long> {
    List<Message> findAllByAuthor(User user);
}
