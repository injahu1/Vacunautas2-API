package com.misiontic.vacunautas2.dtos;

import com.misiontic.vacunautas2.entity.Acudientes;
import com.misiontic.vacunautas2.entity.Niños;
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
public class RelAcudientesNiñosDTO {

	private Long idrelacudientesniños;
	private Niños idniños;
	private Acudientes idacudientes;

}
