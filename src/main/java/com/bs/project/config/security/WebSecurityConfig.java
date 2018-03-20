package com.bs.project.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by Nominal on 2018/3/19 0019.
 * 微博：@Mr丶Li_Anonym
 * 用户权限核心配置
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{


    @Autowired
    private CustomUserDetailsService customUserService;// 注入CustomUserDetailsService

    @Autowired
    private AuthenticationProvider provider; // 注入AuthenticationProvider
    /**
     *授权验证服务
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //用到我们自己的provider，从而可以实现自己去数据库中提取用户名和密码进行校验的逻辑
        //auth.authenticationProvider(provider);
        //添加加密方式，才能正确匹配
        auth.userDetailsService(customUserService).passwordEncoder(new BCryptPasswordEncoder());
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(new String[]{"/js/**","/css/**","/img/**","/images/**","/fonts/**","/**/favicon.ico"}).permitAll()//不拦截静态资源
                .anyRequest().authenticated()//所有的请求需要认证即登陆后才能访问
                .and()
                    .formLogin()
                        .loginPage("/login")
                        .failureUrl("/login?error")
                .defaultSuccessUrl("/index", true)//登录成功后跳转地址
                .permitAll()
                .and()
                    .logout().permitAll()
                .and()
                    .csrf().disable();
    }
}
