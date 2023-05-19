package com.prasant.InstagramProject.repo;

import com.prasant.InstagramProject.model.InstagramComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICommentRepo extends JpaRepository<InstagramComment, Long> {
}
