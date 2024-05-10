package aiss.videoMiner.controllers;

import aiss.videoMiner.model.User;
import aiss.videoMiner.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/videominer/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public List<User> findAll(){
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User findOne(@PathVariable String id){
        return userRepository.findById(id).get();
    }

}
