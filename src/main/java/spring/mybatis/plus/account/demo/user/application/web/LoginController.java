package spring.mybatis.plus.account.demo.user.application.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import spring.mybatis.plus.account.demo.user.domain.model.User;
import spring.mybatis.plus.account.demo.user.impl.domain.MyUserDetailsService;

import java.rmi.ServerException;

@SuppressWarnings({"SpringJavaAutowiredFieldsWarningInspection", "SameReturnValue"})
@Controller
public class LoginController {

    @Autowired
    MyUserDetailsService myUserDetailsService;


    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String getByEmail(User loginUser) throws ServerException {
        UserDetails user = myUserDetailsService.loadUserByUsername(loginUser.getEmail());
        System.out.println(loginUser.getEmail());
        if (user == null) {
            throw new ServerException("Email does not exist");
        } else {
            if(user.getPassword().equals(loginUser.getPassword())){
                return "homepage";
            }else{
                throw new ServerException("Wrong Password");
            }
        }
    }
}
