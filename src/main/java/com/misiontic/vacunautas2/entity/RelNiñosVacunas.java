package com.misiontic.vacunautas2.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "relniñosvacunas")
public class RelNiñosVacunas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idrelniñosvacunas", nullable = false)
	private Long idrelniñosvacunas;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idvacunas", nullable = false, updatable = false, referencedColumnName = "idvacunas")
	private Vacunas idvacunas;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idniños", nullable = false, updatable = false, referencedColumnName = "idniños")
	private Niños idniños;
	
}
