package com.misiontic.vacunautas2.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Entity
@Table(name = "niños")
public class Niños {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idniños", nullable = false)
	private Long idniños;

	
	@Column(name = "identificacion", nullable = false)
	private String identificacion;
	
	@Column(name = "nombres", nullable = false)
	private String nombres;
	
	@Column(name = "apellidos", nullable = false)
	private String apellidos;
	@Column(name = "fechanacimiento", nullable = false)
	private LocalDate fechanacimiento;
	@Column(name = "genero", nullable = false)
	private String genero;
	@Column(name = "estado", nullable =true)
	private String estado;

}
