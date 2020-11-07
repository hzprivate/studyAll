package com.hz.util;

import com.hz.functionInterface.FunctionReplaceList;

import java.util.List;

/**
 * //对List集合中所有含有2 的数据元素替换位 *
 * @author hz
 * @create 2020-11-06
 */
public class MyList   {
    public static void replace2X(List list,FunctionReplaceList function){
        for (int i = 0; i < list.size(); i++) {
            if(String.valueOf(list.get(i)).equals("2")){
                //此处调用function.myReplace() 会调用function中 ->后的的逻辑语句
                list.set(i,function.myReplace(String.valueOf(list.get(i)),"*"));
            }
        }
    }
}
