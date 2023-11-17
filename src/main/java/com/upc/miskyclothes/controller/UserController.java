package com.upc.miskyclothes.controller;


import com.upc.miskyclothes.dtos.PoloDTO;
import com.upc.miskyclothes.dtos.UserDTO;
import com.upc.miskyclothes.entities.Polo;
import com.upc.miskyclothes.entities.User;
import com.upc.miskyclothes.interfaceservice.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class UserController {
@Autowired
private UserService userService;
@PostMapping("/user")
    ResponseEntity<UserDTO> register(@RequestBody UserDTO userDTO){
    User user   ;
    UserDTO dto;
    try{
        user=convertToEntity(userDTO);
        user=userService.register(user);
        dto=convertToDto(user);
    }
    catch (Exception e){
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se ha podido registrar");
    }
    return new ResponseEntity<UserDTO>(dto,HttpStatus.OK);
    }
@GetMapping("/users")
public ResponseEntity<List<UserDTO>>listUsers(){
    List<User> list;
    List<UserDTO> listDTO=null;
    try{
        list=userService.listUser();
        listDTO=convertToListDto(list);
    }catch (Exception e){
        throw  new ResponseStatusException(HttpStatus.NOT_FOUND,"Lista no disponible");
    }
    return new ResponseEntity<>(listDTO,HttpStatus.OK);
}

@PutMapping("/actualizaruse")
public ResponseEntity<User>updateUser(@RequestBody User user){
    User user1;
    try{
        user1=userService.updateUser(user);
    }catch (Exception e){
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se puede actualizar");
    }
    return new ResponseEntity<User>(user1,HttpStatus.OK);

}
 @GetMapping("/users/{prefijo}")
 public List<User> listByName(@PathVariable(value="prefijo") String prefijo) {return userService.listByName(prefijo);}


    private User convertToEntity(UserDTO userDTO){
        ModelMapper modelMapper=new ModelMapper();
        User post= modelMapper.map(userDTO,User.class);
        return post;
    }

    private UserDTO convertToDto(User user  ){
        ModelMapper modelMapper=new ModelMapper();
        UserDTO userDTO= modelMapper.map(user,UserDTO.class);
        return userDTO;
    }

    private List<UserDTO> convertToListDto(List<User> list){
        return list.stream().map(this::convertToDto).collect(Collectors.toList());
    }
}
