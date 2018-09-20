//package com.dharmesh.AW.Assignment1.config;
//
//import com.dharmesh.AW.Assignment1.JPARepository.loginRepository;
//import com.dharmesh.AW.Assignment1.Model.UserDetailsCustom;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
////    @Autowired
////    private UserDetailsCustom userDetailsCustom;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http.csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/login").permitAll()
//                .antMatchers("/createUser").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin().loginPage("/login").permitAll()
//                .and()
//                .rememberMe()
//                    .key("apiKey")
//                    .rememberMeCookieName("cookie")
//                    .tokenValiditySeconds(60)
//                .and()
//                .logout()
//                .permitAll();
//
//
//    }
//
////    @Override
////    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        auth.userDetailsService(userDetailsCustom)
////                .passwordEncoder(getPasswordEncoder());
////    }
////
////    private PasswordEncoder getPasswordEncoder() {
////        return new PasswordEncoder() {
////            @Override
////            public String encode(CharSequence charSequence) {
////                return charSequence.toString();
////            }
////
////            @Override
////            public boolean matches(CharSequence charSequence, String s) {
////                return true;
////            }
////        };
////    }
//}
