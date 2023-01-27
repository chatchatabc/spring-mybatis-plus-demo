package spring.mybatis.plus.account.demo.user.impl.domain;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.mybatis.plus.account.demo.user.domain.model.User;
import spring.mybatis.plus.account.demo.user.impl.infra.mybatisplus.UserMapper;

import java.util.ArrayList;
import java.util.List;


/**
 * todo move to web/config
 */
@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Service
@Transactional
public class MyUserDetailsService implements UserDetailsService {

    private UserMapper userMapper;

    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        User user = userMapper.selectOne(lqw.select(User::getEmail).eq(User::getEmail,email));
        System.out.println(userMapper.selectOne(lqw.select(User::getEmail).eq(User::getEmail,email)));
        ArrayList<String> role = new ArrayList<>();
        role.add("ADMIN");
        if (user == null) {
            throw new UsernameNotFoundException("No user found with email: " + email);
        }
        user.setRoles(role);
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;


        return new org.springframework.security.core.userdetails.User(
                user.getEmail(), user.getPassword(), enabled, accountNonExpired,
                credentialsNonExpired, accountNonLocked, getAuthorities(role));
    }

    private static List<GrantedAuthority> getAuthorities (List<String> roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }

}
