package spring.mybatis.plus.account.demo.user.impl.domain;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.mybatis.plus.account.demo.user.domain.model.User;
import spring.mybatis.plus.account.demo.user.domain.specification.UserValidations;
import spring.mybatis.plus.account.demo.user.impl.infra.mybatisplus.UserMapper;

@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Service
public class UserValidationsImpl implements UserValidations {


    private UserMapper userMapper;


    @Override
    public boolean emailExists(String email) {
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        return userMapper.selectOne(lqw.select(User::getEmail).eq(User::getEmail,email)) != null;
    }
}
