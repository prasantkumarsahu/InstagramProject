package com.prasant.InstagramProject.repo;

import com.prasant.InstagramProject.model.InstagramFollower;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFollowerRepo extends JpaRepository<InstagramFollower, Long> {
}
