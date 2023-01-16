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

import com.misiontic.vacunautas2.converters.CitasConverter;
import com.misiontic.vacunautas2.dtos.CitasDTO;
import com.misiontic.vacunautas2.entity.Citas;
import com.misiontic.vacunautas2.services.CitasService;
import com.misiontic.vacunautas2.utils.WrapperResponse;

@RestController
public class CitasController {
	
	@Autowired
	private CitasService citasService;
	private CitasConverter converter = new CitasConverter();
	
	@GetMapping(value="/citas")
	public ResponseEntity<WrapperResponse<List<CitasDTO>>> findAll(){
		List<Citas> arregloCitas = citasService.findAll();
		List<CitasDTO> arregloCitasDto = converter.fromEntity(arregloCitas);
		return new WrapperResponse<>(true, "success", arregloCitasDto).createResponse(HttpStatus.OK);
	}
	
	@GetMapping(value="/citas/{citasId}")
	public ResponseEntity<WrapperResponse<CitasDTO>> findById(@PathVariable("citasId") Long citasId) {
		Citas objCitas = citasService.findById(citasId);
		CitasDTO objCitasDto = converter.fromEntity(objCitas);
		return new WrapperResponse<>(true, "success", objCitasDto).createResponse(HttpStatus.OK);
	}
	
	@PostMapping(value="/citas")
	public ResponseEntity<WrapperResponse<CitasDTO>> create(@RequestBody CitasDTO citas) {
		Citas nuevoCitas = citasService.create(converter.fromDTO(citas));
		CitasDTO objCitasDto = converter.fromEntity(nuevoCitas);
		return new WrapperResponse<>(true, "success", objCitasDto).createResponse(HttpStatus.CREATED);
	}
	
	@PutMapping(value="/citas")
	public ResponseEntity<WrapperResponse<CitasDTO>> update(@RequestBody CitasDTO citas) {
		Citas objCitas = citasService.update(converter.fromDTO(citas));
		CitasDTO objCitasDto = converter.fromEntity(objCitas);
		return new WrapperResponse<>(true, "success", objCitasDto).createResponse(HttpStatus.OK);
	}
	
	@DeleteMapping(value="/citas/{citasId}")
	public ResponseEntity<?> delete(@PathVariable("citasId") Long citasId) {
		citasService.delete(citasId);
		return new WrapperResponse<>(true, "success", null).createResponse(HttpStatus.OK);
	}

}
