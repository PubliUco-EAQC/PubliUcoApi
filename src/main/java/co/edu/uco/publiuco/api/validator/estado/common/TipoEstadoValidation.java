package co.edu.uco.publiuco.api.validator.estado.common;

import co.edu.uco.publiuco.api.validator.Result;
import co.edu.uco.publiuco.api.validator.Validation;
import co.edu.uco.publiuco.dto.TipoEstadoDTO;
import co.edu.uco.publiuco.utils.UtilObject;

public class TipoEstadoValidation implements Validation<TipoEstadoDTO> {
	private TipoEstadoValidation() {
		super();
	}
	public static final Result validate(final TipoEstadoDTO data) {
		return new TipoEstadoValidation().execute(data);
	}
	@Override
	public Result execute(TipoEstadoDTO data) {
		var result = Result.create();
		
		if(UtilObject.isNull(data)) {
			result.addMessage("No es posible continuar con el Tipo Estado vacio");
			
		}
		return result;
	}

}
