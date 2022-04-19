package com.example.wines.pojo;

import java.io.Serializable;

public class UserReview implements Serializable {
  private String wineTitle;
  private String description;
  private Integer point;
  private Double price;
  private String userName;

  public UserReview() {
  }

  public UserReview(String wineTitle, String description, Integer point, Double price,
      String userName) {
    this.wineTitle = wineTitle;
    this.description = description;
    this.point = point;
    this.price = price;
    this.userName = userName;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getWineTitle() {
    return wineTitle;
  }

  public void setWineTitle(String wineTitle) {
    this.wineTitle = wineTitle;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getPoint() {
    return point;
  }

  public void setPoint(Integer point) {
    this.point = point;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "UserReview{" +
        "wineTitle='" + wineTitle + '\'' +
        ", description='" + description + '\'' +
        ", point=" + point +
        ", price=" + price +
        ", userName='" + userName + '\'' +
        '}';
  }
}
