package de.jonashackt.springbootvuejs.repository;

import de.jonashackt.springbootvuejs.model.Message;
import de.jonashackt.springbootvuejs.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findAllByAuthor(User user);
}
