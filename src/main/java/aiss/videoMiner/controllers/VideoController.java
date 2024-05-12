package aiss.videoMiner.controllers;

import aiss.videoMiner.model.Caption;
import aiss.videoMiner.model.Video;
import aiss.videoMiner.repository.VideoRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Tag(name = "Videos", description = "Videos management API")
@RestController
@RequestMapping("/videominer/videos")
public class VideoController {

    @Autowired
    VideoRepository videoRepository;

    @Operation(
            summary = "Retrive a list of videos",
            description = "Get a list of videos",
            tags = {"videos", "get"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "List of videos", content = {@Content(schema = @Schema(implementation = Video.class),
                    mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Videos not found", content = {@Content(schema = @Schema())})
    })
    @GetMapping
    public List<Video> findAll() {
        return videoRepository.findAll();
    }


    @Operation(
            summary = "Retrive a video with this Id",
            description = "Get the video with the Id specified",
            tags = {"videos", "get"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Video specified", content = {@Content(schema = @Schema(implementation = Video.class),
                    mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Video not found", content = {@Content(schema = @Schema())})
    })
    @GetMapping("/{id}")
    public Video findOne(@PathVariable String id) {
        return videoRepository.findById(id).get();
    }

}
