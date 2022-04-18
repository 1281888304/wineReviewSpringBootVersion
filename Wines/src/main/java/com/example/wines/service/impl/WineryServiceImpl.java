package com.example.wines.service.impl;

import com.example.wines.mapper.WineryMapper;
import com.example.wines.pojo.Winery;
import com.example.wines.pojo.Wines;
import com.example.wines.service.WineryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WineryServiceImpl implements WineryService {

  private PageInfo<Wines> winesPageInfo;
  private PageInfo<Winery> wineryPageInfo;

  @Autowired
  private WineryMapper wineryMapper;

  @Override
  public List<Winery> findAllWinesByPage(Integer pageNum, Integer pageSize) {
    PageHelper.startPage(pageNum,pageSize);
    List<Winery> wineryList=wineryMapper.selectAllWinery();
    this.wineryPageInfo=new PageInfo<>(wineryList);
    return wineryList;

  }

  @Override
  public List<Wines> findWinesByWinery(String wineryName,Integer pageNum, Integer pageSize) {
    PageHelper.startPage(pageNum,pageSize);

    List<Wines> winesList=wineryMapper.selectWinesByWinery(wineryName);
    this.winesPageInfo=new PageInfo<>(winesList);
    return winesList;
  }

  @Override
  public PageInfo<Wines> getWinesPageInto() {
    return this.winesPageInfo;
  }

  @Override
  public PageInfo<Winery> getWineryPageInfo() {
    return this.wineryPageInfo;
  }

  @Override
  public Integer getWineryListCurrentPage() {
    return this.wineryPageInfo.getPageNum();
  }

  @Override
  public Integer getWineryListTotalPage() {
    return this.wineryPageInfo.getPages();
  }

  @Override
  public Integer getWineListCurrentPage() {
    return this.winesPageInfo.getPageNum();
  }

  @Override
  public Integer getWWineListTotalPage() {
    return this.winesPageInfo.getPages();
  }



}
