package pl.kondzierski.shop.error;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MyErrorsHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(HttpClientErrorException.Unauthorized.class)
    protected ResponseEntity<Object> handleAuthenticationError(RuntimeException ex, WebRequest request)
    {
        return handleExceptionInternal(ex,
                "Cannot login, please check your inputs",
                new HttpHeaders(), HttpStatus.UNAUTHORIZED, request);
    }
}
