package co.edu.uco.publiuco.api.validator.estado.common;

import java.util.UUID;

import co.edu.uco.publiuco.api.validator.Result;
import co.edu.uco.publiuco.api.validator.Validation;

public final class IdentificadorValidation implements Validation<UUID> {

	private IdentificadorValidation() {
		super();
	}
	
	public static final Result validate(final String data) {
		return new IdentificadorValidation().execute(data);
	}
	
	@Override
	public Result execute(UUID data) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
