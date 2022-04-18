package com.example.wines.pojo;

public class Winery {
  protected String wineryName;
  protected int wineryId;


  public Winery(String wineryName, int wineryId) {
    this.wineryName = wineryName;
    this.wineryId = wineryId;
  }

  public Winery(){}

  public Winery(String wineryName) {
    this.wineryName = wineryName;
  }

  public String getWineryName() {
    return wineryName;
  }

  public void setWineryName(String wineryName) {
    this.wineryName = wineryName;
  }

  public int getWineryId() {
    return wineryId;
  }

  public void setWineryId(int wineryId) {
    this.wineryId = wineryId;
  }

  @Override
  public String toString() {
    return this.getWineryName();
  }
}
