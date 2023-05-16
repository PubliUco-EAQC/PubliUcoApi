package co.edu.uco.publiuco.api.validator.estado;

import co.edu.uco.publiuco.api.validator.Result;
import co.edu.uco.publiuco.api.validator.Validation;
import co.edu.uco.publiuco.api.validator.estado.common.DescripcionValidation;
import co.edu.uco.publiuco.api.validator.estado.common.IdentificadorValidation;
import co.edu.uco.publiuco.api.validator.estado.common.NombreValidation;
import co.edu.uco.publiuco.api.validator.estado.common.TipoEstadoValidation;
import co.edu.uco.publiuco.dto.EstadoDTO;
import co.edu.uco.publiuco.utils.UtilObject;

public class ModificarEstadoValidation implements Validation<EstadoDTO>{
	public static final Result validate(final EstadoDTO data) {
		return new ModificarEstadoValidation().execute(data);
	}
	private ModificarEstadoValidation() {
		super();
	}
	
	@Override
	public Result execute(final EstadoDTO data) {
		var result = Result.create();
		if(UtilObject.isNull(data)) {
			result.addMessage("No es posible modificar el estado");
		}else {
			result.addMessages(NombreValidation.validate(data.getNombre()).getMessages());
			result.addMessages(DescripcionValidation.validate(data.getDescripcion()).getMessages());
			result.addMessages(IdentificadorValidation.validate(data.getIdentificador()).getMessages());
			result.addMessages(TipoEstadoValidation.validate(data.getTipoEstado()).getMessages());
		}
		return result;
		
	}
}
