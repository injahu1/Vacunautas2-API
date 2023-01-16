package com.misiontic.vacunautas2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.misiontic.vacunautas2.entity.RelAcudientesNiños;
import com.misiontic.vacunautas2.exceptions.GeneralServiceException;
import com.misiontic.vacunautas2.exceptions.NoDataFoundException;
import com.misiontic.vacunautas2.exceptions.ValidateServiceException;
import com.misiontic.vacunautas2.repository.RelAcudientesNiñosRepository;
import com.misiontic.vacunautas2.validators.RelAcudientesNiñosValidator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RelAcudientesNiñosService {
	
	@Autowired
	private RelAcudientesNiñosRepository relAcudientesNiñosRepo;
	
	public RelAcudientesNiños findById(Long relAcudientesNiñosId) {
		try {
			RelAcudientesNiños objRelAcudientesNiños = relAcudientesNiñosRepo.findById(relAcudientesNiñosId)
					.orElseThrow(() -> new NoDataFoundException("No existe el detalle de la relación acudiente-niño."));
			return objRelAcudientesNiños;
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public RelAcudientesNiños create(RelAcudientesNiños objRelAcudientesNiños) {
		try {
			RelAcudientesNiñosValidator.validador(objRelAcudientesNiños);
			RelAcudientesNiños nuevoRelAcudientesNiños = relAcudientesNiñosRepo.save(objRelAcudientesNiños);
			return nuevoRelAcudientesNiños;
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public RelAcudientesNiños update(RelAcudientesNiños objRelAcudientesNiños) {
		try {
			RelAcudientesNiñosValidator.validador(objRelAcudientesNiños);
			RelAcudientesNiños objetoRelAcudientesNiños = relAcudientesNiñosRepo.findById(objRelAcudientesNiños.getIdrelacudientesniños())
					.orElseThrow(() -> new NoDataFoundException("No existe el detalle de la relación acudiente-niño."));
			
			objetoRelAcudientesNiños.setIdniños(objRelAcudientesNiños.getIdniños());
			objetoRelAcudientesNiños.setIdacudientes(objRelAcudientesNiños.getIdacudientes());
		
			relAcudientesNiñosRepo.save(objetoRelAcudientesNiños);
			return objetoRelAcudientesNiños;
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}

	}

	@Transactional
	public void delete(Long relAcudientesNiñosId) {
		try {
			RelAcudientesNiños objetoRelAcudientesNiños = relAcudientesNiñosRepo.findById(relAcudientesNiñosId)
					.orElseThrow(() -> new NoDataFoundException("No existe el detalle de la relación acudiente-niño."));
			relAcudientesNiñosRepo.delete(objetoRelAcudientesNiños);
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}

	}

}
