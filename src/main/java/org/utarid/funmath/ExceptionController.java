package org.utarid.funmath;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.utarid.funmath.model.ResponseModel;

import java.util.List;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseModel> handleBindException(MethodArgumentNotValidException exception) {
        List<String> errorList = exception.getFieldErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList();
        return ResponseEntity.badRequest().body(new ResponseModel("1", errorList));
    }
}
