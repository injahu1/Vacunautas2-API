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

import com.misiontic.vacunautas2.converters.NiñosConverter;
import com.misiontic.vacunautas2.dtos.NiñosDTO;
import com.misiontic.vacunautas2.entity.Niños;
import com.misiontic.vacunautas2.services.NiñosService;
import com.misiontic.vacunautas2.utils.WrapperResponse;

@RestController
public class NiñosController {
	
	@Autowired
	private NiñosService niñosService;
	private NiñosConverter converter = new NiñosConverter();
	
	@GetMapping(value="/niños")
	public ResponseEntity<WrapperResponse<List<NiñosDTO>>> findAll(){
		List<Niños> arregloNiños = niñosService.findAll();
		List<NiñosDTO> arregloNiñosDto = converter.fromEntity(arregloNiños);
		return new WrapperResponse<>(true, "success", arregloNiñosDto).createResponse(HttpStatus.OK);
	}
	
	@GetMapping(value="/niños/{niñosId}")
	public ResponseEntity<WrapperResponse<NiñosDTO>> findById(@PathVariable("niñosId") Long niñosId) {
		Niños objNiños = niñosService.findById(niñosId);
		NiñosDTO objNiñosDto = converter.fromEntity(objNiños);
		return new WrapperResponse<>(true, "success", objNiñosDto).createResponse(HttpStatus.OK);
	}
	
	@PostMapping(value="/niños")
	public ResponseEntity<WrapperResponse<NiñosDTO>> create(@RequestBody NiñosDTO niños) {
		Niños nuevoNiños = niñosService.create(converter.fromDTO(niños));
		NiñosDTO objNiñosDto = converter.fromEntity(nuevoNiños);
		return new WrapperResponse<>(true, "success", objNiñosDto).createResponse(HttpStatus.CREATED);
	}
	
	@PutMapping(value="/niños")
	public ResponseEntity<WrapperResponse<NiñosDTO>> update(@RequestBody NiñosDTO niños) {
		Niños objNiños = niñosService.update(converter.fromDTO(niños));
		NiñosDTO objNiñosDto = converter.fromEntity(objNiños);
		return new WrapperResponse<>(true, "success", objNiñosDto).createResponse(HttpStatus.OK);
	}
	
	@DeleteMapping(value="/niños/{niñosId}")
	public ResponseEntity<?> delete(@PathVariable("niñosId") Long niñosId) {
		niñosService.delete(niñosId);
		return new WrapperResponse<>(true, "success", null).createResponse(HttpStatus.OK);
	}

}
