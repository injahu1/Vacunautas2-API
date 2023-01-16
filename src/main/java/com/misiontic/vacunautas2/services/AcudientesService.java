package com.misiontic.vacunautas2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.misiontic.vacunautas2.entity.Acudientes;
import com.misiontic.vacunautas2.exceptions.GeneralServiceException;
import com.misiontic.vacunautas2.exceptions.NoDataFoundException;
import com.misiontic.vacunautas2.exceptions.ValidateServiceException;
import com.misiontic.vacunautas2.repository.AcudientesRepository;
import com.misiontic.vacunautas2.validators.AcudientesValidator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AcudientesService {
	
	@Autowired
	private AcudientesRepository acudientesRepo;
	
	public List<Acudientes> findAll() {
		try {
			List<Acudientes> arregloAcudientes = acudientesRepo.findAll();
			return arregloAcudientes;
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	public Acudientes findById(Long acudientesId) {
		try {
			Acudientes objAcudientes = acudientesRepo.findById(acudientesId)
					.orElseThrow(() -> new NoDataFoundException("No existe el acudiente."));
			return objAcudientes;
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public Acudientes create(Acudientes acudientes) {
		try {
			AcudientesValidator.validador(acudientes);
			Acudientes nuevoAcudientes = acudientesRepo.save(acudientes);
			return nuevoAcudientes;
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public Acudientes update(Acudientes acudientes) {
		try {
			AcudientesValidator.validador(acudientes);
			Acudientes objAcudientes = acudientesRepo.findById(acudientes.getIdacudientes())
					.orElseThrow(() -> new NoDataFoundException("No existe el acudiente."));
			
			objAcudientes.setIdentificacion(acudientes.getIdentificacion());
			objAcudientes.setNombres(acudientes.getNombres());
			objAcudientes.setApellidos(acudientes.getApellidos());
			objAcudientes.setTelefono(acudientes.getTelefono());
			objAcudientes.setCelular(acudientes.getCelular());
			objAcudientes.setDireccion(acudientes.getDireccion());
			objAcudientes.setEmail(acudientes.getEmail());
			objAcudientes.setFechanacimiento(acudientes.getFechanacimiento());
			objAcudientes.setGenero(acudientes.getGenero());
			objAcudientes.setParentesco(acudientes.getParentesco());
			objAcudientes.setEstado(acudientes.getEstado());
			objAcudientes.setLogin(acudientes.getLogin());
			objAcudientes.setClave(acudientes.getClave());

			
			acudientesRepo.save(objAcudientes);
			
			return objAcudientes;
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}

	}

	@Transactional
	public void delete(Long acudientesId) {
		try {
			Acudientes objAcudientes = acudientesRepo.findById(acudientesId)
					.orElseThrow(() -> new NoDataFoundException("No existe el acudiente."));
			
			acudientesRepo.delete(objAcudientes);
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}

	}

}
