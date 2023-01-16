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
@Table(name = "enfermeras")
public class Enfermeras {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idenfermeras", nullable = false)
	private Long idenfermeras;
	
	//@ManyToOne(fetch = FetchType.EAGER)
	//@JoinColumn(name = "idcliente", nullable = false, updatable = true, referencedColumnName = "idusuario")
	//private Usuario idCliente;
	
	@Column(name = "identificacion", nullable = false)
	private String identificacion;
	
	@Column(name = "nombres", nullable = false)
	private String nombres;
	
	@Column(name = "apellidos", nullable = false)
	private String apellidos;
	@Column(name = "telefono", nullable = true)
	private String telefono;
	@Column(name = "celular", nullable = false)
	private String celular;
	@Column(name = "direccion", nullable =true)
	private String direccion;
	@Column(name = "email", nullable = false)
	private String email;
	@Column(name = "fechanacimiento", nullable = false)
	private LocalDate fechanacimiento;
	@Column(name = "genero", nullable = false)
	private String genero;
	@Column(name = "titulo", nullable = false)
	private String titulo;
	@Column(name = "estado", nullable = true)
	private String estado;
	@Column(name = "login", nullable = true)
	private String login;
	@Column(name = "clave", nullable = true)
	private String clave;
	
	
	//@OneToMany(mappedBy = "idPedido", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	//private List<RelProductoPedido> listaPedidos;

}
