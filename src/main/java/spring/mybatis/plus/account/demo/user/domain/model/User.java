package spring.mybatis.plus.account.demo.user.domain.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@TableName("users")
public class User {

    @TableId(type = IdType.AUTO)
    private long id;
    @TableField("username")
    private String username;
    @TableField("password")
    private String password;
    @TableField("email")
    private String email;
    private List<String> roles;
    @TableField("dateat")
    private LocalDate dateCreated;
    @TableField("lastlogin")
    private LocalDate lastLogin;

}
