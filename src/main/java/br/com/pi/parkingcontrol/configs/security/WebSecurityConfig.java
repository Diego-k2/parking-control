package br.com.pi.parkingcontrol.configs.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    final UserDetailsServiceImpl userDetailsService;

    public WebSecurityConfig(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception { //Configurando o http security
        http
                .httpBasic()
                .and()//unindo configurações
                .authorizeHttpRequests()
                .anyRequest().authenticated()//todas precisam ser autenticadas
                .and()
                .csrf().disable(); //desabilitar CSRF
                //.anyRequest().permitAll(); //Permite todas solitações
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception { //CONFIGURANDO UM USUARIO PODE SER MEMORIA OU jpa
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder(){ //Faz uma encriptação da senha é necessario
        return new BCryptPasswordEncoder();
    }
}
