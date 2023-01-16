package com.misiontic.vacunautas2.validators;


import com.misiontic.vacunautas2.entity.Citas;
import com.misiontic.vacunautas2.exceptions.ValidateServiceException;



public class CitasValidator {
	
	public static void validador (Citas citas) {
		
		if (citas.getIdcitas() == null) {
			throw new ValidateServiceException("El idcitas es obligatorio.");
		}
		
		if (citas.getIdvacunas() == null) {
			throw new ValidateServiceException("El idvacunas es obligatorio.");
		}
		
		if (citas.getIdenfermeras() == null) {
			throw new ValidateServiceException("El idenfermeras es obligatorio.");
		}
		
		if (citas.getIdniños() == null) {
			throw new ValidateServiceException("El idniños es obligatorio.");
		}
		
		if (citas.getFecha() == null) {
			throw new ValidateServiceException("La fecha es obligatoria.");
		}
		
		if (citas.getHora() == null) {
			throw new ValidateServiceException("La hora es obligatoria.");
		}
		
		if (citas.getLugar() == null) {
			throw new ValidateServiceException("El lugar es obligatorio.");
		}
		
	}
	
}


