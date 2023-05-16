package co.edu.uco.publiuco.api.validator.calificacion.common;

import co.edu.uco.publiuco.api.validator.Result;
import co.edu.uco.publiuco.api.validator.Validation;
import co.edu.uco.publiuco.utils.UtilText;

public class CalificacionValidation implements Validation<String> {
	private CalificacionValidation() {
		super();
	}
	public static final Result validate(final String data) {
		return new CalificacionValidation().execute(data);
	}
	@Override
	public Result execute(String data) {
		var result = Result.create();
		
		if(UtilText.isEmpty(data)) {
			result.addMessage("No es posible continuar con una calificacion vacia");
			
		}
		return result;
	}
}
