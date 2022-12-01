package spring.mybatis.plus.account.demo.user.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.mybatis.plus.account.demo.user.domain.model.User;
import spring.mybatis.plus.account.demo.user.domain.specification.UserValidations;
import spring.mybatis.plus.account.demo.user.impl.domain.UserAlreadyExistAuthenticationException;
import spring.mybatis.plus.account.demo.user.impl.infra.mybatisplus.UserMapper;


@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Service
@Transactional
public class RegisterService {

    private UserMapper userMapper;

    private UserValidations userValidations;

    public long registerNewUserAccount(User user) throws UserAlreadyExistAuthenticationException {
        if (userValidations.emailExists(user.getEmail())) {
            throw new UserAlreadyExistAuthenticationException("There is an account with that email address: "
                    + user.getEmail());
        }
         return userMapper.insert(user);
    }


}
