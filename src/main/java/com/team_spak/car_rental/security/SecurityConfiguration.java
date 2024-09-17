package com.team_spak.car_rental.security;


import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@AllArgsConstructor
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
@Configuration
@SecurityScheme(name = "basicAuth", type = SecuritySchemeType.HTTP, scheme = "basic")
public class SecurityConfiguration {

    private UserDetailsService userDetailsService;

    //Authorization
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable);

        // Configure HTTP security
        http.authorizeHttpRequests(authorize -> authorize
                .requestMatchers(HttpMethod.GET).permitAll()
                .requestMatchers(HttpMethod.POST).permitAll()
                .requestMatchers(HttpMethod.PUT).permitAll()
                .requestMatchers(HttpMethod.DELETE).permitAll()

        );

        http.formLogin(formLogin -> formLogin
                        .loginPage("/login")
                .defaultSuccessUrl("/user")
                .permitAll()
                )
                .logout(LogoutConfigurer::permitAll
                );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //Db Authentication
    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
      return configuration.getAuthenticationManager();
    }


    //In memory authentication
//    @Bean
//    public UserDetailsService userDetailsService() {
//
//        UserDetails java28 = User.builder()
//                .username("java28")
//                .password(passwordEncoder().encode("java28"))
//                .roles("USER")
//                .build();
//
//        UserDetails java29 = User.builder()
//                .username("java29")
//                .password(passwordEncoder().encode("java29"))
//                .roles("ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(java28, java29);
//    }






}
