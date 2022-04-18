package com.example.wines.controller;

import com.example.wines.pojo.Wines;
import com.example.wines.service.WineryService;
import com.example.wines.service.impl.ProfessionWineReviewServiceImpl;
import com.example.wines.service.WineService;
import com.github.pagehelper.PageInfo;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/wine")
public class WinesController {
  @Autowired
  private WineService wineService;
  @Autowired
  private WineryService wineryService;

  private Integer winesPerPage=6;

  @Autowired
  private ProfessionWineReviewServiceImpl professionWineReviewServiceImpl;



  @RequestMapping("")
  //@ResponseBody
  public String allWines(){
    return "redirect:/wine/allWines/1";

  }

  @RequestMapping("/findWinesByPage/{pageNum}")
  @ResponseBody
  public List<Wines> allWines(@PathVariable("pageNum") Integer pageNum,@PathVariable("pageSize") Integer pageSize,
      Map<String,Object> map){
    return wineService.findWinesByPage(pageNum, this.winesPerPage);


  }

  @RequestMapping("/allWines/{pageNum}")
  public String allWinesWeb(@PathVariable("pageNum") Integer pageNum,Map<String,Object> map){
    //return wineService.findAllWines();
    List<Wines> winesByPage = wineService.findWinesByPage(pageNum, this.winesPerPage);
    map.put("wineList",winesByPage);
    Integer currentPage=wineService.getCurrentNumber();
    Integer totalPages=wineService.getAllPageNumber();
    map.put("currentPage",currentPage);
    map.put("totalPage",totalPages);
    PageInfo<Wines> pageInfo=wineryService.getWinesPageInto();
    map.put("pageInfo",pageInfo);
    boolean isFirstPage=false;
    if(currentPage==1){
      isFirstPage=true;
    }
    map.put("isFirstPage",isFirstPage);
    return "wines";

  }

  @RequestMapping("/nextPage")
  public String nextPage(){
    Integer curPage=wineService.getCurrentNumber();
    Integer nextPage=curPage+1;
    return "redirect:/wine/allWines/"+nextPage;
  }

  @RequestMapping("/prevPage")
  public String prevPage(){
    Integer curPage=wineService.getCurrentNumber();
    Integer prevPage=curPage-1;
    if(prevPage<=0)
      prevPage=1;
    return "redirect:/wine/allWines/"+prevPage;
  }

  /**
   * page by winery
   */
  @RequestMapping("/{wineryName}/{pageNum}")
  public String winesByWinery(@PathVariable("wineryName") String wineryName,
      @PathVariable("pageNum") Integer pageNum,Map<String,Object> map){
    List<Wines> winesByWinery = wineryService.findWinesByWinery(wineryName, pageNum, winesPerPage);
    map.put("wineList",winesByWinery);
    Integer currentPage=wineryService.getWineListCurrentPage();
    Integer totalPages=wineryService.getWWineListTotalPage();
    System.out.println("Wines by winery current page=>"+currentPage+" total page->"+totalPages);
    map.put("currentPage",currentPage);
    map.put("totalPage",totalPages);
    boolean isFirstPage=false;
    if(currentPage==1){
      isFirstPage=true;
    }
    PageInfo<Wines> pageInfo=wineryService.getWinesPageInto();
    map.put("pageInfo",pageInfo);
    map.put("isFirstPage",isFirstPage);
    String currentWinery=wineryName;
    map.put("currentWinery",wineryName);
    return "wineByWinery";

  }

  /**
   * wines by winery page next page and prev page
   */
  @RequestMapping("/wineryNext/{currentWinery}/{currentPage}")
  public String wineryNextPage(@PathVariable("currentWinery") String currentWinery,
      @PathVariable("currentPage") Integer currentPage){
    Integer nextPageNum=currentPage+1;
    String wineryName=currentWinery;
    return "redirect:/wine/"+wineryName+"/"+nextPageNum;

  }

  /**
   * Search winery by form input
   */
  @PostMapping("/searchWinery")
  public String searchWines(String winery){
    String wineryName=winery;
    System.out.println("WineryName: "+wineryName);
    return "redirect:/wine/"+wineryName+"/1";
  }

  /**
   *search wines by wine title
   */
  @PostMapping("/searchWine")
  public String searchWinesByWineTitle(String wineTitle){


    return "redirect:/detail/"+wineTitle;
  }


}
