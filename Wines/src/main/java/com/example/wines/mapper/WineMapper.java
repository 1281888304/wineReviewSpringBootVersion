package com.example.wines.mapper;

import com.example.wines.pojo.ProfessionalWineReview;
import com.example.wines.pojo.Wines;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface WineMapper {

  List<Wines> selectAll();
  Wines selectWinesByWineTitle(@Param("wineTitle") String wineTitle);
}
