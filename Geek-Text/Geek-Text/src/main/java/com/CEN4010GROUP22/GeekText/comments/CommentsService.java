package com.CEN4010GROUP22.GeekText.comments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentsService {
    
    @Autowired
    private final CommentsRepository commentRepository;

    @Autowired
    public CommentsService(CommentsRepository commentRepository){
        this.commentRepository = commentRepository;
    }

    // method to obtain all current comments in database
    public List<Comments> getComments(){
        return commentRepository.findAll();
    }

    // method to add a new comment(used by POST mapping in Controller)
    public void addNewComment(Comments comment){
        String commenter = comment.getCommenterName();
        String book = comment.getBookName();
        System.out.println("Commenter: " + commenter + "\nBook: " + book + "\n");

        List<Comments> commentSearched = commentRepository.findCommentByCommenterNameAndBookName(commenter, book);

        System.out.println("commentSearched: " + commentSearched);

        if(!commentSearched.isEmpty()){
            System.out.println("\nA comment for " + book + " from " + commenter + " already exists. The new comment will not be saved.\n");
        
            // end method because a comment for this commenter + book PK combination already exists -> should not be saved
            return;
        }

        // comment from the current (commenter, bookName) combination PK does not exist yet -> save the comment to database
        commentRepository.save(comment);
        System.out.println("\nNew comment saved to database.");
    }
}