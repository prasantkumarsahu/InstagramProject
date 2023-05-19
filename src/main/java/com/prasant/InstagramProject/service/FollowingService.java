package com.prasant.InstagramProject.service;

import com.prasant.InstagramProject.model.InstagramFollowing;
import com.prasant.InstagramProject.model.User;
import com.prasant.InstagramProject.repo.IFollowingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowingService {

    @Autowired
    IFollowingRepo followingRepo;

    public void saveFollowing(User myUser, User otherUser) {
        InstagramFollowing followingRecord = new InstagramFollowing(null,myUser,otherUser);
        followingRepo.save(followingRecord);
    }
}
