package com.pro.serviceImpl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pro.dao.ClientDao;
import com.pro.model.Client;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ClientDao clientDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Client client = clientDao.findByLogin(username).orElse(null);
        if(client == null){
            throw new UsernameNotFoundException(username);
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(client.getRole().name()));

        return new org.springframework.security.core.userdetails.User(
                client.getLogin(),
                client.getPassword(),
                grantedAuthorities
        );
    }
}
