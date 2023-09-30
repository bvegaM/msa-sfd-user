package com.sfd.msa.user.service.impl;

import com.sfd.msa.user.dto.UserDto;
import com.sfd.msa.user.dto.mapper.UserDtoMapper;
import com.sfd.msa.user.exceptions.NotContentException;
import com.sfd.msa.user.model.UserEntity;
import com.sfd.msa.user.repository.UserRepository;
import com.sfd.msa.user.service.GenericService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements GenericService<UserDto, Integer> {

    private final UserRepository userRepository;
    private final UserDtoMapper userDtoMapper;

    @Override
    public List<UserDto> findAll() throws NotContentException {
        List<UserEntity> userEntities = userRepository.findAll();

        if(userEntities.isEmpty()){
            throw new NotContentException();
        }
        return userDtoMapper.toUserDtos(userEntities);
    }

    @Override
    public UserDto findById(Integer integer) {
        return null;
    }

    @Override
    public UserDto save(UserDto body) {
        return userDtoMapper.toUserDto(userRepository.save(userDtoMapper.toUserEntity(body)));
    }
}
