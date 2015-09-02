package test;

import com.kolehank.sme.model.User;
import com.kolehank.sme.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml", "classpath:spring-mybatis.xml"})
public class TestMethod {

    @Autowired
    private UserService user;

    @Test
    public void test() {
        User stu = user.getByID(new Long(1));
        System.out.println(stu.getUsername());


        User user1 = new User();
        user1.setId(new Long(3));
        user1.setPassword("test1transcation");
        user1.setUsername("testuser1");

        User user2 = new User();
        user2.setId(new Long(4));
        user2.setPassword("testtranscation");
        user2.setUsername("testuser2");

        user.testTransaction(user1, user2);
    }

}
