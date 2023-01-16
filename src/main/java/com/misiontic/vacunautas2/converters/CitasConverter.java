package com.misiontic.vacunautas2.converters;

import com.misiontic.vacunautas2.dtos.CitasDTO;
import com.misiontic.vacunautas2.entity.Citas;

public class CitasConverter extends AbstractConverter<Citas, CitasDTO> {

	@Override
	public CitasDTO fromEntity(Citas entity) {
		return CitasDTO.builder()
				.idcitas(entity.getIdcitas())
				.idvacunas(entity.getIdvacunas())
				.idenfermeras(entity.getIdenfermeras())
				.idniños(entity.getIdniños())
				.fecha(entity.getFecha())
				.hora(entity.getHora())
				.lugar(entity.getLugar())
				.comentarios(entity.getComentarios())
				.estado(entity.getEstado())
				.build();
	}

	@Override
	public Citas fromDTO(CitasDTO dto) {
		return Citas.builder()
				.idcitas(dto.getIdcitas())
				.idvacunas(dto.getIdvacunas())
				.idenfermeras(dto.getIdenfermeras())
				.idniños(dto.getIdniños())
				.fecha(dto.getFecha())
				.hora(dto.getHora())
				.lugar(dto.getLugar())
				.comentarios(dto.getComentarios())
				.estado(dto.getEstado())
				.build();
	}

}
