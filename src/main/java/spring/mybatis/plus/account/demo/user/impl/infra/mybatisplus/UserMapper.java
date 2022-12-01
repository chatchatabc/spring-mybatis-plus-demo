package spring.mybatis.plus.account.demo.user.impl.infra.mybatisplus;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;
import spring.mybatis.plus.account.demo.user.domain.model.User;

public interface UserMapper extends BaseMapper<User> {
}
