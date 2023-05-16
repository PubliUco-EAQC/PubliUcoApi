package co.edu.uco.publiuco.api.validator.administradorcategoria;

import co.edu.uco.publiuco.api.validator.Result;
import co.edu.uco.publiuco.api.validator.Validation;
import co.edu.uco.publiuco.api.validator.administradorcategoria.common.EstadoValidation;
import co.edu.uco.publiuco.api.validator.administradorcategoria.common.IdentificadorValidation;
import co.edu.uco.publiuco.api.validator.administradorcategoria.common.PersonaValidation;
import co.edu.uco.publiuco.dto.AdministradorCategoriaDTO;
import co.edu.uco.publiuco.utils.UtilObject;

public class RegistrarAdministradorCategoriaValidation implements Validation<AdministradorCategoriaDTO>{
	public static final Result validate(final AdministradorCategoriaDTO data) {
		return new RegistrarAdministradorCategoriaValidation().execute(data);
	}
	private RegistrarAdministradorCategoriaValidation() {
		super();
	}
	
	@Override
	public Result execute(final AdministradorCategoriaDTO data) {
		var result = Result.create();
		if(UtilObject.isNull(data)) {
			result.addMessage("No es posible registrar un nuevo estado");
		}else {
			result.addMessages(PersonaValidation.validate(data.getPersona()).getMessages());
			result.addMessages(IdentificadorValidation.validate(data.getIdentificador()).getMessages());
			result.addMessages(EstadoValidation.validate(data.getEstado()).getMessages());
		}
		return result;
		
	}
}
