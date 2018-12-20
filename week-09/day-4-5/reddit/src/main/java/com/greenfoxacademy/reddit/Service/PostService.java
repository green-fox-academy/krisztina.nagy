package com.greenfoxacademy.reddit.Service;

import com.greenfoxacademy.reddit.model.Post;
import com.greenfoxacademy.reddit.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    PostRepository repo;

    @Autowired
    public PostService (PostRepository repo) {
        this.repo = repo;
    }

    public void addPost(Post post) {
        if (post !=null) {
            this.repo.save(post);
        }
    }

    public List<Post> getAll() {
        List<Post> posts = new ArrayList<>();
        repo.findAll().forEach(posts::add);
        //repository.findAll().forEach(todo -> todos.add(todo));
        return posts;
    }
}
