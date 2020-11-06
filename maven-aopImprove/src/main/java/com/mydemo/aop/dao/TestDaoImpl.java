package com.mydemo.aop.dao;

import org.springframework.stereotype.Repository;

/**
 * @author hz
 * @Description:
 * @create 2020-04-28
 */
@Repository("testDao")
public class TestDaoImpl implements TestDao {
    @Override
    public void query() {
        System.out.println("query:");
    }
}
