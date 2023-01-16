package com.misiontic.vacunautas2.controllers;

import java.util.List;

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

import com.misiontic.vacunautas2.converters.VacunasConverter;
import com.misiontic.vacunautas2.dtos.VacunasDTO;
import com.misiontic.vacunautas2.entity.Vacunas;
import com.misiontic.vacunautas2.services.VacunasService;
import com.misiontic.vacunautas2.utils.WrapperResponse;

@RestController
public class VacunasController {
	
	@Autowired
	private VacunasService vacunasService;
	private VacunasConverter converter = new VacunasConverter();
	
	@GetMapping(value="/vacunas")
	public ResponseEntity<WrapperResponse<List<VacunasDTO>>> findAll(){
		List<Vacunas> arregloVacunas = vacunasService.findAll();
		List<VacunasDTO> arregloVacunasDto = converter.fromEntity(arregloVacunas);
		return new WrapperResponse<>(true, "success", arregloVacunasDto).createResponse(HttpStatus.OK);
	}
	
	@GetMapping(value="/vacunas/{vacunasId}")
	public ResponseEntity<WrapperResponse<VacunasDTO>> findById(@PathVariable("vacunasId") Long vacunasId) {
		Vacunas objVacunas = vacunasService.findById(vacunasId);
		VacunasDTO objVacunasDto = converter.fromEntity(objVacunas);
		return new WrapperResponse<>(true, "success", objVacunasDto).createResponse(HttpStatus.OK);
	}
	
	@PostMapping(value="/vacunas")
	public ResponseEntity<WrapperResponse<VacunasDTO>> create(@RequestBody VacunasDTO vacunas) {
		Vacunas nuevoVacunas = vacunasService.create(converter.fromDTO(vacunas));
		VacunasDTO objVacunasDto = converter.fromEntity(nuevoVacunas);
		return new WrapperResponse<>(true, "success", objVacunasDto).createResponse(HttpStatus.CREATED);
	}
	
	@PutMapping(value="/vacunas")
	public ResponseEntity<WrapperResponse<VacunasDTO>> update(@RequestBody VacunasDTO vacunas) {
		Vacunas objVacunas = vacunasService.update(converter.fromDTO(vacunas));
		VacunasDTO objVacunasDto = converter.fromEntity(objVacunas);
		return new WrapperResponse<>(true, "success", objVacunasDto).createResponse(HttpStatus.OK);
	}
	
	@DeleteMapping(value="/vacunas/{vacunasId}")
	public ResponseEntity<?> delete(@PathVariable("vacunasId") Long vacunasId) {
		vacunasService.delete(vacunasId);
		return new WrapperResponse<>(true, "success", null).createResponse(HttpStatus.OK);
	}

}
