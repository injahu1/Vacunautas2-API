package com.misiontic.vacunautas2.converters;

import com.misiontic.vacunautas2.dtos.RelNiñosVacunasDTO;
import com.misiontic.vacunautas2.entity.RelNiñosVacunas;

public class RelNiñosVacunasConverter extends AbstractConverter<RelNiñosVacunas, RelNiñosVacunasDTO> {

	@Override
	public RelNiñosVacunasDTO fromEntity(RelNiñosVacunas entity) {
		return RelNiñosVacunasDTO.builder()
				.idrelniñosvacunas(entity.getIdrelniñosvacunas())
				.idvacunas(entity.getIdvacunas())
				.idniños(entity.getIdniños())
				.build();
	}

	@Override
	public RelNiñosVacunas fromDTO(RelNiñosVacunasDTO dto) {
		return RelNiñosVacunas.builder()
				.idrelniñosvacunas(dto.getIdrelniñosvacunas())
				.idvacunas(dto.getIdvacunas())
				.idniños(dto.getIdniños())
				.build();
	}

}
