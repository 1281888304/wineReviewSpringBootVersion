package com.example.wines.service.impl;

import com.example.wines.mapper.UserReviewMapper;
import com.example.wines.pojo.UserReview;
import com.example.wines.service.UserReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserReviewServiceImpl implements UserReviewService {
  @Autowired
  private UserReviewMapper userReviewMapper;

  @Override
  public UserReview findReviewByTitle(String wineTItle) {
    UserReview userReview=userReviewMapper.selectReviewByTitle(wineTItle);
    return userReview;
  }

  @Override
  public int addReview(UserReview userReview) {
    int res=userReviewMapper.insertReview(userReview);
    return res;
  }
}
