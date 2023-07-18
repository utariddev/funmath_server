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
import org.utarid.funmath.model.ResponseModel;
import org.utarid.funmath.model.SaveResultResponseModel;
import org.utarid.funmath.repository.ResultRepository;
import org.utarid.funmath.repository.UserRepository;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

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
    public ResponseModel<SaveResultResponseModel> saveResult(ResultDTO result) {
        ResultMapper resultMapper = new ResultMapperImpl();

        UserEntity user = new UserEntity();
        user.setId(result.getUserId());

        ResultEntity resultEntity = resultMapper.resultDTOToResultEntity(result);
        resultEntity.setUser(user);

        Optional<ResultEntity> existingResult = resultRepository.findByUserId(result.getUserId());

        if (existingResult.isPresent()) {
            ResultEntity currentResult = existingResult.get();
            Long newResultValue = currentResult.getResult() + result.getResult();
            currentResult.setResult(newResultValue);
            resultEntity = resultRepository.save(currentResult);
        } else {
            resultEntity = resultRepository.save(resultEntity);
        }

        int weeklyPosition = getOrdinalPositionOfLastInsertedResult(resultEntity.getId());

        SaveResultResponseModel saveResultResponseModel = new SaveResultResponseModel();
        saveResultResponseModel.setWeeklyPosition(weeklyPosition);

        ResponseModel<SaveResultResponseModel> responseModel = new ResponseModel<>();
        responseModel.setData(saveResultResponseModel);

        return responseModel;
    }

    public int getOrdinalPositionOfLastInsertedResult(Long lastId) {
        int currentWeek = Calendar.getInstance().get(Calendar.WEEK_OF_YEAR) - 1;
        List<ResultEntity> sortedResults = resultRepository.findAllByWeekOrder(currentWeek);

        Optional<ResultEntity> optionalResult = sortedResults.stream()
                .filter(result -> result.getId().equals(lastId))
                .findFirst();

        return optionalResult.map(result -> sortedResults.indexOf(result) + 1).orElse(-1);
    }
}
