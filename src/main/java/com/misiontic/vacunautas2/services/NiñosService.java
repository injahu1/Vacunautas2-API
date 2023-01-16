package com.misiontic.vacunautas2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.misiontic.vacunautas2.entity.Niños;
import com.misiontic.vacunautas2.exceptions.GeneralServiceException;
import com.misiontic.vacunautas2.exceptions.NoDataFoundException;
import com.misiontic.vacunautas2.exceptions.ValidateServiceException;
import com.misiontic.vacunautas2.repository.NiñosRepository;
import com.misiontic.vacunautas2.validators.NiñosValidator;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class NiñosService {
	
	@Autowired
	private NiñosRepository niñosRepo;
	
	public List<Niños> findAll() {
		try {
			List<Niños> arregloNiños = niñosRepo.findAll();
			return arregloNiños;
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	public Niños findById(Long niñosId) {
		try {
			Niños objNiños = niñosRepo.findById(niñosId)
					.orElseThrow(() -> new NoDataFoundException("No existe el niño."));
			return objNiños;
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public Niños create(Niños niños) {
		try {
			NiñosValidator.validador(niños);
			Niños nuevoNiños = niñosRepo.save(niños);
			return nuevoNiños;
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public Niños update(Niños niños) {
		try {
			NiñosValidator.validador(niños);
			Niños objNiños = niñosRepo.findById(niños.getIdniños())
					.orElseThrow(() -> new NoDataFoundException("No existe la cita."));
			
			objNiños.setIdentificacion(niños.getIdentificacion());
			objNiños.setNombres(niños.getNombres());
			objNiños.setApellidos(niños.getApellidos());
			objNiños.setFechanacimiento(niños.getFechanacimiento());
			objNiños.setGenero(niños.getGenero());
			objNiños.setEstado(niños.getEstado());
		
			
			niñosRepo.save(objNiños);
			return objNiños;
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}

	}

	@Transactional
	public void delete(Long niñosId) {
		try {
			Niños objNiños = niñosRepo.findById(niñosId)
					.orElseThrow(() -> new NoDataFoundException("No existe el niño."));
			niñosRepo.delete(objNiños);
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}

	}

}
