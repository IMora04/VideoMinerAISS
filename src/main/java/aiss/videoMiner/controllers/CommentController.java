package aiss.videoMiner.controllers;

import aiss.videoMiner.model.Comment;
import aiss.videoMiner.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/videominer/comments")
public class CommentController {

    @Autowired
    CommentRepository repository;

    @GetMapping
    public List<Comment> findAllComments(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Comment getComment(@PathVariable String id){
        return repository.findById(id).get();
    }
}
