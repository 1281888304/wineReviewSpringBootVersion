package com.example.wines.service.impl;

import com.example.wines.mapper.ProfessionalRatingsMapper;
import com.example.wines.pojo.ProfessionalRatings;
import com.example.wines.service.ProfessionRattingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessionRattingServiceImpl implements ProfessionRattingService {
  @Autowired
  private ProfessionalRatingsMapper professionalRatingsMapper;

  @Override
  public ProfessionalRatings findRatingByWineTitle(String wineTitle) {
    return professionalRatingsMapper.selectRatingByWineTitle(wineTitle);
  }
}
