package com.misiontic.vacunautas2.entity;

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
@Table(name = "vacunas")
public class Vacunas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idvacunas", nullable = false)
	private Long idvacunas;
	
	//@ManyToOne(fetch = FetchType.EAGER)
	//@JoinColumn(name = "idcliente", nullable = false, updatable = true, referencedColumnName = "idusuario")
	//private Usuario idCliente;
	
	@Column(name = "nombre", nullable = false)
	private String nombre;
	
	@Column(name = "dosis", nullable = false)
	private String dosis;
	
	@Column(name = "laboratorio", nullable = false)
	private String laboratorio;
	@Column(name = "lote", nullable = false)
	private String lote;
	@Column(name = "viaaplicacion", nullable = false)
	private String viaaplicacion;
	@Column(name = "estado", nullable =true)
	private String estado;
	@Column(name = "unidades", nullable = false)
	private Double unidades;


	//@OneToMany(mappedBy = "idPedido", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	//private List<RelProductoPedido> listaPedidos;

}
