package com.misiontic.vacunautas2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.misiontic.vacunautas2.entity.RelNiñosVacunas;
import com.misiontic.vacunautas2.exceptions.GeneralServiceException;
import com.misiontic.vacunautas2.exceptions.NoDataFoundException;
import com.misiontic.vacunautas2.exceptions.ValidateServiceException;
import com.misiontic.vacunautas2.repository.RelNiñosVacunasRepository;
import com.misiontic.vacunautas2.validators.RelNiñosVacunasValidator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RelNiñosVacunasService {
	
	@Autowired
	private RelNiñosVacunasRepository relNiñosVacunasRepo;
	
	public RelNiñosVacunas findById(Long relNiñosVacunasId) {
		try {
			RelNiñosVacunas objRelNiñosVacunas = relNiñosVacunasRepo.findById(relNiñosVacunasId)
					.orElseThrow(() -> new NoDataFoundException("No existe el detalle de la relación niño-vacuna."));
			return objRelNiñosVacunas;
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public RelNiñosVacunas create(RelNiñosVacunas objRelNiñosVacunas) {
		try {
			RelNiñosVacunasValidator.validador(objRelNiñosVacunas);
			RelNiñosVacunas nuevoRelNiñosVacunas = relNiñosVacunasRepo.save(objRelNiñosVacunas);
			return nuevoRelNiñosVacunas;
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public RelNiñosVacunas update(RelNiñosVacunas objRelNiñosVacunas) {
		try {
			RelNiñosVacunasValidator.validador(objRelNiñosVacunas);
			RelNiñosVacunas objetoRelNiñosVacunas = relNiñosVacunasRepo.findById(objRelNiñosVacunas.getIdrelniñosvacunas())
					.orElseThrow(() -> new NoDataFoundException("No existe el detalle de la relación niño-vacuna."));
			
			objetoRelNiñosVacunas.setIdvacunas(objRelNiñosVacunas.getIdvacunas());
			objetoRelNiñosVacunas.setIdniños(objRelNiñosVacunas.getIdniños());
		
			
			relNiñosVacunasRepo.save(objetoRelNiñosVacunas);
			return objetoRelNiñosVacunas;
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}

	}

	@Transactional
	public void delete(Long relNiñosVacunasId) {
		try {
			RelNiñosVacunas objetoRelNiñosVacunas = relNiñosVacunasRepo.findById(relNiñosVacunasId)
					.orElseThrow(() -> new NoDataFoundException("No existe el detalle de la relación niño-vacuna."));
			relNiñosVacunasRepo.delete(objetoRelNiñosVacunas);
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}

	}

}
