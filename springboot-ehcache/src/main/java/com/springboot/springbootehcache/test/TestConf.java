package com.springboot.springbootehcache.test;

import com.springboot.springbootehcache.SpringbootEhcacheApplication;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @author hz
 * @since 2020/4/09 14:09
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringbootEhcacheApplication.class)
@AutoConfigureMockMvc
public class TestConf {
    @Autowired
    private MockMvc mockMvc;

}