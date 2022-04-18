package com.example.wines.service.impl;

import com.example.wines.mapper.ProfessionalWineReviewMapper;
import com.example.wines.pojo.ProfessionalWineReview;
import com.example.wines.service.ProfessionWineReviewService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessionWineReviewServiceImpl implements ProfessionWineReviewService {

    @Autowired
    private ProfessionalWineReviewMapper professionalWineReviewMapper;

    public List<ProfessionalWineReview> all(){
      return professionalWineReviewMapper.selectAll();
    }

  @Override
  public ProfessionalWineReview findByTitle(String wineTitle) {
    return professionalWineReviewMapper.findByTitle(wineTitle);
  }

}
