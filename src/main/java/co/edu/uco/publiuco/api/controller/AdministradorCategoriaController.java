package co.edu.uco.publiuco.api.controller;

import java.util.ArrayList;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.edu.uco.publiuco.api.controller.response.Response;
import co.edu.uco.publiuco.api.validator.administradorcategoria.ModificarAdministradorCategoriaValidation;
import co.edu.uco.publiuco.api.validator.administradorcategoria.RegistrarAdministradorCategoriaValidation;
import co.edu.uco.publiuco.api.validator.estado.EliminarEstadoValidation;
import co.edu.uco.publiuco.business.facade.AdministradorCategoriaFacade;
import co.edu.uco.publiuco.business.facade.impl.AdministradorCategoriaFacadeImpl;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoException;
import co.edu.uco.publiuco.dto.AdministradorCategoriaDTO;

public class AdministradorCategoriaController {
	private AdministradorCategoriaFacade facade;
	
	public AdministradorCategoriaController() {
		facade = new AdministradorCategoriaFacadeImpl();
	}
	@GetMapping("/dummy")
	public AdministradorCategoriaDTO dummy() {
		return AdministradorCategoriaDTO.create();
	}
	
	@GetMapping
	public ResponseEntity<Response<AdministradorCategoriaDTO>> list(@RequestParam AdministradorCategoriaDTO dto) {
		List<AdministradorCategoriaDTO> list = new ArrayList<>();
		
		List<String> messages = new ArrayList<>();
		messages.add("Administradores de categoria consultados exitosamente");
		
		Response<AdministradorCategoriaDTO> response = new Response<>(list,messages);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Response<AdministradorCategoriaDTO>> create(@RequestParam AdministradorCategoriaDTO dto) {
		var statusCode = HttpStatus.OK;
		Response<AdministradorCategoriaDTO> response = new Response<>();
		
		try {
			var result = RegistrarAdministradorCategoriaValidation.validate(dto);
			if(result.getMessages().isEmpty()) {
				facade.register(dto);
				response.getMessages().add("El nuevo administrador categoria fue registrado de forma satisfactoria");
			}else {
				statusCode = HttpStatus.BAD_REQUEST;
				response.setMessages(result.getMessages());
			}
		}catch (PubliUcoException exception) {
			statusCode = HttpStatus.BAD_REQUEST;
			response.getMessages().add(exception.getUserMessage());
			System.err.println(exception.getTechnicalMessage());
			System.err.println(exception.getType());
			exception.printStackTrace();
			
		}catch (Exception exception) {
			statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			response.getMessages().add("Se ha presentado un problema inesperado. Por favor contacte con el administrador del sistema");
			System.err.println(exception.getMessage());
			exception.printStackTrace();
		}
		
		return new ResponseEntity<>(response,statusCode);
	}
	@PutMapping
	public ResponseEntity<Response<AdministradorCategoriaDTO>> update(@PathVariable UUID id, @RequestParam AdministradorCategoriaDTO dto) {
		var statusCode = HttpStatus.OK;
		var response = new Response<AdministradorCategoriaDTO>();
		
		try {
			var result = ModificarAdministradorCategoriaValidation.validate(dto);
			if(result.getMessages().isEmpty()) {
				facade.modify(dto);
				response.getMessages().add("El administrador categoria fue modificado de forma satisfactoria");
			}else {
				statusCode = HttpStatus.BAD_REQUEST;
				response.setMessages(result.getMessages());
			}
		}catch (PubliUcoException exception) {
			statusCode = HttpStatus.BAD_REQUEST;
			response.getMessages().add(exception.getUserMessage());
			System.err.println(exception.getTechnicalMessage());
			System.err.println(exception.getType());
			exception.printStackTrace();
			
		}catch (Exception exception) {
			statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			response.getMessages().add("Se ha presentado un problema inesperado. Por favor contacte con el administrador del sistema");
			System.err.println(exception.getMessage());
			exception.printStackTrace();
		}
		
		return new ResponseEntity<>(response,statusCode);
	}
	@DeleteMapping
	public ResponseEntity<Response<AdministradorCategoriaDTO>> drop(@PathVariable UUID id) {
		var statusCode = HttpStatus.OK;
		var response = new Response<AdministradorCategoriaDTO>();
		
		try {
			var result = EliminarEstadoValidation.validate(id);
			if(result.getMessages().isEmpty()) {
				facade.drop(id);
				response.getMessages().add("El administrador categoria fue eliminado de forma satisfactoria");
			}else {
				statusCode = HttpStatus.BAD_REQUEST;
				response.setMessages(result.getMessages());
			}
		}catch (PubliUcoException exception) {
			statusCode = HttpStatus.BAD_REQUEST;
			response.getMessages().add(exception.getUserMessage());
			System.err.println(exception.getTechnicalMessage());
			System.err.println(exception.getType());
			exception.printStackTrace();
			
		}catch (Exception exception) {
			statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			response.getMessages().add("Se ha presentado un problema inesperado. Por favor contacte con el administrador del sistema");
			System.err.println(exception.getMessage());
			exception.printStackTrace();
		}
		
		return new ResponseEntity<>(response,statusCode);
	}
}
