package com.example.javaspring.config;

import com.example.javaspring.controller.UserController;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// @RestControllerAdvice // 모든 RestController에 대해 적용
@RestControllerAdvice(basePackageClasses = UserController.class) // RestController들 중 UserController에 대해서만 적용
public class ApiExceptionHandler {

    // 모든 Exception을 다 catch하도록 명시 (다른 @ExceptionHandler 등에서 처리되지 않은 모든 예외들에 대한 디폴트 처리)
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity defaultException(Exception e) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponse(false, e.getLocalizedMessage()));
        // Status Code 500
        // Response Body:
    }

    @ExceptionHandler(value = DataNotFoundException.class)
    public ResponseEntity notfound(RuntimeException e) { // 업캐스팅을 해야 RuntimeException(message)로 담긴 message 읽기 가능
        String error;
        if (e.getMessage() == null){
            error = "해당 데이터를 찾을 수 없습니다.";
        } else {
            error = e.getMessage();
        }
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(false, error));
    }

    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity badRequest(RuntimeException e) {
        String error;
        if (e.getMessage() == null){
            error = "잘못된 요청입니다";
        } else {
            error = e.getMessage();
        }
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(false, error));
    }

    @ExceptionHandler(value = NotAllowedException.class)
    public ResponseEntity notAllowed(RuntimeException e) {
        String error;
        if (e.getMessage() == null){
            error = "접근 권한이 없습니다.";
        } else {
            error = e.getMessage();
        }
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body(new ErrorResponse(false, error));
    }
}

@Data
@AllArgsConstructor
class ErrorResponse {
    Boolean ok;
    String error;
}




