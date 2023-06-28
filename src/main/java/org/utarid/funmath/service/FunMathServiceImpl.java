package org.utarid.funmath.service;

import org.springframework.stereotype.Service;
import org.utarid.funmath.dto.ResultDTO;
import org.utarid.funmath.dto.UserDTO;
import org.utarid.funmath.entity.ResultEntity;
import org.utarid.funmath.entity.UserEntity;
import org.utarid.funmath.mapper.ResultMapper;
import org.utarid.funmath.mapper.ResultMapperImpl;
import org.utarid.funmath.mapper.UserMapper;
import org.utarid.funmath.mapper.UserMapperImpl;
import org.utarid.funmath.repository.ResultRepository;
import org.utarid.funmath.repository.UserRepository;

@Service
public class FunMathServiceImpl implements FunMathService {

    private final UserRepository userRepository;
    private final ResultRepository resultRepository;


    public FunMathServiceImpl(UserRepository userRepository, ResultRepository resultRepository) {
        this.userRepository = userRepository;
        this.resultRepository = resultRepository;
    }

    @Override
    public boolean saveUser(UserDTO user) {
        UserMapper userMapper = new UserMapperImpl();
        userRepository.save(userMapper.userDTOToUserEntity(user));
        return true;
    }

    @Override
    public boolean getUser(UserDTO user) {
        UserEntity userEntity = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        return userEntity != null;
    }

    @Override
    public boolean saveResult(ResultDTO result) {
        ResultMapper resultMapper = new ResultMapperImpl();

        UserEntity user = new UserEntity();
        user.setId(result.getUserId());

        ResultEntity resultEntity = resultMapper.resultDTOToResultEntity(result);
        resultEntity.setUser(user);

        resultRepository.save(resultEntity);
        return true;
    }
}
