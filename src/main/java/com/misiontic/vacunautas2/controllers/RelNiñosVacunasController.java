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

import com.misiontic.vacunautas2.converters.RelNiñosVacunasConverter;
import com.misiontic.vacunautas2.dtos.RelNiñosVacunasDTO;
import com.misiontic.vacunautas2.entity.RelNiñosVacunas;
import com.misiontic.vacunautas2.services.RelNiñosVacunasService;
import com.misiontic.vacunautas2.utils.WrapperResponse;

@RestController
public class RelNiñosVacunasController {
	
	@Autowired
	private RelNiñosVacunasService relNiñosVacunasService;
	private RelNiñosVacunasConverter converter = new RelNiñosVacunasConverter();
	
	@GetMapping(value="/relNiñosVacunas/{relNiñosVacunasId}")
	public ResponseEntity<WrapperResponse<RelNiñosVacunasDTO>> findById(@PathVariable("relNiñosVacunasId") Long relNiñosVacunasId) {
		RelNiñosVacunas objRelNiñosVacunas = relNiñosVacunasService.findById(relNiñosVacunasId);
		RelNiñosVacunasDTO objRelNiñosVacunasDto = converter.fromEntity(objRelNiñosVacunas);
		return new WrapperResponse<>(true, "success", objRelNiñosVacunasDto).createResponse(HttpStatus.OK);
	}
	
	@PostMapping(value="/relNiñosVacunas")
	public ResponseEntity<WrapperResponse<RelNiñosVacunasDTO>> create(@RequestBody RelNiñosVacunasDTO objRelNiñosVacunas) {
		RelNiñosVacunas nuevoRelNiñosVacunas = relNiñosVacunasService.create(converter.fromDTO(objRelNiñosVacunas));
		RelNiñosVacunasDTO objRelNiñosVacunasDto = converter.fromEntity(nuevoRelNiñosVacunas);
		return new WrapperResponse<>(true, "success", objRelNiñosVacunasDto).createResponse(HttpStatus.CREATED);
	}
	
	@PutMapping(value="/relNiñosVacunas")
	public ResponseEntity<WrapperResponse<RelNiñosVacunasDTO>> update(@RequestBody RelNiñosVacunasDTO objRelNiñosVacunas) {
		RelNiñosVacunas objetoRelNiñosVacunas = relNiñosVacunasService.update(converter.fromDTO(objRelNiñosVacunas));
		RelNiñosVacunasDTO objetoDto = converter.fromEntity(objetoRelNiñosVacunas);
		return new WrapperResponse<>(true, "success", objetoDto).createResponse(HttpStatus.OK);
	}
	
	@DeleteMapping(value="/relNiñosVacunas/{relNiñosVacunasId}")
	public ResponseEntity<?> delete(@PathVariable("relNiñosVacunasId") Long relNiñosVacunasId) {
		relNiñosVacunasService.delete(relNiñosVacunasId);
		return new WrapperResponse<>(true, "success", null).createResponse(HttpStatus.OK);
	}

}
