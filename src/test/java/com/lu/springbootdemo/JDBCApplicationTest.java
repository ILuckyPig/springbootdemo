package com.lu.springbootdemo;

import com.lu.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JDBCApplicationTest {
    @Autowired
    private UserService userService;

    @Before
    public void init() {
        userService.deleteAllUsers();
    }

    @Test
    public void test() throws Exception {
        userService.create("a", 1);
        userService.create("b", 2);
        userService.create("c", 3);
        userService.create("d", 4);
        userService.create("e", 5);
        Assert.assertEquals(5, userService.getAllUsers().intValue());
        userService.deleteByName("a");
        userService.deleteByName("b");
        Assert.assertEquals(3, userService.getAllUsers().intValue());
    }
}
