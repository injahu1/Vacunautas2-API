package com.misiontic.vacunautas2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.misiontic.vacunautas2.entity.Citas;
import com.misiontic.vacunautas2.exceptions.GeneralServiceException;
import com.misiontic.vacunautas2.exceptions.NoDataFoundException;
import com.misiontic.vacunautas2.exceptions.ValidateServiceException;
import com.misiontic.vacunautas2.repository.CitasRepository;
import com.misiontic.vacunautas2.validators.CitasValidator;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CitasService {
	
	@Autowired
	private CitasRepository citasRepo;
	
	public List<Citas> findAll() {
		try {
			List<Citas> arregloCitas = citasRepo.findAll();
			return arregloCitas;
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	public Citas findById(Long citasId) {
		try {
			Citas objCitas = citasRepo.findById(citasId)
					.orElseThrow(() -> new NoDataFoundException("No existe la cita."));
			return objCitas;
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public Citas create(Citas citas) {
		try {
			CitasValidator.validador(citas);
			Citas nuevoCitas = citasRepo.save(citas);
			return nuevoCitas;
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public Citas update(Citas citas) {
		try {
			CitasValidator.validador(citas);
			Citas objCitas = citasRepo.findById(citas.getIdcitas())
					.orElseThrow(() -> new NoDataFoundException("No existe la cita."));
			
			objCitas.setIdvacunas(citas.getIdvacunas());
			objCitas.setIdenfermeras(citas.getIdenfermeras());
			objCitas.setIdniños(citas.getIdniños());
			objCitas.setFecha(citas.getFecha());
			objCitas.setHora(citas.getHora());
			objCitas.setLugar(citas.getLugar());
			objCitas.setComentarios(citas.getComentarios());
			objCitas.setEstado(citas.getEstado());
		
			
			citasRepo.save(objCitas);
			return objCitas;
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}

	}

	@Transactional
	public void delete(Long citasId) {
		try {
			Citas objCitas = citasRepo.findById(citasId)
					.orElseThrow(() -> new NoDataFoundException("No existe la cita."));
			citasRepo.delete(objCitas);
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}

	}

}
