package com.misiontic.vacunautas2.validators;

import com.misiontic.vacunautas2.entity.RelAcudientesNiños;
import com.misiontic.vacunautas2.exceptions.ValidateServiceException;

public class RelAcudientesNiñosValidator {

	public static void validador(RelAcudientesNiños objRelAcudientesNiños) {
		
		if (objRelAcudientesNiños.getIdrelacudientesniños() == null) {
			throw new ValidateServiceException("El idrelacudientesniños es obligatorio.");
		}
		
		if (objRelAcudientesNiños.getIdniños() == null) {
			throw new ValidateServiceException("El idniños es obligatorio.");
		}
		
		if (objRelAcudientesNiños.getIdacudientes() == null) {
			throw new ValidateServiceException("El idacudientes es obligatorio.");
		}
		

	}

}
