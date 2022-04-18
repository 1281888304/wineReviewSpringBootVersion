package com.example.wines.service;

import com.example.wines.pojo.Winery;
import com.example.wines.pojo.Wines;
import com.github.pagehelper.PageInfo;
import java.util.List;

public interface WineryService {

  List<Winery> findAllWinesByPage(Integer pageNum, Integer pageSize);
  List<Wines> findWinesByWinery(String wineryName,Integer pageNum, Integer pageSize);
  PageInfo<Wines> getWinesPageInto();
  PageInfo<Winery> getWineryPageInfo();
  Integer getWineryListCurrentPage();
  Integer getWineryListTotalPage();
  Integer getWineListCurrentPage();
  Integer getWWineListTotalPage();
}
