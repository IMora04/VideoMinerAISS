package aiss.videoMiner.controllers;

import aiss.videoMiner.model.Channel;
import aiss.videoMiner.model.Video;
import aiss.videoMiner.repository.ChannelRepository;
import aiss.videoMiner.repository.VideoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/videominer/channels")
public class ChannelController {

    @Autowired
    ChannelRepository repository;

    @GetMapping
    public List<Channel> findAllChannels() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Channel findOneChannel(@PathVariable String id) {
        return repository.findById(id).get();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Channel createVideo(@Valid @RequestBody Channel channel) {
        return repository.save(channel);
    }


}
