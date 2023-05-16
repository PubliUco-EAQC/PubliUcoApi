package co.edu.uco.publiuco.api.validator.administradorcategoria;

import java.util.UUID;

import co.edu.uco.publiuco.api.validator.Result;
import co.edu.uco.publiuco.api.validator.Validation;
import co.edu.uco.publiuco.api.validator.administradorcategoria.common.IdentificadorValidation;
import co.edu.uco.publiuco.utils.UtilObject;

public class EliminarAdministradorCategoriaValidation implements Validation<UUID>{
	public static final Result validate(final UUID data) {
		return new EliminarAdministradorCategoriaValidation().execute(data);
	}
	private EliminarAdministradorCategoriaValidation() {
		super();
	}
	
	@Override
	public Result execute(UUID data) {
		var result = Result.create();
		if(UtilObject.isNull(data)) {
			result.addMessage("No es posible eliminar el administrador categoria");
		}else {
			result.addMessages(IdentificadorValidation.validate(data).getMessages());
		}
		return result;
	}
}
