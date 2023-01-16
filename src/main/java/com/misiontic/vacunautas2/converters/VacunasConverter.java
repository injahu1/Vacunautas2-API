package com.misiontic.vacunautas2.converters;

import com.misiontic.vacunautas2.dtos.VacunasDTO;
import com.misiontic.vacunautas2.entity.Vacunas;

public class VacunasConverter extends AbstractConverter<Vacunas, VacunasDTO> {

	@Override
	public VacunasDTO fromEntity(Vacunas entity) {
		return VacunasDTO.builder()
				.idvacunas(entity.getIdvacunas())
				.nombre(entity.getNombre())
				.dosis(entity.getDosis())
				.laboratorio(entity.getLaboratorio())
				.lote(entity.getLote())
				.viaaplicacion(entity.getViaaplicacion())
				.estado(entity.getEstado())
				.unidades(entity.getUnidades())
				.build();
	}

	@Override
	public Vacunas fromDTO(VacunasDTO dto) {
		return Vacunas.builder()
				.idvacunas(dto.getIdvacunas())
				.nombre(dto.getNombre())
				.dosis(dto.getDosis())
				.laboratorio(dto.getLaboratorio())
				.lote(dto.getLote())
				.viaaplicacion(dto.getViaaplicacion())
				.estado(dto.getEstado())
				.unidades(dto.getUnidades())
				.build();
	}

}
