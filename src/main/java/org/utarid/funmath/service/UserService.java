package org.utarid.funmath.service;

import org.springframework.stereotype.Service;
import org.utarid.funmath.dto.UserDTO;
import org.utarid.funmath.entity.UserEntity;


public interface UserService {
    boolean saveUser(UserDTO user);
}
