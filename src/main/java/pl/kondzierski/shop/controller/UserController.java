package pl.kondzierski.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.kondzierski.shop.exception.UserNotFoundException;
import pl.kondzierski.shop.model.User;
import pl.kondzierski.shop.repository.UserRepository;
import pl.kondzierski.shop.security.config.PasswordConfig;
import pl.kondzierski.shop.security.service.ApplicationUserService;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private ApplicationUserService applicationUserService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordConfig passwordConfig;


    @GetMapping("/{user}")
    @PreAuthorize("hasAuthority('insert_user') or hasAuthority('read_user')")
    public ResponseEntity<User> rest(@PathVariable String user) throws UserNotFoundException {
        Optional<User> optionalUser = userRepository.findByUsername(user);
        if(optionalUser.isPresent())
            return new ResponseEntity<User>(optionalUser.get(), HttpStatus.FOUND);

        throw UserNotFoundException.createException(String.format("User %s not found",user));
    }

}
