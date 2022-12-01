package spring.mybatis.plus.account.demo.user.impl.infra;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.mybatis.plus.account.demo.user.impl.infra.mybatisplus.UserMapperService;

@Configuration
public class MyBatisMapperConfiguration {
    //@Bean
    public MapperFactoryBean<UserMapperService> providerRepository(SqlSessionFactory sqlSessionFactory) {
        MapperFactoryBean<UserMapperService> factoryBean = new MapperFactoryBean<>(UserMapperService.class);
        factoryBean.setSqlSessionFactory(sqlSessionFactory);
        return factoryBean;
    }
}
