package com.sport.coach.repository.dao;

import com.sport.coach.domain.security.Authority;
import com.sport.coach.domain.user.User;
import java.util.ArrayList;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author luku00
 */
public class RepositoryUserDetailsService implements UserDetailsService {

    private SportCoachDao sportCoachDao;

    public RepositoryUserDetailsService(SportCoachDao sportCoachDao) {
        this.sportCoachDao = sportCoachDao;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = sportCoachDao.getUser(login);
        if (user == null) {
            throw new UsernameNotFoundException("No user found with username: " + login);
        }
        List<GrantedAuthority> authority = new ArrayList<>();
        authority.add(new Authority(user.getRole().name()));
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUserIdentification().getUserLogin(),
                user.getUserIdentification().getUserPassword(), true, true, true, true, authority);
        return userDetails;
    }

}
