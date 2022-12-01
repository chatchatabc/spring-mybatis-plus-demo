package spring.mybatis.plus.account.demo.user.application.commons.dto;

import lombok.Data;



@Data
public class UserRegisDto {


    private String username;


    private String password;
    private String matchingPassword;

    private String email;

}
