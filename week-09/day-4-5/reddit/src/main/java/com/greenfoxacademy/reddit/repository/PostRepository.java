package com.greenfoxacademy.reddit.repository;

import com.greenfoxacademy.reddit.model.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


@Repository
public interface PostRepository extends PagingAndSortingRepository<Post, Long> {
    Post findPostByIdEquals(long id);
    List<Post> findAllByOrderByRatingDesc(Pageable pageable);

    @Transactional
    @Modifying
    @Query("UPDATE Post p SET p.rating = p.rating+1, p.dateModified = :date WHERE p.id = :id")
    int upVote(@Param("id") long id, @Param("date") Date date);

    @Transactional
    @Modifying
    @Query("UPDATE Post p SET p.rating = p.rating-1, p.dateModified = :date WHERE p.id = :id AND p.rating>-10")
    int downVote(@Param("id") long id, @Param("date") Date date);

    /*@Query("FROM Post p ORDER BY p.rating DESC")
    List<Post> orderedPosts();*/

}
