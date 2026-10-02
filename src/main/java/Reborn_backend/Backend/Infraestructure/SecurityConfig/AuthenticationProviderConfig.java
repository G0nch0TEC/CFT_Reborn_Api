package Reborn_backend.Backend.Infraestructure.SecurityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AuthenticationProviderConfig {

    private final UserDetailsService userDetails;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationProviderConfig(
            UserDetailsService userDetails,
            PasswordEncoder passwordEncoder) {

        this.userDetails = userDetails;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider =
                new DaoAuthenticationProvider(userDetails);

        provider.setPasswordEncoder(passwordEncoder);

        return provider;
    }
}