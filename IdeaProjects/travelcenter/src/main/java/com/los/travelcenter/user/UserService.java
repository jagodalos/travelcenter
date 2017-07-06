package com.los.travelcenter.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jagod on 15.05.2017.
 */
@Service
public class UserService implements UserDetailsService{

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) {
        return userRepository.save(user);
    }


    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(s);
        if(user == null)
            throw new UsernameNotFoundException(s);
        return new UserDetailsImpl(user);
    }
    public User findByUserName(String name){
        User user = userRepository.findByUsername(name);
        if(user == null)
            throw new UsernameNotFoundException(name);
        return user;
    }
}
