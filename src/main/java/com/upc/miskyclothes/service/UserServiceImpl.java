package com.upc.miskyclothes.service;


import com.upc.miskyclothes.interfaceservice.UserService;
import com.upc.miskyclothes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.upc.miskyclothes.entities.User;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
@Autowired
    private UserRepository userRepository;

    //CREATE
    public User register (User user) { return userRepository.save(user);}
    //READ
    public List<User> listUser(){return userRepository.findAll();}
    //UPDATE
    public User updateUser (User user) throws  Exception{
        userRepository.findById(user.getDni()).orElseThrow(()->new Exception("No se pudo encontrar usuario"));
        return userRepository.save(user);
    }
    //DELETE
    public User deleteUser(Long dni) throws Exception{
        User user= userRepository.findById(dni).orElseThrow(()->new Exception("No se pudo encontrar usuario"));
                userRepository.delete(user);
        return user;
    }

    @Override
    public List<User> listByName(String prefix) {
        return userRepository.findByApellidoStartingWith(prefix);}

}
