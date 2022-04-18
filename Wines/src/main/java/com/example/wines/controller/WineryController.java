package com.example.wines.controller;


import com.example.wines.pojo.Winery;
import com.example.wines.service.WineService;
import com.example.wines.service.WineryService;
import com.github.pagehelper.PageInfo;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/winery")
public class WineryController {

  private Integer pageSize=6;

  @Autowired
  private WineryService wineryService;

  @GetMapping("")
  public String welcomeWineryPage(){
    return "redirect:/winery/allWinery/1";
  }

  @GetMapping("/allWinery/{pageNum}")
  public String allWinery(@PathVariable("pageNum") Integer pageNum, Map<String,Object> map){
    List<Winery> wineryList=wineryService.findAllWinesByPage(pageNum,pageSize);
    map.put("wineryList",wineryList);
    Integer currentPage=wineryService.getWineryListCurrentPage();
    Integer totalPage=wineryService.getWineryListTotalPage();
    map.put("currentPage",currentPage);
    map.put("totalPages",totalPage);
    boolean isFirstPage=false;
    if(currentPage==1){
      isFirstPage=true;
    }
    map.put("isFirstPage",isFirstPage);


    return "winery";
  }

  @RequestMapping("/nextPage")
  public String nextPage(){
    Integer curPage=wineryService.getWineryListCurrentPage();
    Integer nextPage=curPage+1;
    return "redirect:/winery/allWinery/"+nextPage;
  }

  @RequestMapping("/prevPage")
  public String prevPage(){
    Integer curPage=wineryService.getWineryListCurrentPage();
    Integer prevPage=curPage-1;
    if(prevPage<=0)
      prevPage=1;
    return "redirect:/winery/allWinery/"+prevPage;
  }

  @RequestMapping("")
  public String wineryWelcome(){
    return "redirect:/winery/allWinery/1";
  }

  /**
   * Search wines from form input
   *
   */
  /**
   * Search winery by form input
   */
  @PostMapping("/allWinery/wine/searchWinery")
  public String searchWines(String winery){
    String wineryName=winery;
    System.out.println("WineryName: "+wineryName);
    return "redirect:/wine/"+wineryName+"/1";
  }



}
