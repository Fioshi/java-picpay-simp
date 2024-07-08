package Fioshi.com.github.PicPaySimplificado.infra.Security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class AuthenticateFacade {

    public Authentication getAuthentication(){
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public String getCurrentUser(){
        return getAuthentication().getName();
    }

    public UserDetails getCurrentUserDetails(){
        if (getAuthentication().getPrincipal() instanceof  UserDetails){
            return (UserDetails) getAuthentication().getPrincipal();
        }
        return null;
    }
}