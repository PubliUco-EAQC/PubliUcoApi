package co.edu.uco.publiuco.api.validator.administradorcategoria;

import co.edu.uco.publiuco.api.validator.Result;
import co.edu.uco.publiuco.api.validator.Validation;
import co.edu.uco.publiuco.api.validator.administradorcategoria.common.EstadoValidation;
import co.edu.uco.publiuco.api.validator.administradorcategoria.common.PersonaValidation;
import co.edu.uco.publiuco.api.validator.administradorcategoria.common.IdentificadorValidation;
import co.edu.uco.publiuco.dto.AdministradorCategoriaDTO;
import co.edu.uco.publiuco.utils.UtilObject;

public class ModificarAdministradorCategoriaValidation implements Validation<AdministradorCategoriaDTO>{
	public static final Result validate(final AdministradorCategoriaDTO data) {
		return new ModificarAdministradorCategoriaValidation().execute(data);
	}
	private ModificarAdministradorCategoriaValidation() {
		super();
	}
	
	@Override
	public Result execute(final AdministradorCategoriaDTO data) {
		var result = Result.create();
		if(UtilObject.isNull(data)) {
			result.addMessage("No es posible modificar el administrador de la categoria");
		}else {
			result.addMessages(PersonaValidation.validate(data.getPersona()).getMessages());
			result.addMessages(EstadoValidation.validate(data.getEstado()).getMessages());
			result.addMessages(IdentificadorValidation.validate(data.getIdentificador()).getMessages());
		}
		return result;
		
	}
}
