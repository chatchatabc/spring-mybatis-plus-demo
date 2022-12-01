package spring.mybatis.plus.account.demo.user.impl.infra.mybatisplus;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Repository;
import spring.mybatis.plus.account.demo.user.domain.model.User;

@Repository
public class UserMapperService extends ServiceImpl<UserMapper, User> {
}
