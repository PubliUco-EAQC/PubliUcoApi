package co.edu.uco.publiuco.api.validator.estado;

import java.util.UUID;

import co.edu.uco.publiuco.api.validator.Result;
import co.edu.uco.publiuco.api.validator.Validation;
import co.edu.uco.publiuco.api.validator.estado.common.IdentificadorValidation;
import co.edu.uco.publiuco.utils.UtilObject;

public class EliminarEstadoValidation implements Validation<UUID>{
	public static final Result validate(final UUID data) {
		return new EliminarEstadoValidation().execute(data);
	}
	private EliminarEstadoValidation() {
		super();
	}
	
	@Override
	public Result execute(UUID data) {
		var result = Result.create();
		if(UtilObject.isNull(data)) {
			result.addMessage("No es posible eliminar el estado");
		}else {
			result.addMessages(IdentificadorValidation.validate(data).getMessages());
		}
		return result;
	}
}
