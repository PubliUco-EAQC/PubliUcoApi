package co.edu.uco.publiuco.api.validator.estado;

import co.edu.uco.publiuco.api.validator.Result;
import co.edu.uco.publiuco.api.validator.Validation;
import co.edu.uco.publiuco.dto.EstadoDTO;

public final class RegistrarEstadoValidation implements Validation<EstadoDTO>{

	public static final Result validate(final EstadoDTO data) {
		return new RegistrarEstadoValidation().execute(data);
	}
	private RegistrarEstadoValidation() {
		super();
	}
	
	public Result execute(final EstadoDTO data) {
		// TODO Auto-generated method stub
		return null;
	}

}