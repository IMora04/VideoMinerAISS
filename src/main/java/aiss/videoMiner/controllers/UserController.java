package aiss.videoMiner.controllers;

import aiss.videoMiner.model.User;
import aiss.videoMiner.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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
@Tag(name = "User", description = "User management API")
@RestController
@RequestMapping("/videominer/users")
public class UserController {

    @Autowired
    UserRepository userRepository;
    @Operation(
            summary = "Retrive a list of users",
            description = "Get a list of users",
            tags = {"users", "get"}
    )

    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "List of users", content = {@Content(schema = @Schema(implementation = User.class),
                    mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "User not found", content = {@Content(schema = @Schema())})
    })

    @GetMapping
    public List<User> findAll(){
        return userRepository.findAll();
    }

    @Operation(
            summary = "Retrive a user by id",
            description = "Get a user object specifying its id",
            tags = {"user", "get"}
    )

    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = User.class),
                    mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())})
    })

    @GetMapping("/{id}")
    public User findOne(@Parameter(description = "id of the user to be searched")@PathVariable String id){
        return userRepository.findById(id).get();
    }

}
