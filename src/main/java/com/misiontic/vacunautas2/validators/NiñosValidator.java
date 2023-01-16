package com.misiontic.vacunautas2.validators;


import com.misiontic.vacunautas2.entity.Niños;
import com.misiontic.vacunautas2.exceptions.ValidateServiceException;



public class NiñosValidator {
	
	public static void validador (Niños niños) {
		
		if (niños.getIdniños() == null) {
			throw new ValidateServiceException("El idniños es obligatorio.");
		}
		
		if (niños.getIdentificacion() == null) {
			throw new ValidateServiceException("La identificación es obligatoria.");
		}
		
		if (niños.getNombres() == null) {
			throw new ValidateServiceException("Los nombres son obligatorios.");
		}
		
		if (niños.getApellidos() == null) {
			throw new ValidateServiceException("Los apellidos son obligatorios.");
		}
		
		if (niños.getFechanacimiento() == null) {
			throw new ValidateServiceException("La fecha de nacimiento es obligatoria.");
		}
		
		if (niños.getGenero() == null) {
			throw new ValidateServiceException("El genero es obligatorio.");
		}
		
		
	}
	
}


