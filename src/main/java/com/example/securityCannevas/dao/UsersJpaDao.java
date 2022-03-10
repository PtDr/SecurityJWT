package com.example.securityCannevas.dao;

import com.example.securityCannevas.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersJpaDao extends JpaRepository<Users, Long> {

    Users findByUserName(String userName);
}
