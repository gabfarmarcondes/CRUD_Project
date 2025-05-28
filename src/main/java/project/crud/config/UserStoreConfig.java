package project.crud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UserStoreConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        var userDetailsManagaer = new InMemoryUserDetailsManager();
        userDetailsManagaer.createUser(
                User.withUsername("user")
                        .password("{noop}password")
                        .roles("USER")
                        .build());

        return userDetailsManagaer;
    }
}
