package spring.mybatis.plus.account.demo.user.domain.model;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.mybatis.plus.account.demo.user.SpringBootBaseTest;
import spring.mybatis.plus.account.demo.user.impl.infra.mybatisplus.UserMapper;
import spring.mybatis.plus.account.demo.user.impl.infra.mybatisplus.UserMapperService;

import static org.assertj.core.api.Assertions.assertThat;


class UserRepositoryTest extends SpringBootBaseTest {

    @Autowired
    private UserMapperService userMapperService;

    @Test
    void checkThatUserExist() {
        QueryWrapper<User> lqw = new QueryWrapper<>();
        boolean val = userMapperService.getOne(lqw.select("email").eq("email","admin@email.com")) != null;
        //System.out.println(userMapperService.getOne(lqw.select("email").eq("email","admin@email.com")));
        assertThat(val).isEqualTo(true);

    }

    @Test
    void checkThatUserDoesNotExist() {
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        final boolean val = userMapperService.getOne(lqw.select(User::getEmail).eq(User::getEmail,"josh@email.com")) != null;

        assertThat(val).isEqualTo(false);

    }


}