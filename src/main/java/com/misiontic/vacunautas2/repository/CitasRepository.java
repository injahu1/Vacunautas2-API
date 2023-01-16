package com.misiontic.vacunautas2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.misiontic.vacunautas2.entity.Citas;

@Repository
public interface CitasRepository extends JpaRepository<Citas, Long> {
	
}
