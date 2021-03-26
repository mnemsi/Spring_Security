package com.mejdeddine.springSecurity.auth;

import com.google.common.collect.Lists;
import com.mejdeddine.springSecurity.security.PasswordConfig;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

import static com.mejdeddine.springSecurity.security.ApplicationUserRole.*;


@Repository("fake")
public class FakeApplicationUserDAOService implements ApplicationUserDAO{
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUSerName(String username) {
        return getApplicationUsers().stream().filter(element-> element.getUsername()==username).findFirst();
    }

    private List<ApplicationUser> getApplicationUsers(){
        List<ApplicationUser> applicationUsers = Lists.newArrayList(
                                                        new ApplicationUser(
                                                                "user",
                                                                passwordEncoder.encode("user"),
                                                                STUDENT.getGrantedAuthorities(),
                                                                true,
                                                                true,
                                                                true,
                                                                true),
                                                        new ApplicationUser(
                                                                "admin",
                                                                passwordEncoder.encode("admin"),
                                                                ADMIN.getGrantedAuthorities(),
                                                                true,
                                                                true,
                                                                true,
                                                                true),
                                                        new ApplicationUser(
                                                                "admintrainee",
                                                                passwordEncoder.encode("admintrainee"),
                                                                ADMINTRAINEE.getGrantedAuthorities(),
                                                                true,
                                                                true,
                                                                true,
                                                                true));

        return applicationUsers;
    }
}
