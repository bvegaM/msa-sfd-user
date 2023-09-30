package com.sfd.msa.user.dto.mapper;

import com.sfd.msa.user.dto.UserDto;
import com.sfd.services.server.models.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserGenerateMapper {

    User toUser(UserDto userDto);
    List<User> toUserGenerate(List<UserDto> userDtos);

    UserDto toUserDto(User userGenerate);
}
