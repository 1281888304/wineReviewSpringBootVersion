package com.example.wines.service;

import com.example.wines.pojo.ProfessionalReviews;

public interface ProfessionReviewService {

  ProfessionalReviews findReviewByWineTitle(String wineTitle);
}
