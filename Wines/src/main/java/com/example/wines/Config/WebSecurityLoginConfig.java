package com.example.wines.Config;



import com.example.wines.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Configuration

public class WebSecurityLoginConfig extends WebSecurityConfigurerAdapter {
  //注入用户服务
  @Autowired
  UserService userService;
  //配置用户登录密码需要BCryptPasswordEncoder密文认证
  @Bean
  PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder(10);
  }
  //基于数据库的用户账号密码、角色、过期、锁定等认证
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception{
    auth.userDetailsService(userService);
  }
  @Override
  protected void configure(HttpSecurity httpSecurity) throws Exception {
    httpSecurity.authorizeRequests()
        //对可访问URL资源进行角色控制
        .antMatchers("/admin/**")
        .hasRole("admin")
        .antMatchers("/user/**")
        .access("hasAnyRole('admin','user')")
        .antMatchers("/db/**")
        .access("hasRole('dba') and hasRole('admin')")
        //用户注册接口和执行用户注册接口允许访问
        .antMatchers("/register","/doregister")
        .permitAll()
        //用户访问其他URL资源都必须认证后访问，即登陆后访问
        .anyRequest()
        .authenticated()
        //开启表单登录，即登录界面，登录URL为/login，登录参数用户名username密码password
        //Ajax或移动端通过POST请求登录，接口为/login，permitAll表示登录不需要认证即可访问
        .and()
        .logout()
        .logoutUrl("/logout").logoutSuccessUrl("/login").and()
        .formLogin()
        .loginProcessingUrl("/login")
        .permitAll()
        //成功登录后跳转到hello页面
        .successHandler(new AuthenticationSuccessHandler() {
          @Override
          public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
            response.setContentType("application/json;charset=utf-8");
            response.sendRedirect("/");
          }
        })

        .and()
        .csrf()
        .disable();
  }
}
