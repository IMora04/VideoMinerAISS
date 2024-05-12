package aiss.videoMiner.controllers;

import aiss.videoMiner.model.Channel;
import aiss.videoMiner.repository.ChannelRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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


    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        if(channelRepository.existsById(id)){
            channelRepository.deleteById(id);
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@Valid @RequestBody Channel updatedChannel, @PathVariable String id){
        Optional<Channel> channelData = channelRepository.findById(id);

        Channel _channel = channelData.get();
        _channel.setName(updatedChannel.getName());
        _channel.setDescription(updatedChannel.getDescription());
        _channel.setVideos(updatedChannel.getVideos());
        channelRepository.save(_channel);
    }

}
