package com.misiontic.vacunautas2.converters;

import com.misiontic.vacunautas2.dtos.AcudientesDTO;
import com.misiontic.vacunautas2.entity.Acudientes;

public class AcudientesConverter extends AbstractConverter<Acudientes, AcudientesDTO> {

	@Override
	public AcudientesDTO fromEntity(Acudientes entity) {
		return AcudientesDTO.builder()
				.idacudientes(entity.getIdacudientes   ())
				.identificacion (entity.getIdentificacion())
				.nombres (entity.getNombres ())
				.apellidos (entity.getApellidos ())
				.telefono (entity.getTelefono   ())
				.celular (entity.getCelular())
				.direccion  (entity.getDireccion  ())
				.email  (entity.getEmail  ())
				.fechanacimiento(entity.getFechanacimiento   ())
				.genero (entity.getGenero())
				.parentesco  (entity.getParentesco  ())
				.estado (entity.getEstado ())
				.login(entity.getLogin  ())
				.clave  (entity.getClave ())
				.build();
	}

	

	@Override
	public Acudientes fromDTO(AcudientesDTO dto) {
		return Acudientes.builder()
				
		.idacudientes(dto.getIdacudientes   ())
		.identificacion (dto.getIdentificacion())
		.nombres (dto.getNombres ())
		.apellidos (dto.getApellidos ())
		.telefono (dto.getTelefono   ())
		.celular (dto.getCelular())
		.direccion  (dto.getDireccion  ())
		.email  (dto.getEmail  ())
		.fechanacimiento(dto.getFechanacimiento   ())
		.genero (dto.getGenero())
		.parentesco  (dto.getParentesco  ())
		.estado (dto.getEstado ())
		.login(dto.getLogin  ())
		.clave  (dto.getClave ())
		.build();
	}

}
