package aiss.videoMiner.controllers;

import aiss.videoMiner.model.Caption;
import aiss.videoMiner.repository.CaptionRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Captions", description = "Captions management API")

@RestController
@RequestMapping("/videominer/captions")
public class CaptionController {

    @Autowired
    CaptionRepository captionRepository;

    @Operation(
            summary = "Retrive a list of captions",
            description = "Get a list of captions",
            tags = {"captions", "get"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "List of captions", content = {@Content(schema = @Schema(implementation = Caption.class),
                    mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Captions not found", content = {@Content(schema = @Schema())})
    })

    @GetMapping
    public List<Caption> findAll(){
        return captionRepository.findAll();
    }

    @Operation(
            summary = "Retrive a captions by id",
            description = "Get a captions specifying its id",
            tags = {"captions", "get"}
    )

    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = Caption.class),
                    mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())})
    })

    @GetMapping("/{id}")
    public Caption findOne(@PathVariable String id){
        return captionRepository.findById(id).get();
    }

}
