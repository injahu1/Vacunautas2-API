package com.misiontic.vacunautas2.dtos;

import java.time.LocalDate;

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
public class NiñosDTO {

	private Long idniños;
	private String identificacion;
	private String nombres;
	private String apellidos;
	private LocalDate fechanacimiento;
	private String genero;
	private String estado;
	
	
}
