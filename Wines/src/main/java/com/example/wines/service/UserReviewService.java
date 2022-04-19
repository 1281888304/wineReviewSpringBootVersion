package com.example.wines.service;

import com.example.wines.pojo.UserReview;

public interface UserReviewService {
    UserReview findReviewByTitle(String wineTItle);
    int addReview(UserReview userReview);

}
