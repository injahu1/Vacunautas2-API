package com.misiontic.vacunautas2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.misiontic.vacunautas2.entity.Vacunas;

@Repository
public interface VacunasRepository extends JpaRepository<Vacunas, Long> {
	
}
