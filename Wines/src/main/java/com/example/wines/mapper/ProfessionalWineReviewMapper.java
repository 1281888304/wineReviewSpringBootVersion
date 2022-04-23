package com.example.wines.mapper;

import com.example.wines.pojo.ProfessionalWineReview;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProfessionalWineReviewMapper {

  List<ProfessionalWineReview> selectAll();
  ProfessionalWineReview findByTitle(@Param("wineTitle") String wineTitle);
  List<ProfessionalWineReview> selectWithOrder(@Param("filter") String filter);
  List<ProfessionalWineReview> selectCountry();

}
