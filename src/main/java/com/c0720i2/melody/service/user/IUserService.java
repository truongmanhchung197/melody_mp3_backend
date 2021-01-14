package com.c0720i2.melody.service.user;

import com.c0720i2.melody.model.User;
import com.c0720i2.melody.service.IGeneralService;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends IGeneralService<User>, UserDetailsService {
    User findByUsername(String username);
}
