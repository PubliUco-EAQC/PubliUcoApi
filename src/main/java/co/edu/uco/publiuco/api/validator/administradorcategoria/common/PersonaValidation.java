package co.edu.uco.publiuco.api.validator.administradorcategoria.common;

import co.edu.uco.publiuco.api.validator.Result;
import co.edu.uco.publiuco.api.validator.Validation;
import co.edu.uco.publiuco.dto.PersonaDTO;
import co.edu.uco.publiuco.utils.UtilObject;

public class PersonaValidation implements Validation<PersonaDTO>{
	private PersonaValidation() {
		super();
	}
	public static final Result validate(final PersonaDTO data) {
		return new PersonaValidation().execute(data);
	}
	@Override
	public Result execute(PersonaDTO data) {
		var result = Result.create();
		
		if(UtilObject.isNull(data)) {
			result.addMessage("No es posible continuar con los datos de la persona vacios");
			
		}
		return result;
	}
}
