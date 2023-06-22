package org.utarid.funmath.service;

import org.springframework.stereotype.Service;
import org.utarid.funmath.dto.UserDTO;
import org.utarid.funmath.entity.UserEntity;
import org.utarid.funmath.mapper.UserMapper;
import org.utarid.funmath.mapper.UserMapperImpl;
import org.utarid.funmath.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean saveUser(UserDTO user) {
        UserMapper userMapper = new UserMapperImpl();
        repository.save(userMapper.userDTOToUserEntity(user));
        return true;
    }

    @Override
    public boolean getUser(UserDTO user) {
        UserEntity userEntity = repository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        return userEntity != null;
    }
}
