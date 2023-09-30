package com.sfd.msa.user.dto.mapper;

import com.sfd.msa.user.dto.UserDto;
import com.sfd.msa.user.model.UserEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserDtoMapper {

    UserEntity toUserEntity(UserDto userDto);

    List<UserDto> toUserDtos(List<UserEntity> userEntities);
    UserDto toUserDto(UserEntity userEntity);

}
