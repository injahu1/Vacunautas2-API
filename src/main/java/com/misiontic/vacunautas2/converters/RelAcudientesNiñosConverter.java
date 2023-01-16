package com.misiontic.vacunautas2.converters;

import com.misiontic.vacunautas2.dtos.RelAcudientesNiñosDTO;
import com.misiontic.vacunautas2.entity.RelAcudientesNiños;

public class RelAcudientesNiñosConverter extends AbstractConverter<RelAcudientesNiños, RelAcudientesNiñosDTO> {

	@Override
	public RelAcudientesNiñosDTO fromEntity(RelAcudientesNiños entity) {
		return RelAcudientesNiñosDTO.builder()
				.idrelacudientesniños(entity.getIdrelacudientesniños())
				.idniños(entity.getIdniños())
				.idacudientes(entity.getIdacudientes())
				.build();
	}

	@Override
	public RelAcudientesNiños fromDTO(RelAcudientesNiñosDTO dto) {
		return RelAcudientesNiños.builder()
				.idrelacudientesniños(dto.getIdrelacudientesniños())
				.idniños(dto.getIdniños())
				.idacudientes(dto.getIdacudientes())
				.build();
	}

}
