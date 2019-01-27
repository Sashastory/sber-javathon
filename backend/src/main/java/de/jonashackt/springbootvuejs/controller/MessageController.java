package de.jonashackt.springbootvuejs.controller;

import de.jonashackt.springbootvuejs.exeption.NotFoundException;
import de.jonashackt.springbootvuejs.model.Message;
import de.jonashackt.springbootvuejs.model.User;
import de.jonashackt.springbootvuejs.repository.MessageRepository;
import de.jonashackt.springbootvuejs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("messages")
public class MessageController {
    private final MessageRepository messageRepo;
    private final UserRepository userRepo;

    @Autowired
    public MessageController(MessageRepository messageRepo, UserRepository userRepo) {
        this.messageRepo = messageRepo;
        this.userRepo = userRepo;
    }

    @GetMapping()
    public List<Message> getMessages() {
        return messageRepo.findAll();
    }

    @GetMapping("{id}")
    public List<Message> getUserMessages(@PathVariable String id) {
        Optional<User> user = userRepo.findById(id);
        if(user.isPresent()) {
            return messageRepo.findAllByAuthor(user.get());
        } else {
            throw new NotFoundException();
        }
    }

    @PostMapping("{id}")
    public Message create(@PathVariable String id, @RequestBody String text) {
        Optional<User> user = userRepo.findById(id);
        if(user.isPresent()) {
            Message message = new Message();
            message.setText(text);
            message.setCreationDate(LocalDateTime.now());
            message.setAuthor(user.get());
            return messageRepo.save(message);
        } else {
            throw new NotFoundException();
        }
    }

//    @PutMapping("{id}")   "105635520198681059963"
//    public Message update(
//            @PathVariable("id") Message messageFromDb,
//            @RequestBody Message message
//    ) {
//        BeanUtils.copyProperties(message, messageFromDb, "id");
//
//        return messageRepo.save(messageFromDb);
//    }
//
//    @DeleteMapping("{id}")
//    public void delete(@PathVariable("id") Message message) {
//        messageRepo.delete(message);
//    }
}
