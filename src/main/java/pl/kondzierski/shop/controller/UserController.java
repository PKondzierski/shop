package pl.kondzierski.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import pl.kondzierski.shop.error.HttpUnauthorizedException;
import pl.kondzierski.shop.error.MyErrorsHandler;
import pl.kondzierski.shop.model.User;
import pl.kondzierski.shop.repository.UserRepository;
import pl.kondzierski.shop.security.config.PasswordConfig;
import pl.kondzierski.shop.security.service.ApplicationUserService;

import javax.servlet.http.HttpServletResponse;

@RestController
public class UserController {

    @Autowired
    private ApplicationUserService applicationUserService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordConfig passwordConfig;


    @GetMapping("/")
    @PreAuthorize("hasAuthority('insert_user')")
    public User rest(){
        return userRepository.findById(1L).orElseThrow();
    }

}
