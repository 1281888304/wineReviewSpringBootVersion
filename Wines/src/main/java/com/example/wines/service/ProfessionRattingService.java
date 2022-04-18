package com.example.wines.service;

import com.example.wines.pojo.ProfessionalRatings;

public interface ProfessionRattingService {
  ProfessionalRatings findRatingByWineTitle(String wineTitle);

}
