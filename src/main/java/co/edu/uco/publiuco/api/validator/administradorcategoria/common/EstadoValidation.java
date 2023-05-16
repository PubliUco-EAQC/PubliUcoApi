package co.edu.uco.publiuco.api.validator.administradorcategoria.common;

import co.edu.uco.publiuco.api.validator.Result;
import co.edu.uco.publiuco.api.validator.Validation;
import co.edu.uco.publiuco.dto.EstadoDTO;
import co.edu.uco.publiuco.utils.UtilObject;

public class EstadoValidation implements Validation<EstadoDTO>{
	private EstadoValidation() {
		super();
	}
	public static final Result validate(final EstadoDTO data) {
		return new EstadoValidation().execute(data);
	}
	@Override
	public Result execute(EstadoDTO data) {
		var result = Result.create();
		
		if(UtilObject.isNull(data)) {
			result.addMessage("No es posible continuar con el estado vacío");
			
		}
		return result;
	}
}
