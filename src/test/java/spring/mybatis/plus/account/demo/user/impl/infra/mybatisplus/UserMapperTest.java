package spring.mybatis.plus.account.demo.user.impl.infra.mybatisplus;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import spring.mybatis.plus.account.demo.user.SpringBootBaseTest;

import static org.assertj.core.api.Assertions.assertThat;

public class UserMapperTest extends SpringBootBaseTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testFindByEmail() {
        String email = "";
        assertThat(userMapper.findByEmail(email)).isNotNull();
    }
}
