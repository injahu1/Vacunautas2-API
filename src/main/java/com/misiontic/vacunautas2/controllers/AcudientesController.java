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

import com.misiontic.vacunautas2.converters.AcudientesConverter;
import com.misiontic.vacunautas2.dtos.AcudientesDTO;
import com.misiontic.vacunautas2.entity.Acudientes;
import com.misiontic.vacunautas2.services.AcudientesService;
import com.misiontic.vacunautas2.utils.WrapperResponse;

@RestController
public class AcudientesController {
	
	@Autowired
	private AcudientesService acudientesService;
	private AcudientesConverter converter = new AcudientesConverter();
	
	@GetMapping(value="/acudientes")
	public ResponseEntity<WrapperResponse<List<AcudientesDTO>>> findAll(){
		List<Acudientes> arregloAcudientes = acudientesService.findAll();
		List<AcudientesDTO> arregloAcudientesDto = converter.fromEntity(arregloAcudientes);
		return new WrapperResponse<>(true, "success", arregloAcudientesDto).createResponse(HttpStatus.OK);
	}
	
	@GetMapping(value="/acudientes/{acudientesId}")
	public ResponseEntity<WrapperResponse<AcudientesDTO>> findById(@PathVariable("acudientesId") Long acudientesId) {
		Acudientes objAcudientes = acudientesService.findById(acudientesId);
		AcudientesDTO objAcudientesDto = converter.fromEntity(objAcudientes);
		return new WrapperResponse<>(true, "success", objAcudientesDto).createResponse(HttpStatus.OK);
	}
	
	@PostMapping(value="/acudientes")
	public ResponseEntity<WrapperResponse<AcudientesDTO>> create(@RequestBody AcudientesDTO acudientes) {
		Acudientes nuevoAcudientes = acudientesService.create(converter.fromDTO(acudientes));
		AcudientesDTO objAcudientesDto = converter.fromEntity(nuevoAcudientes);
		return new WrapperResponse<>(true, "success", objAcudientesDto).createResponse(HttpStatus.CREATED);
	}
	
	@PutMapping(value="/acudientes")
	public ResponseEntity<WrapperResponse<AcudientesDTO>> update(@RequestBody AcudientesDTO acudientes) {
		Acudientes objAcudientes = acudientesService.update(converter.fromDTO(acudientes));
		AcudientesDTO objAcudientesDto = converter.fromEntity(objAcudientes);
		return new WrapperResponse<>(true, "success", objAcudientesDto).createResponse(HttpStatus.OK);
	}
	
	@DeleteMapping(value="/acudientes/{acudientesId}")
	public ResponseEntity<?> delete(@PathVariable("acudientesId") Long acudientesId) {
		acudientesService.delete(acudientesId);
		return new WrapperResponse<>(true, "success", null).createResponse(HttpStatus.OK);
	}

}
