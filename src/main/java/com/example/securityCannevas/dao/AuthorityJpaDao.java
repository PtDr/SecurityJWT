package com.example.securityCannevas.dao;

import com.example.securityCannevas.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityJpaDao extends JpaRepository<Authority, Long> {
}
