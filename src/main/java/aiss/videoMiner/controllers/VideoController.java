package aiss.videoMiner.controllers;

import aiss.videoMiner.model.Video;
import aiss.videoMiner.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/videominer/videos")
public class VideoController {

    @Autowired
    VideoRepository videoRepository;

    @GetMapping
    public List<Video> findAll() {
        return videoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Video findOne(@PathVariable String id) {
        return videoRepository.findById(id).get();
    }

}
