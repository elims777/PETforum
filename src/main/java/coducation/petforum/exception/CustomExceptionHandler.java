package coducation.petforum.exception;


import coducation.petforum.dto.ExceptionDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@Slf4j
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {CustomException.class})
    protected ResponseEntity<ExceptionDto> exceptionHandler(Exception ex, WebRequest request) {
        log.error(ex.toString(), ex);
        return ResponseEntity.badRequest().body(new ExceptionDto(ex.getMessage(), HttpStatus.BAD_REQUEST.value()));
    }
}
