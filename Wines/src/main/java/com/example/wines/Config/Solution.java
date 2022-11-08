package com.example.wines.Config;

import java.util.*;


public class Solution {

  public static void main(String[] args) {
    String res=compileSeq("1,2,-1,1");
    System.out.print(res);
  }


  /**
   * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
   * 编译顺序
   * @param input string字符串
   * @return string字符串
   */
  public static String compileSeq (String input) {
    // write code here
    String[] arr=input.split(",");
    int n=arr.length;
    int[] nums=new int[n];
    // value是被依赖的 nums[i]
    HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();
    StringBuilder sb=new StringBuilder();
    LinkedList<Integer> queue=new LinkedList<>();
    for(int i=0;i<n;i++){
      nums[i]=Integer.parseInt(arr[i]);
      //System.out.println(nums[i]);
      if(nums[i]==-1){
        queue.offer(i);
      }
      else{
        if(map.containsKey(nums[i])){
          ArrayList<Integer> list=map.get(nums[i]);
          list.add(i);
          map.put(nums[i],list);
        }
        else{
          ArrayList<Integer> list=new ArrayList<>();
          list.add(i);
          map.put(nums[i],list);
        }
      }
    }
    while(!queue.isEmpty()){
      int index=queue.poll();
      sb.append(index).append(",");
      if(!map.containsKey(index)){
        continue;
      }
      ArrayList<Integer> list=map.get(index);
      for(int i=0;i<list.size();i++){
        queue.offer(list.get(i));
      }
    }

    sb.setLength(sb.length()-1);
    return sb.toString();
  }
}
