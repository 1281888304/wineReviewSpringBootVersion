package com.example.wines.mapper;

import com.example.wines.pojo.Winery;
import com.example.wines.pojo.Wines;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface WineryMapper {
  List<Wines> selectWinesByWinery(@Param("wineryName") String wineryName);
  List<Winery> selectAllWinery();


}
