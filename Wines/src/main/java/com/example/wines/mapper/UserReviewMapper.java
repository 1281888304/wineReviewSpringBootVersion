package com.example.wines.mapper;

import com.example.wines.pojo.UserReview;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserReviewMapper {
  int insertReview(UserReview userReview);

  UserReview selectReviewByTitle(@Param("wineTitle") String wineTitle);

}
