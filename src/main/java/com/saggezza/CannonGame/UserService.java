package com.saggezza.CannonGame;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRespository userRespository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserModel foundUser = userRespository.findByUserName(username);
        if (foundUser==null) return null;

        String name = foundUser.getUsername();
        String pwd = foundUser.getPassword();

        return new User(name, pwd, null);
    }
}
