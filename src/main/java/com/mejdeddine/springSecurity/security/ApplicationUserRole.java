package com.mejdeddine.springSecurity.security;

import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.mejdeddine.springSecurity.security.ApplicationUserPermission.*;

public enum ApplicationUserRole {
    STUDENT(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(COURSE_READ,COURSE_WRITE,STUDENT_READ,STUDENT_WRITE)),
    ADMINTRAINEE(Sets.newHashSet(COURSE_READ,STUDENT_READ));

    //define the actual permissions
    @Autowired
    private final Set<ApplicationUserPermission> permissions;
    //constructor of dependency injection
     ApplicationUserRole(Set<ApplicationUserPermission> permissions) {

         this.permissions = permissions;
    }
    //Getter
    public Set<ApplicationUserPermission> getPermissions() {

         return permissions;
    }

    //authorities method
    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                                                                  .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                                                                  .collect(Collectors.toSet());

        permissions.add(new SimpleGrantedAuthority("ROLE_"+this.name()));

        return permissions;
    }
}
