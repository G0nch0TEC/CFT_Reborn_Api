package Reborn_backend.Backend.Infraestructure.SecurityConfig;

import Reborn_backend.Backend.domain.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class UserDetailsServiceConfig {
    private final UserRepository userRepository;

    public UserDetailsServiceConfig(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Bean
    public UserDetailsService userDetailsService(){
        return new UsuarioDetails(userRepository);
    }
}
