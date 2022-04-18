package com.example.wines.mapper;

import com.example.wines.pojo.ProfessionalRatings;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProfessionalRatingsMapper {

  ProfessionalRatings selectRatingByWineTitle(@Param("wineTitle") String wineTitle);
}
