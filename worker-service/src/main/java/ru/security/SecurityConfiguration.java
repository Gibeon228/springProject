package ru.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .authorizeHttpRequests(registry -> registry
                        .requestMatchers("/worker/yxo").hasAnyAuthority("yxo", "it", "ib")
                        .requestMatchers("/worker/odo").hasAnyAuthority("odo", "it", "ib")
                        .requestMatchers("/**").hasAnyAuthority("it", "ib")
                        .anyRequest().denyAll()
                )
                .formLogin(Customizer.withDefaults())


                .build();
    }

}
