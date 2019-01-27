package ru.javathon.springbootvuejs.repository;

import ru.javathon.springbootvuejs.model.Message;
import ru.javathon.springbootvuejs.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends MongoRepository<Message, Long> {
    List<Message> findAllByAuthor(User user);
}
