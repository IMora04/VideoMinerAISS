package aiss.videoMiner.controllers;

import aiss.videoMiner.model.Caption;
import aiss.videoMiner.repository.CaptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/videominer/captions")
public class CaptionController {

    @Autowired
    CaptionRepository repository;

    @GetMapping
    public List<Caption> findAllCaptions(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Caption findOneCaption(@PathVariable String id){
        return repository.findById(id).get();
    }
}
