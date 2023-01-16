package com.misiontic.vacunautas2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.misiontic.vacunautas2.entity.Vacunas;
import com.misiontic.vacunautas2.exceptions.GeneralServiceException;
import com.misiontic.vacunautas2.exceptions.NoDataFoundException;
import com.misiontic.vacunautas2.exceptions.ValidateServiceException;
import com.misiontic.vacunautas2.repository.VacunasRepository;
import com.misiontic.vacunautas2.validators.VacunasValidator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class VacunasService {
	
	@Autowired
	private VacunasRepository vacunasRepo;
	
	public List<Vacunas> findAll() {
		try {
			List<Vacunas> arregloVacunas = vacunasRepo.findAll();
			return arregloVacunas;
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	public Vacunas findById(Long vacunasId) {
		try {
			Vacunas objVacunas = vacunasRepo.findById(vacunasId)
					.orElseThrow(() -> new NoDataFoundException("No existe la Vacuna."));
			return objVacunas;
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public Vacunas create(Vacunas vacunas) {
		try {
			VacunasValidator.validador(vacunas);
			Vacunas nuevoVacunas = vacunasRepo.save(vacunas);
			return nuevoVacunas;
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public Vacunas update(Vacunas vacunas) {
		try {
			VacunasValidator.validador(vacunas);
			Vacunas objVacunas = vacunasRepo.findById(vacunas.getIdvacunas())
					.orElseThrow(() -> new NoDataFoundException("No existe la vacuna."));
			
			objVacunas.setNombre(vacunas.getNombre());
			objVacunas.setDosis(vacunas.getDosis());
			objVacunas.setLaboratorio(vacunas.getLaboratorio());
			objVacunas.setLote(vacunas.getLote());
			objVacunas.setViaaplicacion(vacunas.getViaaplicacion());
			objVacunas.setEstado(vacunas.getEstado());
			objVacunas.setUnidades(vacunas.getUnidades());
			
		
			
			
			vacunasRepo.save(objVacunas);
			return objVacunas;
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}

	}

	@Transactional
	public void delete(Long vacunasId) {
		try {
			Vacunas objVacunas = vacunasRepo.findById(vacunasId)
					.orElseThrow(() -> new NoDataFoundException("No existe la vacuna."));
			vacunasRepo.delete(objVacunas);
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}

	}

}
