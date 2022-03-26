package com.CEN4010GROUP22.GeekText.comments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentsController {
    
    private final CommentsService commentService;

    @Autowired
    public CommentsController(CommentsService commentService){
        this.commentService = commentService;
    }

    @GetMapping(path = "comments")
    public List<Comments> getComments(){
        System.out.println("GET Request for comments is successful.");

        return commentService.getComments(); // returns all comments currently in database
    }

    @PostMapping(path = "comments")
    public void addNewComment(@RequestBody Comments comment){
        System.out.println("\nRequest body: " + comment + "\n");

        commentService.addNewComment(comment);
    }
}