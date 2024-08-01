package com.fruits.e_commerce.service;

import com.fruits.e_commerce.model.entity.Authorities;
import com.fruits.e_commerce.model.entity.Users;
import com.fruits.e_commerce.model.repository.AuthoritiesRepository;
import com.fruits.e_commerce.model.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    UsersRepository usersRepo;
    @Autowired
    AuthoritiesRepository authoritiesRepo;
    public void addUser(Users u){
        usersRepo.save(u);

        Authorities a=new Authorities();
        a.setUser_name(u.getUser_name());
        a.setAuthority(u.getRole_name());

        authoritiesRepo.save(a);
    }
    public Users getOne(String username){
        return usersRepo.findByUser_name(username);
    }

    public Users checker(Users u) {
        return usersRepo.findByUser_nameAndPass(u.getUser_name(),u.getPass());
    }
}
