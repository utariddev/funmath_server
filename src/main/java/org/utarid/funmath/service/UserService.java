package org.utarid.funmath.service;

import org.utarid.funmath.dto.UserDTO;


public interface UserService {
    boolean saveUser(UserDTO user);

    boolean getUser(UserDTO user);
}
