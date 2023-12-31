package org.utarid.funmath.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.utarid.funmath.dto.UserDTO;
import org.utarid.funmath.entity.UserEntity;

@Mapper
public interface UserMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "registerDate", expression = "java(java.time.LocalDateTime.now())")
    UserEntity userDTOToUserEntity(UserDTO userDTO);

    UserDTO userEntityToUserDTO(UserEntity userEntity);
}