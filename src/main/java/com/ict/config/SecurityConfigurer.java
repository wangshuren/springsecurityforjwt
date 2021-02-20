package com.ict.config;

import com.ict.filter.JWTAuthenticationTokenFilter;
import com.ict.handler.RestfulAccessDeniedHandler;
import com.ict.handler.RestfulAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @Description: 配置类中使用了我们自定义的filter和两个错误处理器，其中配置那些接口允许访问，那些接口不能访问也是十分方便的
 * @Author wangsr
 * @Date 2021/2/19
 * @Version 1.0
 */
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {
    @Autowired
    private RestfulAccessDeniedHandler restfulAccessDeniedHandler;

    @Autowired
    private RestfulAuthenticationEntryPoint restfulAuthenticationEntryPoint;

    @Autowired
    private JWTAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()//不使用防跨站攻击
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)//不使用session
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/",
                        "/*.html",
                        "/favicon.ico",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js",
                        "/swagger-resources/**",
                        "/v2/api-docs/**").permitAll()//允许静态资源无授权访问
                .and()
                .authorizeRequests().antMatchers("/admin/login", "/admin/register").permitAll()//允许登录接口、注册接口访问
                .and()
                .authorizeRequests().antMatchers(HttpMethod.OPTIONS).permitAll()//配置跨域的option请求，跨域请求之前都会进行一次option请求
                .and()
                .authorizeRequests().anyRequest().authenticated();//其他没有配置的请求都需要身份认证
        http.headers().cacheControl();//http的cache控制，如下这句代码会禁用cache
        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);//添加JWT身份认证的filter
        //添加自定义未授权的处理器
        http.exceptionHandling().accessDeniedHandler(restfulAccessDeniedHandler);
        //添加自定义未登录的处理器
        http.exceptionHandling().authenticationEntryPoint(restfulAuthenticationEntryPoint);
    }
}