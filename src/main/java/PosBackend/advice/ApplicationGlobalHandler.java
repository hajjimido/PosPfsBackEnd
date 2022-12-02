package PosBackend.advice;

import PosBackend.advice.Exception.UserException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationGlobalHandler {
    @ResponseBody
    @ExceptionHandler(UserException.class)
    public ResponseEntity handlerException(UserException e){
        return ResponseEntity.status(400).body(e.getMessage());

    }


}
