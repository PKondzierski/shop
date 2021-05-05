package pl.kondzierski.shop.error;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
@Component
public class HttpUnauthorizedException extends RuntimeException {
    public HttpUnauthorizedException() {
        super("Brak autoryzacji");
    }
}