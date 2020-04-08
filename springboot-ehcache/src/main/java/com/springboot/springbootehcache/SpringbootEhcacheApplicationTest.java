package com.springboot.springbootehcache;

import com.springboot.springbootehcache.beans.User;
import com.springboot.springbootehcache.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringbootEhcacheApplicationTest.class)
public class SpringbootEhcacheApplicationTest {

	@Autowired
	private UserService userService;

	@Test
    public void test1() throws Exception {
        User user = this.userService.getUserByUuid("001");
        System.out.println("用户姓名为：" + user.getName());
        
        User student2 = this.userService.getUserByUuid("001");
        System.out.println("用户姓名为：" + user.getName());
    }
	
//	@Test
//	public void test2() throws Exception {
//
//		User student1 = this.userService.getUserByUuid("001");
//		System.out.println("学号" + student1.getSno() + "的学生姓名为：" + student1.getName());
//
//		student1.setName("康康");
//		this.userService.updateUserByuuid(student1);
//
//		User student2 = this.userService.getUserByUuid("001");
//		System.out.println("学号" + student2.getSno() + "的学生姓名为：" + student2.getName());
//	}
}
