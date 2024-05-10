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
    CommentRepository commentRepository;

    @GetMapping
    public List<Comment> findAll(){
        return commentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Comment findOne(@PathVariable String id){
        return commentRepository.findById(id).get();
    }

}
