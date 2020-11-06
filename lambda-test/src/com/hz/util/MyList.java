package com.hz.util;

import com.hz.functionInterface.FunctionReplaceList;

import java.util.ArrayList;
import java.util.List;

/**
 * //对List集合中所有含有2 的数据替换位 *
 * @author hz
 * @create 2020-11-06
 */
public class MyList {
    public static List getFunctionReplaceList(List list,FunctionReplaceList function){
        String list1 = function.myReplace("2");
        List a = new ArrayList();
        for (Object o : list) {
            if(String.valueOf(o).equals("2")){
                a.add("*");
            }else{
                a.add(o);
            }
        }
        return a;
    }
}
