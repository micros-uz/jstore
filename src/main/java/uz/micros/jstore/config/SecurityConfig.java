package uz.micros.jstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.social.security.SpringSocialConfigurer;
import uz.micros.jstore.security.CustomSocialUserDetailsService;
import uz.micros.jstore.security.CustomUserDetailsService;

@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/signin/**", "/signup/**", "/auth/**").permitAll()
                .antMatchers("/webjars/**").permitAll()
                .antMatchers("/resources/**").permitAll()

                .anyRequest().authenticated()
            .and()
                .apply(new SpringSocialConfigurer())
            .and()
                .formLogin()
                    .loginPage("/signin")
                    .loginProcessingUrl("/signin/authenticate")
                .permitAll()
            .and()
                .logout()
                    .logoutSuccessUrl("/")
                    .logoutUrl("/signout")
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSIONID");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Bean
    public SocialUserDetailsService socialUsersDetailService() {
        return new CustomSocialUserDetailsService(userDetailsService());
    }
}
