package com.example.wines.pojo;

public class ProfessionalWineReview {

  private int id;
  private String country;
  private String description;
  private String designation;
  private Integer points;
  private Integer price;
  private String province;
  private String region1;
  private String region2;
  private String tasterName;
  private String tasterTwitter;
  private String wineTitle;
  private String variety;
  private String winery;

  public ProfessionalWineReview() {
  }

  public ProfessionalWineReview(int id) {
    this.id = id;
  }

  public ProfessionalWineReview(int id, String country, String description,
      String designation, int points, int price, String province, String region1,
      String region2, String tasterName, String tasterTwitter, String wineTitle,
      String variety, String winery) {
    this.id = id;
    this.country = country;
    this.description = description;
    this.designation = designation;
    this.points = points;
    this.price = price;
    this.province = province;
    this.region1 = region1;
    this.region2 = region2;
    this.tasterName = tasterName;
    this.tasterTwitter = tasterTwitter;
    this.wineTitle = wineTitle;
    this.variety = variety;
    this.winery = winery;
  }

  public ProfessionalWineReview(String country, String description, String designation, int points,
      int price, String province, String region1, String region2, String tasterName,
      String tasterTwitter, String wineTitle, String variety, String winery) {
    this.country = country;
    this.description = description;
    this.designation = designation;
    this.points = points;
    this.price = price;
    this.province = province;
    this.region1 = region1;
    this.region2 = region2;
    this.tasterName = tasterName;
    this.tasterTwitter = tasterTwitter;
    this.wineTitle = wineTitle;
    this.variety = variety;
    this.winery = winery;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getDesignation() {
    return designation;
  }

  public void setDesignation(String designation) {
    this.designation = designation;
  }

  public int getPoints() {
    return points;
  }

  public void setPoints(int points) {
    this.points = points;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province;
  }

  public String getRegion1() {
    return region1;
  }

  public void setRegion1(String region1) {
    this.region1 = region1;
  }

  public String getRegion2() {
    return region2;
  }

  public void setRegion2(String region2) {
    this.region2 = region2;
  }

  public String getTasterName() {
    return tasterName;
  }

  public void setTasterName(String tasterName) {
    this.tasterName = tasterName;
  }

  public String getTasterTwitter() {
    return tasterTwitter;
  }

  public void setTasterTwitter(String tasterTwitter) {
    this.tasterTwitter = tasterTwitter;
  }

  public String getWineTitle() {
    return wineTitle;
  }

  public void setWineTitle(String wineTitle) {
    this.wineTitle = wineTitle;
  }

  public String getVariety() {
    return variety;
  }

  public void setVariety(String variety) {
    this.variety = variety;
  }

  public String getWinery() {
    return winery;
  }

  public void setWinery(String winery) {
    this.winery = winery;
  }

  @Override
  public String toString() {
    return "ProfessionalWineReview{" +
        "id=" + id +
        ", country='" + country + '\'' +
        ", description='" + description + '\'' +
        ", designation='" + designation + '\'' +
        ", points=" + points +
        ", price=" + price +
        ", province='" + province + '\'' +
        ", region1='" + region1 + '\'' +
        ", region2='" + region2 + '\'' +
        ", tasterName='" + tasterName + '\'' +
        ", tasterTwitter='" + tasterTwitter + '\'' +
        ", wineTitle='" + wineTitle + '\'' +
        ", variety='" + variety + '\'' +
        ", winery='" + winery + '\'' +
        '}';
  }
}
