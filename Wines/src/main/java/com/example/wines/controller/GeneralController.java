package com.example.wines.controller;

import com.example.wines.pojo.Location;
import com.example.wines.pojo.ProfessionalRatings;
import com.example.wines.pojo.ProfessionalReviews;
import com.example.wines.pojo.ProfessionalWineReview;
import com.example.wines.pojo.UserReview;
import com.example.wines.pojo.Wines;
import com.example.wines.service.LocationService;
import com.example.wines.service.ProfessionRattingService;
import com.example.wines.service.ProfessionReviewService;
import com.example.wines.service.ProfessionWineReviewService;
import com.example.wines.service.UserReviewService;
import com.example.wines.service.UserService;
import com.example.wines.service.WineService;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GeneralController {
  @Autowired
  private LocationService locationService;
  @Autowired
  private WineService wineService;
  @Autowired
  private ProfessionRattingService professionRattingService;
  @Autowired
  private ProfessionReviewService professionReviewService;
  @Autowired
  private ProfessionWineReviewService professionWineReviewService;
  @Autowired
  private UserService userService;
  @Autowired
  private UserReviewService userReviewService;

  @RequestMapping("/detail/{wineTitle}")
  public String getWinesDetailByTitle(@PathVariable("wineTitle") String wineTitle,
      Map<String,Object> map){
    Location location=locationService.findLocationByWineTitle(wineTitle);
    Wines wines=wineService.getWinesByTitle(wineTitle);
    ProfessionalRatings ratingByWineTitle = professionRattingService
        .findRatingByWineTitle(wineTitle);
    ProfessionalReviews professionalReviews=professionReviewService.findReviewByWineTitle(wineTitle);
    ProfessionalWineReview fullReview = professionWineReviewService.findByTitle(wineTitle);

    Integer point=ratingByWineTitle.getPoints();
    map.put("location",location);
    map.put("wine",wines);
    map.put("review",professionalReviews);
    map.put("rating",ratingByWineTitle);
    map.put("point",point);
    map.put("full",fullReview);

    //user review
    UserReview userReview=userReviewService.findReviewByTitle(wineTitle);
    map.put("userReview",userReview);
    boolean containsUserReview=false;
    if(userReview!=null){
      containsUserReview=true;
    }
    map.put("containsUserReview",containsUserReview);
    return "wineDetail";
  }

  @GetMapping("/user/hello")
  public String user(){

    return "redirect:/wine";
  }

  @GetMapping("/currentUser")
  @ResponseBody
  public String hello(){
    String currentUser= SecurityContextHolder.getContext().getAuthentication().getName();
    return currentUser;
  }

  @RequestMapping("/addReview/{wineTitle}")
  public String addReviewPage(@PathVariable("wineTitle") String wineTitle,Map<String,Object> map){
    String currentUser= SecurityContextHolder.getContext().getAuthentication().getName();
    map.put("wineTitle",wineTitle);
    map.put("currentUser",currentUser);
    return "add_review";

  }

  @PostMapping("/doAddReview")

  public String doAddReview(UserReview userReview){
    userReviewService.addReview(userReview);

    return "redirect:/detail/"+userReview.getWineTitle();

  }

  @PostMapping("/check")
  @ResponseBody
  public String checkAjax(@PathVariable("username") String username,HttpServletRequest req){
    System.out.println("from ajax ---->"+username);
    String username2=req.getParameter("username");
    System.out.println("from request ---->"+username);
    return "testAjax";
  }

  /**
   * 鼠标离开文本框判断用户是否输入
   * @param buyerName 身材名
   * @param request
   * @return
   * @throws Exception
   */
  @RequestMapping(value="/checkBuyerFigure",produces="text/html;charset=UTF-8")
  @ResponseBody
  public String checkBuyerFigure(
      String buyerName,
      HttpServletRequest request
  ) throws Exception{
    //msg 返回信息
    String msg = null;
    return "ok";
  }


}
