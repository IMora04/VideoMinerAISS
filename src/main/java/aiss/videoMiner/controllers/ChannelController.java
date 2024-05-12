package aiss.videoMiner.controllers;

import aiss.videoMiner.model.Channel;
import aiss.videoMiner.repository.ChannelRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Content;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "Channel", description = "Channel management API")
@RestController
@RequestMapping("/videominer/channels")
public class ChannelController {

    @Autowired
    ChannelRepository channelRepository;

    @Operation(
            summary = "Retrive a list of channels",
            description = "Get a list of channels",
            tags = {"channel", "get"}
    )

    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "List of channels", content = {@Content(schema = @Schema(implementation = Channel.class),
                    mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Channel not found", content = {@Content(schema = @Schema())})
    })

    @GetMapping
    public List<Channel> findAll() {
        return channelRepository.findAll();
    }

    @Operation(
            summary = "Retrive a channel by id",
            description = "Get a channel object specifying its id",
            tags = {"channel", "get"}
    )

    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = Channel.class),
                    mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())})
    })

    @GetMapping("/{id}")
    public Channel findOne(@PathVariable String id) {
        return channelRepository.findById(id).get();
    }
    @Operation(
            summary = "Create a new channel",
            description = "Creates a new channel and saves it to the database.",
            tags = {"channel", "create"}
    )

    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Channel created successfully", content = {@Content(schema = @Schema(implementation = Channel.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Invalid channel data provided", content = {@Content(schema = @Schema())})
    })

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Channel createVideo(@Valid @RequestBody Channel channel) {
        return channelRepository.save(channel);
    }
    @Operation(
            summary = "Deletes a channel",
            description = "Deletes a channel by its ID",
            tags = {"channel", "delete"}
    )

    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Channel deleted successfully", content = {@Content(schema = @Schema(implementation = Channel.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Channel not found", content = {@Content(schema = @Schema())}),
    })
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        if(channelRepository.existsById(id)){
            channelRepository.deleteById(id);
        }
    }
    @Operation(
            summary = "Update a channel",
            description = "Updates the details of an existing channel by its ID.",
            tags = {"channel", "update"}
    )

    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Channel updated successfully", content = {@Content(schema = @Schema(implementation = Channel.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Invalid input, object invalid", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "404", description = "Channel not found", content = {@Content(schema = @Schema())}),
    })

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
