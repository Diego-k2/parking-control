package br.com.pi.parkingcontrol.configs.security;

import br.com.pi.parkingcontrol.model.UserModel;
import br.com.pi.parkingcontrol.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    //FAZ A BUSCA E A VERIFICAÇÃO NO BANCO DE DADOS

    //Injeção de usuario
    final UserRepository userRepository;
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //FAZ A BUSCA E A VERIFICAÇÃO NO BANCO DE DADOS
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel userModel = userRepository.findByUsername(username)
                .orElseThrow(() ->new UsernameNotFoundException("Usuario não encontrado"));
        return userModel;
    }
}
