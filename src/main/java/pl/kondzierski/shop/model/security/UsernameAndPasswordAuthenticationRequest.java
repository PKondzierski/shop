package pl.kondzierski.shop.model.security;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UsernameAndPasswordAuthenticationRequest {
    private String username;
    private String password;

}
