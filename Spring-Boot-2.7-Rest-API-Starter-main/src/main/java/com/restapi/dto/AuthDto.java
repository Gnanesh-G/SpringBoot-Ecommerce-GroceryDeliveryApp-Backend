package com.restapi.dto;

import com.restapi.model.AppUser;
import com.restapi.request.RegisterRequest;
import com.restapi.response.AuthResponse;
import com.restapi.response.UserDetailsResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AuthDto {
    public AppUser mapToAppUser(RegisterRequest registerRequest) {
        AppUser appUser = new AppUser();
        appUser.setUsername(registerRequest.getUsername());
        appUser.setName(registerRequest.getName());
        appUser.setPassword(registerRequest.getPassword());
        return appUser;
    }


    public AuthResponse mapToAuthResponse(AppUser appUser) {
        AuthResponse authResponse = new AuthResponse();
        authResponse.setId(appUser.getId());
        authResponse.setName(appUser.getName());
        authResponse.setUsername(appUser.getUsername());
        authResponse.setRole(appUser.getRoles().getName());
        return authResponse;
    }

    public List<UserDetailsResponse> mapToUserDetails(List<AppUser> users) {
        List<UserDetailsResponse> userDetailsResponses=new ArrayList<>();
        for(AppUser user:users) {
            UserDetailsResponse userDetails=new UserDetailsResponse();
            userDetails.setId(user.getId());
            userDetails.setName(user.getName());
            userDetails.setUsername(user.getUsername());
            userDetails.setRoles(user.getRoles().getName());
            userDetails.setJoinedAt(user.getCreatedAt());
            userDetails.setAddressList(user.getAddressList());
            userDetailsResponses.add(userDetails);
        }
        return userDetailsResponses;
    }
}
