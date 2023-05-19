package com.prasant.InstagramProject.repo;

import com.prasant.InstagramProject.model.Post;
import com.prasant.InstagramProject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPostRepo extends JpaRepository<Post, Integer> {
    List<Post> findByUser(User user);

}
