package com.artysh.FirstSecurityApp.config;

import com.artysh.FirstSecurityApp.services.PersonDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PersonDetailsService personDetailsService;

    @Autowired
    public SecurityConfig(PersonDetailsService personDetailsService) {
        this.personDetailsService = personDetailsService;
    }

    // Настраиваем наш Spring Security, чтобы использовать свою форму для логина и авторизации
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()   // отключаем защиту от межсайтовой подделки запросов
                .authorizeRequests() // фильтр чтобы не допускать неаутентифицированного пользователя к странице hello
                .antMatchers("/auth/login", "/auth/registration", "/error").permitAll() // доступ всем неаутентифицированным
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/auth/login") // чтобы настроить форму для логина
                .loginProcessingUrl("/process_login")   // указываем, куда должны прийти данные с login
                .defaultSuccessUrl("/hello", true)
                .failureUrl("/auth/login?error");
    }

    // Настраивает аутентификацию (передаем наш UserDetails)
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(personDetailsService); // вместо своего AuthProvider передаем userDetailsService
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
