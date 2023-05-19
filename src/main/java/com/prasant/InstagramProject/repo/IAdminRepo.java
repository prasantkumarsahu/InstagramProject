package com.prasant.InstagramProject.repo;

import com.prasant.InstagramProject.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdminRepo extends JpaRepository<Admin, Long> {
}
