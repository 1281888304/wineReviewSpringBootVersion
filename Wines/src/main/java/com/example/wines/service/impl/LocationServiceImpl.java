package com.example.wines.service.impl;

import com.example.wines.mapper.LocationsMapper;
import com.example.wines.pojo.Location;
import com.example.wines.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService {

  @Autowired
  private LocationsMapper locationsMapper;

  @Override
  public Location findLocationByWineTitle(String wineTitle) {
    return locationsMapper.findLocationByWines(wineTitle);
  }
}
