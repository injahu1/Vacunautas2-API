package com.misiontic.vacunautas2.dtos;

import java.sql.Time;
import java.time.LocalDate;

import com.misiontic.vacunautas2.entity.Enfermeras;
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
public class CitasDTO {

	private Long idcitas;
	private Vacunas idvacunas;
	private Enfermeras idenfermeras;
	private Niños idniños;
	private LocalDate fecha;
	private Time hora;
	private String lugar;
	private String comentarios;
	private String estado;
	
}
