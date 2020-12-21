package com.hz.test;

import java.util.*;

/**
 * @author hz
 * @create 2020-12-14
 */
public class StoreTest {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 0, 0};
        Arrays.sort(nums);
        List<List<Integer>> list = new  ArrayList();
        if(nums.length<3){
            System.out.println(list);
        }
        for(int k=0;k<nums.length-2;k++ ){
            int i=k+1;
            int j=nums.length-1;
            if(nums[k]>=0) break;
            if(k>0 && nums[k]==nums[k-1]) continue;//去重
            while(i<j){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum>0){
                    while(nums[j]==nums[--j] && i<j);
                }else if(sum<0){
                    while(nums[i]==nums[++i] && i<j);
                }else{
                    //sum=0
                    list.add(Arrays.asList(nums[k],nums[i],nums[j]));
                    i++;
                }
            }
        }
        System.out.println(list);
    }
}
