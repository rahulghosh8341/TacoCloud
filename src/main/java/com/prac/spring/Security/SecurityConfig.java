package com.prac.spring.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

import com.prac.spring.Model.User;
import com.prac.spring.Repository.UserRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // In memory
    // @Bean
    // public UserDetailsService userDetailsService(PasswordEncoder encoder) {
    // List<UserDetails> usersList = new ArrayList<>();
    // usersList.add(new User(
    // "buzz", encoder.encode("password"),
    // Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"))));
    // usersList.add(new User(
    // "woody", encoder.encode("password"),
    // Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"))));
    // return new InMemoryUserDetailsManager(usersList);
    // }

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserRepositoryUserDetailsService();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .authorizeHttpRequests()
                    .requestMatchers("/designjdbc", "/orderjdbc/**").authenticated()
                .and()
                .authorizeHttpRequests()
                    .requestMatchers(HttpMethod.POST, "/api/ingredients").hasAnyAuthority("SCOPE_writeIngredients")
                    .requestMatchers(HttpMethod.DELETE, "/api/ingredients").hasAuthority("SCOPE_deleteIngredients")
                .and()
                .oauth2ResourceServer(oauth -> oauth.jwt())
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/designjdbc", true)
                .permitAll()
                .and()
                .oauth2Login()
                .loginPage("/login")
                .defaultSuccessUrl("/designjdbc", true)
                .permitAll()
                .and()
                .authorizeHttpRequests()
                .requestMatchers("/h2-console/**", "/register", "/error").permitAll()
                .requestMatchers("/", "/**").permitAll()
                .and()
                .logout()
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID");
        return http.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoauthenticationProvider = new DaoAuthenticationProvider();
        daoauthenticationProvider.setUserDetailsService(userDetailsService());
        daoauthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoauthenticationProvider;

    }

}
