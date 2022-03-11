package com.example.securityCannevas.service;

import com.example.securityCannevas.entity.Authority;

import java.util.List;

public interface AuthorityService {

    public List<Authority> findAll();

    public Authority save(Authority authority);
}
