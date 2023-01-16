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

import com.misiontic.vacunautas2.converters.EnfermerasConverter;
import com.misiontic.vacunautas2.dtos.EnfermerasDTO;
import com.misiontic.vacunautas2.entity.Enfermeras;
import com.misiontic.vacunautas2.services.EnfermerasService;
import com.misiontic.vacunautas2.utils.WrapperResponse;

@RestController
public class EnfermerasController {
	
	@Autowired
	private EnfermerasService enfermerasService;
	private EnfermerasConverter converter = new EnfermerasConverter();
	
	@GetMapping(value="/enfermeras")
	public ResponseEntity<WrapperResponse<List<EnfermerasDTO>>> findAll(){
		List<Enfermeras> arregloEnfermeras = enfermerasService.findAll();
		List<EnfermerasDTO> arregloEnfermerasDto = converter.fromEntity(arregloEnfermeras);
		return new WrapperResponse<>(true, "success", arregloEnfermerasDto).createResponse(HttpStatus.OK);
	}
	
	@GetMapping(value="/enfermeras/{enfermerasId}")
	public ResponseEntity<WrapperResponse<EnfermerasDTO>> findById(@PathVariable("enfermerasId") Long enfermerasId) {
		Enfermeras objEnfermeras = enfermerasService.findById(enfermerasId);
		EnfermerasDTO objEnfermerasDto = converter.fromEntity(objEnfermeras);
		return new WrapperResponse<>(true, "success", objEnfermerasDto).createResponse(HttpStatus.OK);
	}
	
	@PostMapping(value="/enfermeras")
	public ResponseEntity<WrapperResponse<EnfermerasDTO>> create(@RequestBody EnfermerasDTO enfermeras) {
		Enfermeras nuevoEnfermeras = enfermerasService.create(converter.fromDTO(enfermeras));
		EnfermerasDTO objEnfermerasDto = converter.fromEntity(nuevoEnfermeras);
		return new WrapperResponse<>(true, "success", objEnfermerasDto).createResponse(HttpStatus.CREATED);
	}
	
	@PutMapping(value="/enfermeras")
	public ResponseEntity<WrapperResponse<EnfermerasDTO>> update(@RequestBody EnfermerasDTO enfermeras) {
		Enfermeras objEnfermeras = enfermerasService.update(converter.fromDTO(enfermeras));
		EnfermerasDTO objEnfermerasDto = converter.fromEntity(objEnfermeras);
		return new WrapperResponse<>(true, "success", objEnfermerasDto).createResponse(HttpStatus.OK);
	}
	
	@DeleteMapping(value="/enfermeras/{enfermerasId}")
	public ResponseEntity<?> delete(@PathVariable("enfermerasId") Long enfermerasId) {
		enfermerasService.delete(enfermerasId);
		return new WrapperResponse<>(true, "success", null).createResponse(HttpStatus.OK);
	}

}
