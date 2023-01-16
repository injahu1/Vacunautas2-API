package com.misiontic.vacunautas2.validators;


import com.misiontic.vacunautas2.entity.Vacunas;
import com.misiontic.vacunautas2.exceptions.ValidateServiceException;



public class VacunasValidator {
	
	public static void validador (Vacunas vacunas) {
		
		if (vacunas.getIdvacunas() == null) {
			throw new ValidateServiceException("El idvacunas es obligatorio.");
		}
		
		if (vacunas.getNombre() == null) {
			throw new ValidateServiceException("El nombre es obligatorio.");
		}
		
		if (vacunas.getDosis() == null) {
			throw new ValidateServiceException("La dosis es obligatoria.");
		}
		
		if (vacunas.getLaboratorio() == null) {
			throw new ValidateServiceException("El laboratorio es obligatorio.");
		}
		
		if (vacunas.getLote() == null) {
			throw new ValidateServiceException("El lote es obligatorio.");
		}
		
		if (vacunas.getViaaplicacion() == null) {
			throw new ValidateServiceException("La via de aplicación es obligatoria.");
		}
		
		if (vacunas.getUnidades() == null) {
			throw new ValidateServiceException("las unidades son obligatorias.");
		}
		
	
	}
	
}


