package com.example.wines.service;

import com.example.wines.pojo.Wines;
import java.util.List;

public interface WineService {

  List<Wines> findAllWines();
  List<Wines> findWinesByPage(Integer pageNum,Integer pageSize);
  Integer getCurrentNumber();
  Integer getAllPageNumber();
  Wines getWinesByTitle(String wineTitle);
}
