package com.c0720i2.melody.service.userdetail;

import com.c0720i2.melody.model.User;
import com.c0720i2.melody.model.UserDetail;
import com.c0720i2.melody.service.IGeneralService;

public interface IUserDetailService extends IGeneralService<UserDetail> {
    UserDetail getUserDetailByUser(User user);
}
