package com.example.securityCannevas.controller;

import com.example.securityCannevas.entity.Users;
import com.example.securityCannevas.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    UsersService usersService;

    @GetMapping("")
    public ResponseEntity<List<?>> findAll(){

        return ResponseEntity.ok().body(usersService.findAll());
    }

    @PostMapping("/save")
    public ResponseEntity<Users> save(@RequestBody Users users){

        return ResponseEntity.ok().body(usersService.save(users));
    }
}
