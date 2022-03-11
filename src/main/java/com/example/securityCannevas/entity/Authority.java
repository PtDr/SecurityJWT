package com.example.securityCannevas.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "authority")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Authority {

    @Id
    @Column(name = "id_authority", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "libelle", nullable = false)
    private String libelle;
}
