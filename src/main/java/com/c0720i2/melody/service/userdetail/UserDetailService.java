package com.c0720i2.melody.service.userdetail;

import com.c0720i2.melody.model.UserDetail;
import com.c0720i2.melody.repository.IUserDetailRepository;
import com.c0720i2.melody.service.IGeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailService implements IUserDetailService {

    @Autowired
    private IUserDetailRepository iUserDetailRepository;

    @Override
    public Optional<UserDetail> findById(Long id) {
        return iUserDetailRepository.findById(id);
    }

    @Override
    public Iterable<UserDetail> findAll() {
        return iUserDetailRepository.findAll();
    }

    @Override
    public void remove(Long id) {
        iUserDetailRepository.deleteById(id);
    }

    @Override
    public UserDetail save(UserDetail guest) {
        return iUserDetailRepository.save(guest);
    }
}
