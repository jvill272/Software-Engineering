package com.CEN4010GROUP22.GeekText.comments;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsRepository extends JpaRepository<Comments, CommentsId> {
    
    List<Comments> findCommentByCommenterNameAndBookName(String fk_book_commenter, String fk_bname);
}