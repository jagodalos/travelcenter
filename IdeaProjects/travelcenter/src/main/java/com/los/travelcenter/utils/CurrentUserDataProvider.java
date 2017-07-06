package com.los.travelcenter.utils;

import com.los.travelcenter.user.User;
import com.los.travelcenter.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * Created by jagod on 12.06.2017.
 */
@Service
public class CurrentUserDataProvider {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public User getUser(){
        return userService.findByUserName(getUserName());
    }
    private String getUserName(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return principal instanceof UserDetails ?
                ((UserDetails)principal).getUsername() : principal.toString();
    }
}
