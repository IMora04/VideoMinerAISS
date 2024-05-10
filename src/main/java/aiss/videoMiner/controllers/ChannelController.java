package aiss.videoMiner.controllers;

import aiss.videoMiner.model.Channel;
import aiss.videoMiner.repository.ChannelRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/videominer/channels")
public class ChannelController {

    @Autowired
    ChannelRepository channelRepository;

    @GetMapping
    public List<Channel> findAll() {
        return channelRepository.findAll();
    }

    @GetMapping("/{id}")
    public Channel findOne(@PathVariable String id) {
        return channelRepository.findById(id).get();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Channel createVideo(@Valid @RequestBody Channel channel) {
        return channelRepository.save(channel);
    }

}
