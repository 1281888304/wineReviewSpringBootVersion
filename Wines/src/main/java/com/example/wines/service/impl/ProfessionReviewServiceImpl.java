package com.example.wines.service.impl;

import com.example.wines.mapper.ProfessionalReviewsMapper;
import com.example.wines.pojo.ProfessionalReviews;
import com.example.wines.service.ProfessionReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessionReviewServiceImpl implements ProfessionReviewService {

  @Autowired
  private ProfessionalReviewsMapper professionalReviewsMapper;
  @Override
  public ProfessionalReviews findReviewByWineTitle(String wineTitle) {
    return professionalReviewsMapper.findReviewByWineTitle(wineTitle);
  }
}
