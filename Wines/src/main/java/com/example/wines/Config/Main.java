package com.example.wines.Config;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int i = 1;
    StringBuilder s = new StringBuilder();
    s.append(i);
    while (n > s.length()) {
      n -= s.length();
      i++;
      s.append(i);
    }
    System.out.println(s.charAt(n - 1));
  }
}
