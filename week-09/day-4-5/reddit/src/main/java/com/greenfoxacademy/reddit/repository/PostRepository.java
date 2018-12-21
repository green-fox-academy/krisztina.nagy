package com.greenfoxacademy.reddit.repository;

import com.greenfoxacademy.reddit.model.Post;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
Post findPostByIdEquals(long id);

    @Transactional
    @Modifying
    @Query("UPDATE Post p SET p.rating = p.rating+1 WHERE p.id = :id")
    int upVote(@Param("id") long id);

    @Transactional
    @Modifying
    @Query("UPDATE Post p SET p.rating = p.rating-1 WHERE p.id = :id AND p.rating>-10")
    int downVote(@Param("id") long id);

}
