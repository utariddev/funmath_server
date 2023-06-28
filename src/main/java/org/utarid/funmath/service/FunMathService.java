package org.utarid.funmath.service;

import org.utarid.funmath.dto.ResultDTO;
import org.utarid.funmath.dto.UserDTO;


public interface FunMathService {
    boolean saveUser(UserDTO user);

    boolean getUser(UserDTO user);

    boolean saveResult(ResultDTO resultDTO);
}
