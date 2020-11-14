package com.example.BM_Backend;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping(value = "/user/{id}")
    @ResponseBody
    UserDto getUser(@PathVariable("id") long id) {
        UserEntity userEntity = userService.getUser(id);
        UserDto userDto = this.convertToDto(userEntity);
        return userDto;
    }

    @PutMapping(value = "/user/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    long putUser(@RequestBody UserDto userDto){
        UserEntity userEntity = this.convertToEntity(userDto);
        userService.addUser(userEntity);
        return userEntity.getId();
    }

    private UserDto convertToDto(UserEntity userEntity){
        UserDto userDto = modelMapper.map(userEntity, UserDto.class);
        return userDto;
    }

    private UserEntity convertToEntity(UserDto userDto){
        UserEntity userEntity = modelMapper.map(userDto, UserEntity.class);
        return userEntity;
    }
}
