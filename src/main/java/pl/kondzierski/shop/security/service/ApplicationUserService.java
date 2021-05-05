package pl.kondzierski.shop.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.kondzierski.shop.model.User;
import pl.kondzierski.shop.repository.UserRepository;
import pl.kondzierski.shop.model.security.LoginCredentials;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ApplicationUserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public ApplicationUserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username).orElseThrow(
                ()->new UsernameNotFoundException(String.format("Username %s not found", username)));

        return new LoginCredentials(user.getUsername(), user.getPassword(), createGrantedAuthorities(user));

    }


    private Set<SimpleGrantedAuthority> createGrantedAuthorities(User user){
        Set<SimpleGrantedAuthority> permissions = user.getRole().getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermissionName()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_"+user.getRole().getRoleName()));
        return permissions;
    }

}
