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
public class AcudientesDTO {

	private Long idacudientes;
	private String identificacion;
	private String nombres;
	private String apellidos;
	private String telefono;
	private String celular;
	private String direccion;
	private String email;
	private LocalDate fechanacimiento;
	private String genero;
	private String parentesco;
	private String estado;
	private String login;
	private String clave;

	
	
}
