package br.com.pi.parkingcontrol.configs.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true) //fazendo os filtros de outra forma usar isso
public class WebSecurityConfigV2 {

    //Mesma coisa da outra forma mas com componentes

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .httpBasic()
                .and()//unindo configurações
                .authorizeHttpRequests()
//                .antMatchers(HttpMethod.GET, "/parking-spot/**").permitAll() //FAZ CONTROLE DE ACESSO
//                .antMatchers(HttpMethod.POST, "/parking-spot").hasRole("USER") //FAZ CONTROLE DE ACESSO
//                .antMatchers(HttpMethod.DELETE, "/parking-spot/**").hasRole("ADMIN") //FAZ CONTROLE DE ACESSO
                .anyRequest().authenticated()//todas precisam ser autenticadas
                .and()
                .csrf().disable(); //desabilitar CSRF
        //.anyRequest().permitAll(); //Permite todas solitações

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){ //Faz uma encriptação da senha é necessario
        return new BCryptPasswordEncoder();
    }


}
