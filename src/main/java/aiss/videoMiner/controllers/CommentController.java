package aiss.videoMiner.controllers;

import aiss.videoMiner.model.Comment;
import aiss.videoMiner.model.Video;
import aiss.videoMiner.repository.CommentRepository;
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

@Tag(name = "Comments", description = "Comments management API")
@RestController
@RequestMapping("/videominer/comments")
public class CommentController {

    @Autowired
    CommentRepository commentRepository;


    @Operation(
            summary = "Retrive a list of comments",
            description = "Get a list of comments",
            tags = {"comments", "get"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "List of comments", content = {@Content(schema = @Schema(implementation = Comment.class),
                    mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Comments not found", content = {@Content(schema = @Schema())})
    })
    @GetMapping
    public List<Comment> findAll(){
        return commentRepository.findAll();
    }

    @Operation(
            summary = "Retrive a specified comment",
            description = "Get a comment",
            tags = {"comments", "get"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Retrieve a comment", content = {@Content(schema = @Schema(implementation = Comment.class),
                    mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Comment not found", content = {@Content(schema = @Schema())})
    })
    @GetMapping("/{id}")
    public Comment findOne(@PathVariable String id){
        return commentRepository.findById(id).get();
    }

}
