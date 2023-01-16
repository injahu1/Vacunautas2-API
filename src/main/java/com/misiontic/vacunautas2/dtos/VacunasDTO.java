package com.misiontic.vacunautas2.dtos;

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
public class VacunasDTO {

	private Long idvacunas;
	private String nombre;
	private String dosis;
	private String laboratorio;
	private String lote;
	private String viaaplicacion;
	private String estado;
	private Double unidades;

	
}
