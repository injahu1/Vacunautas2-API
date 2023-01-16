package com.misiontic.vacunautas2.validators;


import com.misiontic.vacunautas2.entity.Acudientes;
import com.misiontic.vacunautas2.exceptions.ValidateServiceException;



public class AcudientesValidator {
	
	public static void validador (Acudientes acudientes) {
		
		if (acudientes.getIdacudientes() == null) {
			throw new ValidateServiceException("El idacudientes es obligatorio.");
		}
		
		if (acudientes.getIdentificacion() == null) {
			throw new ValidateServiceException("La identificacion es obligatoria.");
		}
		
		if (acudientes.getNombres() == null) {
			throw new ValidateServiceException("El nombre es obligatorio.");
		}
		
		if (acudientes.getFechanacimiento() == null) {
			throw new ValidateServiceException("La fecha es obligatorio.");
		}
		
		if (acudientes.getApellidos() == null) {
			throw new ValidateServiceException("El apellido es obligatorio.");
		}
		
		if (acudientes.getCelular() == null) {
			throw new ValidateServiceException("El celular es obligatorio.");
		}
		
		if (acudientes.getGenero() == null) {
			throw new ValidateServiceException("El Genero es obligatorio.");
		}
		
		if (acudientes.getEmail() == null) {
			throw new ValidateServiceException("El email es obligatorio.");
		}
		
		if (acudientes.getParentesco() == null) {
			throw new ValidateServiceException("El parentesco es obligatorio.");
		}
	
	}
	
}


