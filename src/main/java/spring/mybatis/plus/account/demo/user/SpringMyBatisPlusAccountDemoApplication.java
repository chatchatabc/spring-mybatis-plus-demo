package spring.mybatis.plus.account.demo.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("spring.mybatis.plus.account.demo.user.impl.infra.mybatisplus")
public class SpringMyBatisPlusAccountDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMyBatisPlusAccountDemoApplication.class, args);
	}

}
