package com.example.securityCannevas.service;

import com.example.securityCannevas.dao.AuthorityJpaDao;
import com.example.securityCannevas.dao.UsersJpaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service @Transactional(rollbackOn = Exception.class)
public class UsersServiceImpl implements UsersService {

    @Autowired
    UsersJpaDao usersJpaDao;

    @Autowired
    AuthorityJpaDao authorityJpaDao;
}
