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
@Table(name = "relacudientesniños")
public class RelAcudientesNiños {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idrelacudientesniños", nullable = false)
	private Long idrelacudientesniños;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idniños", nullable = false, updatable = false, referencedColumnName = "idniños")
	private Niños idniños;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idacudientes", nullable = false, updatable = false, referencedColumnName = "idacudientes")
	private Acudientes idacudientes;
	
}
