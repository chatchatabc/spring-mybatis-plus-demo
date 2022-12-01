package spring.mybatis.plus.account.demo.user;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@MapperScan("spring.mybatis.plus.account.demo.user.impl.infra.mybatisplus")
class SpringMyBatisPlusAccountDemoApplicationTests {

	@Test
	void contextLoads() {
	}

}
