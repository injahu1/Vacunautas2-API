package com.misiontic.vacunautas2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.misiontic.vacunautas2.entity.Enfermeras;
import com.misiontic.vacunautas2.exceptions.GeneralServiceException;
import com.misiontic.vacunautas2.exceptions.NoDataFoundException;
import com.misiontic.vacunautas2.exceptions.ValidateServiceException;
import com.misiontic.vacunautas2.repository.EnfermerasRepository;
import com.misiontic.vacunautas2.validators.EnfermerasValidator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EnfermerasService {
	
	@Autowired
	private EnfermerasRepository enfermerasRepo;
	
	public List<Enfermeras> findAll() {
		try {
			List<Enfermeras> arregloEnfermeras = enfermerasRepo.findAll();
			return arregloEnfermeras;
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	public Enfermeras findById(Long enfermerasId) {
		try {
			Enfermeras objEnfermeras = enfermerasRepo.findById(enfermerasId)
					.orElseThrow(() -> new NoDataFoundException("No existe la enfermera."));
			return objEnfermeras;
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public Enfermeras create(Enfermeras enfermeras) {
		try {
			EnfermerasValidator.validador(enfermeras);
			Enfermeras nuevoEnfermeras = enfermerasRepo.save(enfermeras);
			return nuevoEnfermeras;
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public Enfermeras update(Enfermeras enfermeras) {
		try {
			EnfermerasValidator.validador(enfermeras);
			Enfermeras objEnfermeras = enfermerasRepo.findById(enfermeras.getIdenfermeras())
					.orElseThrow(() -> new NoDataFoundException("No existe la enfermera."));
			
			objEnfermeras.setIdentificacion(enfermeras.getIdentificacion());
			objEnfermeras.setNombres(enfermeras.getNombres());
			objEnfermeras.setApellidos(enfermeras.getApellidos());
			objEnfermeras.setTelefono(enfermeras.getTelefono());
			objEnfermeras.setCelular(enfermeras.getCelular());
			objEnfermeras.setDireccion(enfermeras.getDireccion());
			objEnfermeras.setEmail(enfermeras.getEmail());
			objEnfermeras.setFechanacimiento(enfermeras.getFechanacimiento());
			objEnfermeras.setGenero(enfermeras.getGenero());
			objEnfermeras.setTitulo(enfermeras.getTitulo());
			objEnfermeras.setEstado(enfermeras.getEstado());
			objEnfermeras.setLogin(enfermeras.getLogin());
			objEnfermeras.setClave(enfermeras.getClave());

			
			enfermerasRepo.save(objEnfermeras);
			
			return objEnfermeras;
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}

	}

	@Transactional
	public void delete(Long enfermerasId) {
		try {
			Enfermeras objEnfermeras = enfermerasRepo.findById(enfermerasId)
					.orElseThrow(() -> new NoDataFoundException("No existe la enfermera."));
			
			enfermerasRepo.delete(objEnfermeras);
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}

	}

}
