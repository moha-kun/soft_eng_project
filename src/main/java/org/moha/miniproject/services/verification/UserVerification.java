package org.moha.miniproject.services.verification;

import org.moha.miniproject.Repositories.UserRepository;
import org.moha.miniproject.enteties.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UserVerification {

    @Autowired
    private UserRepository userRepository;

    public boolean checkUser(Long idUser) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        User user = userRepository.findByEmail(username).get();
        if (user.getId() == idUser)
            return true;
        else
            return false;
    }

}
