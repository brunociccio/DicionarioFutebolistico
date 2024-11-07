package br.com.dicionariofutebolistico.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withUsername("futuser")
                .password(passwordEncoder().encode("futuser"))
                .roles("USER")
                .build();

        UserDetails admin = User.withUsername("futadmin")
                .password(passwordEncoder().encode("futadmin"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Desabilita o CSRF para simplificar as requisições
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/diciofut-login", "/css/**", "/js/**", "/images/**").permitAll() // Permite acesso à página de login e recursos estáticos
                .requestMatchers("/ChatFutDicio").hasAnyRole("USER", "ADMIN") // Permite acesso ao chat para usuários autenticados
                .requestMatchers("/**").hasRole("ADMIN") // Permite acesso total aos administradores
                .anyRequest().authenticated() // Exige autenticação para qualquer outra requisição
            )
            .formLogin(form -> form
                .loginPage("/diciofut-login") // Página de login customizada
                .loginProcessingUrl("/login") // URL para processar o login via formulário
                .defaultSuccessUrl("/ChatFutDicio", true) // Redireciona para o chat após login bem-sucedido
                .failureUrl("/diciofut-login?error=true") // Redireciona para a página de login com erro
                .permitAll() // Permite acesso a qualquer pessoa à página de login
            )
            .httpBasic() // Permite autenticação básica para testes no Insomnia/Postman
            .and()
            .logout(logout -> logout
                .logoutUrl("/logout") // URL para logout
                .logoutSuccessUrl("/diciofut-login?logout=true") // Redireciona para página de login após logout
                .permitAll()
            );
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder =
            http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder
            .userDetailsService(userDetailsService())
            .passwordEncoder(passwordEncoder());
        return authenticationManagerBuilder.build();
    }
}
