package com.misiontic.vacunautas2.entity;

import java.sql.Time;
import java.time.LocalDate;
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
@Table(name = "citas")
public class Citas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idcitas", nullable = false)
	private Long idcitas;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idvacunas", nullable = false, updatable = true, referencedColumnName = "idvacunas")
	private Vacunas idvacunas;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idenfermeras", nullable = false, updatable = true, referencedColumnName = "idenfermeras")
	private Enfermeras idenfermeras;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idniños", nullable = false, updatable = true, referencedColumnName = "idniños")
	private Niños idniños;
	
	@Column(name = "fecha", nullable = false)
	private LocalDate fecha;
	
	@Column(name = "hora", nullable = false)
	private Time hora;
	
	@Column(name = "lugar", nullable = false)
	private String lugar;
	@Column(name = "comentarios", nullable = true)
	private String comentarios;
	@Column(name = "estado", nullable =true)
	private String estado;

	
	

	//@OneToMany(mappedBy = "idPedido", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	//private List<RelProductoPedido> listaPedidos;

}
