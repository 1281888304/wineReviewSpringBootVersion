package com.example.wines.service;

import com.example.wines.pojo.Location;

public interface LocationService {
  Location findLocationByWineTitle(String wineTitle);

}
