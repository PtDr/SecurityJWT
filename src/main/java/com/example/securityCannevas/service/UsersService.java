package com.example.securityCannevas.service;

import com.example.securityCannevas.entity.Users;

import java.util.List;

public interface UsersService {

    public Users save(Users users);

    public List<Users> getAll();
}
