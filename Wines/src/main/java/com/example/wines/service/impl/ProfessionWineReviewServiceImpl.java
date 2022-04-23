package com.example.wines.service.impl;

import com.example.wines.mapper.ProfessionalWineReviewMapper;
import com.example.wines.pojo.ProfessionalWineReview;
import com.example.wines.service.ProfessionWineReviewService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessionWineReviewServiceImpl implements ProfessionWineReviewService {

    @Autowired
    private ProfessionalWineReviewMapper professionalWineReviewMapper;
    private PageInfo<ProfessionalWineReview> pageInfo;

    public List<ProfessionalWineReview> all(){
      return professionalWineReviewMapper.selectAll();
    }

    @Override
    public ProfessionalWineReview findByTitle(String wineTitle) {
      return professionalWineReviewMapper.findByTitle(wineTitle);
    }

  @Override
  public List<ProfessionalWineReview> findByFilter(String filter,int pageNum,int pageSize) {
    PageHelper.startPage(pageNum,pageSize);
    System.out.println("service filter-->"+filter);
    List<ProfessionalWineReview> list=professionalWineReviewMapper.selectWithOrder(filter);
    this.pageInfo=new PageInfo<>(list);
    return  list;
  }

  @Override
  public List<ProfessionalWineReview> findCountryOnly() {
    return professionalWineReviewMapper.selectCountry();
  }

  @Override
  public PageInfo<ProfessionalWineReview> getPageInfo() {
    return this.pageInfo;
  }

}
