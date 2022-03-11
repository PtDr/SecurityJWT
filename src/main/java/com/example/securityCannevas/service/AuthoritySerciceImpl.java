package com.example.securityCannevas.service;

import com.example.securityCannevas.dao.AuthorityJpaDao;
import com.example.securityCannevas.entity.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service @Transactional(rollbackOn = Exception.class)
public class AuthoritySerciceImpl implements AuthorityService{

    @Autowired
    AuthorityJpaDao authorityJpaDao;


    @Override
    public List<Authority> findAll() {
        return authorityJpaDao.findAll();
    }

    @Override
    public Authority save(Authority authority) {

        Authority oldAuthority = authorityJpaDao.findByLibelle(authority.getLibelle());
        if (oldAuthority!=null && oldAuthority.getId()>0){
            authority.setId(oldAuthority.getId());
        }

        return authorityJpaDao.save(authority);
    }
}
