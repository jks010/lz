package com.lazaros.lazarosapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SecurityConfig {

    @Configuration
    public class WebConfiguration implements WebMvcConfigurer {

        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**").allowedMethods("*");
        }
    }
}
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests((requests) -> requests
//                        .requestMatchers("/", "/home", "/users/**").permitAll()
//
//                        .anyRequest().authenticated()
//                )
//                .formLogin((form) -> form.loginPage("/users/*").permitAll());
//
//
//
//        return http.build();
//    }
//
//    @Bean
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/public/**").permitAll() // Permitir acesso público a URLs que começam com /public
//                .anyRequest().authenticated() // Todas as outras URLs requerem autenticação
//                .and()
//                .formLogin() // Configurar login baseado em formulário
//                .loginPage("/login") // Página de login personalizada
//                .permitAll() // Permitir acesso a página de login para todos
//                .and()
//                .logout() // Configurar logout
//                .logoutSuccessUrl("/login?logout") // Redirecionar para a página de login após o logout
//                .permitAll(); // Permitir acesso ao logout para todos
//    }
//
//
//}
