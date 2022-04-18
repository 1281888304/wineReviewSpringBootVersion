package com.example.wines.mapper;

import com.example.wines.pojo.Location;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LocationsMapper {
  Location findLocationByWines(@Param("wineTitle") String wineTitle);

}
