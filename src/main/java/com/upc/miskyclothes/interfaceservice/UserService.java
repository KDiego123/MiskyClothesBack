package com.upc.miskyclothes.interfaceservice;
import  com.upc.miskyclothes.entities.User;
import java.util.List;


public interface UserService {
    public User register(User user);
    public List<User>listUser();
    public User updateUser(User user) throws Exception;
    public User deleteUser(Long id) throws Exception;

    List<User>listByName(String prefix);

}
