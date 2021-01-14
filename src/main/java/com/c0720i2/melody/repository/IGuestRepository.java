package com.c0720i2.melody.repository;

import com.c0720i2.melody.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGuestRepository extends JpaRepository<Guest,Long> {
}
