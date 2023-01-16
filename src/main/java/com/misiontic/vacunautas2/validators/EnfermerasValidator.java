package com.misiontic.vacunautas2.validators;


import com.misiontic.vacunautas2.entity.Enfermeras;
import com.misiontic.vacunautas2.exceptions.ValidateServiceException;



public class EnfermerasValidator {
	
	public static void validador (Enfermeras enfermeras) {
		
		if (enfermeras.getIdenfermeras() == null) {
			throw new ValidateServiceException("El idenfermera es obligatorio.");
		}
		
		if (enfermeras.getIdentificacion() == null) {
			throw new ValidateServiceException("La identificacion es obligatoria.");
		}
		
		if (enfermeras.getNombres() == null) {
			throw new ValidateServiceException("El nombre es obligatorio.");
		}
		
		if (enfermeras.getFechanacimiento() == null) {
			throw new ValidateServiceException("La fecha es obligatorio.");
		}
		
		if (enfermeras.getApellidos() == null) {
			throw new ValidateServiceException("El apellido es obligatorio.");
		}
		
		if (enfermeras.getCelular() == null) {
			throw new ValidateServiceException("El celular es obligatorio.");
		}
		
		if (enfermeras.getGenero() == null) {
			throw new ValidateServiceException("El Genero es obligatorio.");
		}
		
		if (enfermeras.getEmail() == null) {
			throw new ValidateServiceException("El email es obligatorio.");
		}
		
		if (enfermeras.getTitulo() == null) {
			throw new ValidateServiceException("El titulo es obligatorio.");
		}
	
	}
	
}
