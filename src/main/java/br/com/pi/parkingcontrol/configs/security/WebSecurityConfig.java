package br.com.pi.parkingcontrol.configs.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
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
                .antMatchers(HttpMethod.GET, "/parking-spot/**").permitAll() //FAZ CONTROLE DE ACESSO
                .antMatchers(HttpMethod.POST, "/parking-spot").hasRole("USER") //FAZ CONTROLE DE ACESSO
                .antMatchers(HttpMethod.DELETE, "/parking-spot/**").hasRole("ADMIN") //FAZ CONTROLE DE ACESSO
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
