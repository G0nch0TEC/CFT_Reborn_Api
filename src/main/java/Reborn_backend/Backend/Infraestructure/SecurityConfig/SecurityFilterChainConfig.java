package Reborn_backend.Backend.Infraestructure.SecurityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityFilterChainConfig {
    private final AuthenticationProviderConfig authenticationProviderConfig;

    public SecurityFilterChainConfig(AuthenticationProviderConfig authenticationProviderConfig){
        this.authenticationProviderConfig = authenticationProviderConfig;
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth.requestMatchers("/usuario", "/auth").permitAll()
                        .anyRequest()
                        .authenticated())
                .authenticationProvider(authenticationProviderConfig.authenticationProvider());

        return http.build();
    }
}
