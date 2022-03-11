package com.example.securityCannevas.service;

import com.example.securityCannevas.dao.AuthorityJpaDao;
import com.example.securityCannevas.dao.UsersJpaDao;
import com.example.securityCannevas.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(rollbackOn = Exception.class)
public class UsersServiceImpl implements UsersService, UserDetailsService {

    @Autowired
    UsersJpaDao usersJpaDao;

    @Autowired
    AuthorityJpaDao authorityJpaDao;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public Users save(Users users) {
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        return usersJpaDao.save(users);
    }

    @Override
    public Users findByUserName(String userName) {
        return usersJpaDao.findByUserName(userName);
    }

    @Override
    public List<Users> findAll() {
        return usersJpaDao.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users users = this.findByUserName(username);

        if (users == null) {
            throw new UsernameNotFoundException("Utilisateur introuvable");
        }

        Collection<SimpleGrantedAuthority> authorities = users.getAuthorities().stream().map(c -> new SimpleGrantedAuthority(c.getLibelle())).collect(Collectors.toList());

        return new User(users.getUserName(), users.getPassword(), authorities);
    }
}
