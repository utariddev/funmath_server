package org.utarid.funmath.service;

import org.utarid.funmath.dto.ResultDTO;
import org.utarid.funmath.dto.UserDTO;
import org.utarid.funmath.model.ResponseModel;
import org.utarid.funmath.model.SaveResultResponseModel;


public interface FunMathService {
    boolean saveUser(UserDTO user);

    boolean getUser(UserDTO user);

    ResponseModel<SaveResultResponseModel> saveResult(ResultDTO resultDTO);
}
