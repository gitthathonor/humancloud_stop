package site.metacoding.humancloud.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.Import;

import site.metacoding.humancloud.config.MyBatisConfig;
import site.metacoding.humancloud.domain.user.User;
import site.metacoding.humancloud.domain.user.UserDao;


@Import(MyBatisConfig.class) // MyBatisTest가 MyBatisConfig를 못읽음
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // 실DB사용
@MybatisTest
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void findById_test() {
        // given (받아야 될 것)
        Integer productId = 1;

        // when (테스트)
        User userPS = userDao.findById(productId);

        // then (검증)
        assertEquals("ssar", userPS.getUsername());
    }

    @Test
    public void findAll_test() {
        // given

        // when
        List<User> userListPS = userDao.findAll();

        // then
        assertEquals(3, userListPS.size());
    }

    // // Junit은 메서드 실행직전에 트랜잭션이 걸리고, 메서드 실행이 끝나면 rollback 됨.
    // // MyBatis는 ResultSet을 자바 Entity로 변경해줄때, 빈생성자를 호출하고 setter가 없어도 값을 매핑해준다.
    @Test
    public void insert_test() {
        // given
        String username = "yu";
        String password = "123";
        String name= "yujin";
        String email = "yujin09@gmail.com";
        String phoneNumber = "01099966462";
        
        User user = new User(username, password, username, email, phoneNumber);

        // when
        int result = userDao.save(user);

        // then
        assertEquals(1, result);
    } // rollback

    @Test
    public void update_test() {
        // given
        Integer userId = 1;
        String username = "ssar2";
        String password = "123";
        String name= "구직자";
        String email = "aa@gmail.com";
        String phoneNumber = "01011112222";


        User userPS = userDao.findById(userId);
        userPS.UserUpdate(password, name, email, phoneNumber);
        

        int result=userDao.update(userPS);

        // then
        assertEquals(1, result);
    }

    @Test
    public void deleteById_test() {
        // given
        Integer userId = 3;

        // verify
        User userPS = userDao.findById(userId);

        // when
        int result = userDao.deleteById(userId);

        // then
        assertEquals(1, result);
    }

}