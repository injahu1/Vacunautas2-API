package com.misiontic.vacunautas2.converters;

import com.misiontic.vacunautas2.dtos.EnfermerasDTO;
import com.misiontic.vacunautas2.entity.Enfermeras;

public class EnfermerasConverter extends AbstractConverter<Enfermeras, EnfermerasDTO> {

	@Override
	public EnfermerasDTO fromEntity(Enfermeras entity) {
		return EnfermerasDTO.builder()
				.idenfermeras(entity.getIdenfermeras   ())
				.identificacion (entity.getIdentificacion())
				.nombres (entity.getNombres ())
				.apellidos (entity.getApellidos ())
				.telefono (entity.getTelefono   ())
				.celular (entity.getCelular())
				.direccion  (entity.getDireccion  ())
				.email  (entity.getEmail  ())
				.fechanacimiento(entity.getFechanacimiento   ())
				.genero (entity.getGenero())
				.titulo  (entity.getTitulo  ())
				.estado (entity.getEstado ())
				.login(entity.getLogin  ())
				.clave  (entity.getClave ())
				.build();
	}

	

	@Override
	public Enfermeras fromDTO(EnfermerasDTO dto) {
		return Enfermeras.builder()
				
		.idenfermeras(dto.getIdenfermeras   ())
		.identificacion (dto.getIdentificacion())
		.nombres (dto.getNombres ())
		.apellidos (dto.getApellidos ())
		.telefono (dto.getTelefono   ())
		.celular (dto.getCelular())
		.direccion  (dto.getDireccion  ())
		.email  (dto.getEmail  ())
		.fechanacimiento(dto.getFechanacimiento   ())
		.genero (dto.getGenero())
		.titulo  (dto.getTitulo  ())
		.estado (dto.getEstado ())
		.login(dto.getLogin  ())
		.clave  (dto.getClave ())
		.build();
	}

}
