package com.example.wines.service.impl;

import com.example.wines.mapper.WineMapper;
import com.example.wines.pojo.Wines;


import com.example.wines.service.WineService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WineServiceImpl implements WineService {
  @Autowired
  private WineMapper wineMapper;
  private PageInfo<Wines> pageInfo;
  @Override
  public List<Wines> findAllWines() {
    return wineMapper.selectAll();
    //return null;
  }

  @Override
  public List<Wines> findWinesByPage(Integer pageNum, Integer pageSize) {
    PageHelper.startPage(pageNum,pageSize);
    List<Wines> winesList=wineMapper.selectAll();
    this.pageInfo=new PageInfo<>(winesList);
    return winesList;

  }

  @Override
  public Integer getCurrentNumber(){
    return this.pageInfo.getPageNum();
  }

  @Override
  public Integer getAllPageNumber() {
    return this.pageInfo.getPages();
  }

  @Override
  public Wines getWinesByTitle(String wineTitle) {
    return wineMapper.selectWinesByWineTitle(wineTitle);
  }
}
