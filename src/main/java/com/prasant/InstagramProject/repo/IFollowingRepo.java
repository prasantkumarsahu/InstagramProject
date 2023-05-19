package com.prasant.InstagramProject.repo;

import com.prasant.InstagramProject.model.InstagramFollowing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFollowingRepo extends JpaRepository<InstagramFollowing, Long> {
    Long countByUser_userId(long userId);
}
