package com.example.wines.service;

import com.example.wines.pojo.ProfessionalWineReview;
import com.github.pagehelper.PageInfo;
import java.util.List;

public interface ProfessionWineReviewService {
  List<ProfessionalWineReview> all();
  ProfessionalWineReview findByTitle(String wineTitle);
  List<ProfessionalWineReview> findByFilter(String filter,int pageNum,int pageSize);
  List<ProfessionalWineReview> findCountryOnly();
  PageInfo<ProfessionalWineReview> getPageInfo();
}
