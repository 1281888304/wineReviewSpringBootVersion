package com.example.wines.mapper;

import com.example.wines.pojo.ProfessionalReviews;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProfessionalReviewsMapper {
  ProfessionalReviews findReviewByWineTitle(@Param("wineTitle") String wineTitle);

}
