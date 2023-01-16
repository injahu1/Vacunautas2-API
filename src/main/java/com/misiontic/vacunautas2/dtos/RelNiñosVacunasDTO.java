package com.misiontic.vacunautas2.dtos;

import com.misiontic.vacunautas2.entity.Niños;
import com.misiontic.vacunautas2.entity.Vacunas;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RelNiñosVacunasDTO {

	private Long idrelniñosvacunas;
	private Vacunas idvacunas;
	private Niños idniños;

}
