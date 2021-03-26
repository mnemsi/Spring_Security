package com.mejdeddine.springSecurity.auth;

import java.util.Optional;

public interface ApplicationUserDAO {

     Optional<ApplicationUser> selectApplicationUserByUSerName(String username);
}
