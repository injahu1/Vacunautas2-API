package com.misiontic.vacunautas2.converters;

import com.misiontic.vacunautas2.dtos.NiñosDTO;
import com.misiontic.vacunautas2.entity.Niños;

public class NiñosConverter extends AbstractConverter<Niños, NiñosDTO> {

	@Override
	public NiñosDTO fromEntity(Niños entity) {
		return NiñosDTO.builder()
				.idniños(entity.getIdniños())
				.identificacion(entity.getIdentificacion())
				.nombres(entity.getNombres())
				.apellidos(entity.getApellidos())
				.fechanacimiento(entity.getFechanacimiento())
				.genero(entity.getGenero())
				.estado(entity.getEstado())
				.build();
	}

	@Override
	public Niños fromDTO(NiñosDTO dto) {
		return Niños.builder()
				.idniños(dto.getIdniños())
				.identificacion(dto.getIdentificacion())
				.nombres(dto.getNombres())
				.apellidos(dto.getApellidos())
				.fechanacimiento(dto.getFechanacimiento())
				.genero(dto.getGenero())
				.estado(dto.getEstado())
				.build();
	}

}
