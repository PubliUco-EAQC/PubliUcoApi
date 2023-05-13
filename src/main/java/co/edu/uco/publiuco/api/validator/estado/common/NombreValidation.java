package co.edu.uco.publiuco.api.validator.estado.common;

import co.edu.uco.publiuco.api.validator.Result;
import co.edu.uco.publiuco.api.validator.Validation;
import co.edu.uco.publiuco.utils.UtilObject;
import co.edu.uco.publiuco.utils.UtilText;
import co.edu.uco.publiuco.utils.UtilUUID;

public class NombreValidation implements Validation<String>{

	private NombreValidation() {
		super();
	}
	public static final Result validate(final String data) {
		return new NombreValidation().execute(data);
	}
	@Override
	public Result execute(String data) {
		var result = Result.create();
		
		if(UtilText.getUtilText().isEmpty(data)) {
			result.addMessage("No es posible continuar con el nombre del estado vacío");
			
		}else {
			if(true) { //tarea
				result.addMessage("El nombre del estado no puede ser menor a 1 o menor a 30 caracteres");
			}
			
			
		}
		return result;
	}

}