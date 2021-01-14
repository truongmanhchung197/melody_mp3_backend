package com.c0720i2.melody.service.guest;

import com.c0720i2.melody.model.Guest;
import com.c0720i2.melody.repository.IGuestRepository;
import com.c0720i2.melody.service.IGeneralService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class GuestService implements IGeneralService<Guest> {

    @Autowired
    private IGuestRepository iGuestRepository;

    @Override
    public Optional<Guest> findById(Long id) {
        return iGuestRepository.findById(id);
    }

    @Override
    public Iterable<Guest> findAll() {
        return iGuestRepository.findAll();
    }

    @Override
    public void remove(Long id) {
        iGuestRepository.deleteById(id);
    }

    @Override
    public Guest save(Guest guest) {
        return iGuestRepository.save(guest);
    }
}
