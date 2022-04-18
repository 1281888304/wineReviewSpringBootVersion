package com.example.wines.service;

import com.example.wines.pojo.ProfessionalWineReview;
import java.util.List;

public interface ProfessionWineReviewService {
  List<ProfessionalWineReview> all();
  ProfessionalWineReview findByTitle(String wineTitle);

}
