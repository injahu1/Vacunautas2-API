package com.misiontic.vacunautas2.validators;

import com.misiontic.vacunautas2.entity.RelNiñosVacunas;
import com.misiontic.vacunautas2.exceptions.ValidateServiceException;

public class RelNiñosVacunasValidator {

	public static void validador(RelNiñosVacunas objRelNiñosVacunas) {
		
		if (objRelNiñosVacunas.getIdrelniñosvacunas() == null) {
			throw new ValidateServiceException("El idrelniñosvacunas es obligatorio.");
		}
		
		if (objRelNiñosVacunas.getIdvacunas() == null) {
			throw new ValidateServiceException("El idvacunas es obligatorio.");
		}
		
		if (objRelNiñosVacunas.getIdniños() == null) {
			throw new ValidateServiceException("El idniños es obligatorio.");
		}
		

	}

}
