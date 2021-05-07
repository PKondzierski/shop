package pl.kondzierski.shop.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.util.WebUtils;
import java.util.Collections;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler({UserNotFoundException.class})
    protected ResponseEntity<ApiError> handleAuthenticationError(Exception exception, WebRequest webRequest)
    {
        LOGGER.info(String.format("Handling exception class %s due to %s",exception.getClass().getSimpleName(), exception.getMessage()));
        HttpHeaders httpHeaders = new HttpHeaders();

        if(exception instanceof UserNotFoundException){
            HttpStatus httpStatus = HttpStatus.UNAUTHORIZED;
            UserNotFoundException userNotAuthorized = (UserNotFoundException) exception;

            return handleUserNotAuthorizedException(userNotAuthorized, httpStatus, httpHeaders, webRequest);
        }
        else{
            if(LOGGER.isErrorEnabled())
                LOGGER.info(String.format("Unknown exception type: %s", exception.getClass().getName()));

            HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            return handleExceptionInternal(exception, null, httpHeaders, httpStatus, webRequest);
        }

    }

    private ResponseEntity<ApiError> handleUserNotAuthorizedException(UserNotFoundException exception,
                                                                      HttpStatus httpStatus,
                                                                      HttpHeaders httpHeaders,
                                                                      WebRequest webRequest
                                                                      ){
        List<String> apiErrors = Collections.singletonList(exception.getMessage());
        return handleExceptionInternal(exception, new ApiError(apiErrors), httpHeaders, httpStatus, webRequest);
    }

    protected ResponseEntity<ApiError> handleExceptionInternal(Exception ex, @Nullable ApiError body,
                                                               HttpHeaders headers, HttpStatus status,
                                                               WebRequest request) {
        if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
            request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
        }

        return new ResponseEntity<>(body, headers, status);
    }
}
