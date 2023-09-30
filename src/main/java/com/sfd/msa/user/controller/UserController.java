package com.sfd.msa.user.controller;

import com.sfd.msa.user.dto.UserDto;
import com.sfd.msa.user.dto.mapper.UserGenerateMapper;
import com.sfd.msa.user.server.DomainApi;
import com.sfd.msa.user.service.GenericService;
import com.sfd.services.server.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController implements DomainApi {

    private final GenericService<UserDto, Integer> userService;
    private final UserGenerateMapper userGenerateMapper;

    @Override
    public ResponseEntity<User> createUser(User user) {
        UserDto userDto = userGenerateMapper.toUserDto(user);
        User response = userGenerateMapper.toUser(userService.save(userDto));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<User>> getAllUsers() {
        List<UserDto> userDtos = userService.findAll();
        return ResponseEntity.ok().body(userGenerateMapper.toUserGenerate(userDtos));
    }

}
