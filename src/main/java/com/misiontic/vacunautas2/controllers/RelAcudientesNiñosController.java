package com.misiontic.vacunautas2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.misiontic.vacunautas2.converters.RelAcudientesNiñosConverter;
import com.misiontic.vacunautas2.dtos.RelAcudientesNiñosDTO;
import com.misiontic.vacunautas2.entity.RelAcudientesNiños;
import com.misiontic.vacunautas2.services.RelAcudientesNiñosService;
import com.misiontic.vacunautas2.utils.WrapperResponse;

@RestController
public class RelAcudientesNiñosController {
	
	@Autowired
	private RelAcudientesNiñosService relAcudientesNiñosService;
	private RelAcudientesNiñosConverter converter = new RelAcudientesNiñosConverter();
	
	@GetMapping(value="/relAcudientesNiños/{relAcudientesNiñosId}")
	public ResponseEntity<WrapperResponse<RelAcudientesNiñosDTO>> findById(@PathVariable("relAcudientesNiñosId") Long relAcudientesNiñosId) {
		RelAcudientesNiños objRelAcudientesNiños = relAcudientesNiñosService.findById(relAcudientesNiñosId);
		RelAcudientesNiñosDTO objRelAcudientesNiñosDto = converter.fromEntity(objRelAcudientesNiños);
		return new WrapperResponse<>(true, "success", objRelAcudientesNiñosDto).createResponse(HttpStatus.OK);
	}
	
	@PostMapping(value="/relAcudientesNiños")
	public ResponseEntity<WrapperResponse<RelAcudientesNiñosDTO>> create(@RequestBody RelAcudientesNiñosDTO objRelAcudientesNiños) {
		RelAcudientesNiños nuevoRelAcudientesNiños = relAcudientesNiñosService.create(converter.fromDTO(objRelAcudientesNiños));
		RelAcudientesNiñosDTO objRelAcudientesNiñosDto = converter.fromEntity(nuevoRelAcudientesNiños);
		return new WrapperResponse<>(true, "success", objRelAcudientesNiñosDto).createResponse(HttpStatus.CREATED);
	}
	
	@PutMapping(value="/relAcudientesNiños")
	public ResponseEntity<WrapperResponse<RelAcudientesNiñosDTO>> update(@RequestBody RelAcudientesNiñosDTO objRelAcudientesNiños) {
		RelAcudientesNiños objetoRelAcudientesNiños = relAcudientesNiñosService.update(converter.fromDTO(objRelAcudientesNiños));
		RelAcudientesNiñosDTO objetoDto = converter.fromEntity(objetoRelAcudientesNiños);
		return new WrapperResponse<>(true, "success", objetoDto).createResponse(HttpStatus.OK);
	}
	
	@DeleteMapping(value="/relAcudientesNiños/{relAcudientesNiñosId}")
	public ResponseEntity<?> delete(@PathVariable("relAcudientesNiñosId") Long relAcudientesNiñosId) {
		relAcudientesNiñosService.delete(relAcudientesNiñosId);
		return new WrapperResponse<>(true, "success", null).createResponse(HttpStatus.OK);
	}

}
