package com.bs.project.config.security;


import com.bs.project.consumer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


import java.util.Collection;

/**
 * Created by Nominal on 2018/3/20 0020.
 * 微博：@Mr丶Li_Anonym
 * <p>
 * 用户信息验证
 */
@Component
public class MyAuthenticationProvider implements AuthenticationProvider {

    /**
     * 注入用户信息获取对象
     */
    @Autowired
    private CustomUserDetailsService userDetailService;



    /**
     * @param authentication 身份验证请求对象
     * @return 一个完全验证的对象，包括凭证。
     * @throws AuthenticationException 如果身份验证失败
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        //这个获取表单输入中返回的用户名;
        String userName = authentication.getName();
        //这个是表单中输入的密码；
        String password = (String) authentication.getCredentials();
        //已用户名来调用userDetailService的方法，来获得UserInfo对象
        //userDetailService.loadUserByUsername(userName);
        UserDetails userInfo = userDetailService.loadUserByUsername(userName); // 这里调用我们的自己写的获取用户的方法；

        System.out.println(userInfo);
        //进行判断，看用户名是否存在
        if (userInfo == null) {
            throw new BadCredentialsException("用户名不存在");
        }
       //这里我们还要判断密码是否正确，实际应用中，我们的密码一般都会加密，以Md5加密为例

        BCryptPasswordEncoder encoder =new BCryptPasswordEncoder();
        //加密输入的密码
        String encodePwd=encoder.encode(password);
        System.out.println("加密后"+encodePwd);
        //这里判断密码正确与否
        System.out.println(encoder.matches(userInfo.getPassword(),encodePwd));
        if (encoder.matches(userInfo.getPassword(),encodePwd) != true){
            throw new BadCredentialsException("密码不正确");
        }

        //如果没有问题，拿到userInfo的authorities集合
        Collection<? extends GrantedAuthority> authorities = userInfo.getAuthorities();
        //登录已经成功，构建返回的用户登录成功的token（类似于session），需要传入userInfo，密码，权限集合三个参数
        return new UsernamePasswordAuthenticationToken(userInfo, password, authorities);

    }

    /**
     * @param authentication
     * @return
     */
    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
