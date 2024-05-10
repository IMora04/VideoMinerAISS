package aiss.videoMiner.controllers;

import aiss.videoMiner.model.Video;
import aiss.videoMiner.repository.VideoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/videominer/videos")
public class VideoController {

    @Autowired
    VideoRepository repository;

    @GetMapping
    public List<Video> findAllVideos() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Video findOneVideo(@PathVariable String id) {
        return repository.findById(id).get();
    }

}
