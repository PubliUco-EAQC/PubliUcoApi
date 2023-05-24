package co.edu.uco.publiuco.api.controller;

import java.util.ArrayList;


import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.edu.uco.publiuco.api.controller.response.Response;
import co.edu.uco.publiuco.api.validator.estado.EliminarEstadoValidation;
import co.edu.uco.publiuco.api.validator.estado.ModificarEstadoValidation;
import co.edu.uco.publiuco.api.validator.estado.RegistrarEstadoValidation;
import co.edu.uco.publiuco.business.facade.EstadoFacade;
import co.edu.uco.publiuco.business.facade.impl.EstadoFacadeImpl;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoException;
import co.edu.uco.publiuco.dto.EstadoDTO;

@RestController
@RequestMapping("publiuco/api/v1/estado")
public final class EstadoController {
	
	private Logger log = LoggerFactory.getLogger(EstadoController.class);
	
	private EstadoFacade facade;
	
	@GetMapping("/dummy")
	public EstadoDTO dummy() {
		return EstadoDTO.create();
	}
	
	@GetMapping
	public ResponseEntity<Response<EstadoDTO>> list(@RequestBody EstadoDTO dto) {
		facade = new EstadoFacadeImpl();
		
		List<EstadoDTO> list = new ArrayList<>();
		
		List<String> messages = new ArrayList<>();
		messages.add("Estados consultados exitosamente");
		
		Response<EstadoDTO> response = new Response<>(list,messages);
		return new ResponseEntity<Response<EstadoDTO>>(response,HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public EstadoDTO listById(@PathVariable UUID id) {
		return EstadoDTO.create().setIdentificador(id);
	}
	@PostMapping
	public ResponseEntity<Response<EstadoDTO>> create(@RequestBody EstadoDTO dto) {
		var statusCode = HttpStatus.OK;
		var response = new Response<EstadoDTO>();
		
		try {
			var result = RegistrarEstadoValidation.validate(dto);
			if(result.getMessages().isEmpty()) {
				facade = new EstadoFacadeImpl();
				facade.register(dto);
				response.getMessages().add("El nuevo estado fue registrado de forma satisfactoria");
			}else {
				statusCode = HttpStatus.BAD_REQUEST;
				response.setMessages(result.getMessages());
			}
		}catch (PubliUcoException exception) {
			statusCode = HttpStatus.BAD_REQUEST;
			response.getMessages().add(exception.getUserMessage());
			log.error(exception.getType().toString().concat("-").concat(exception.getTechnicalMessage()));
			exception.printStackTrace();
			
		}catch (Exception exception) {
			statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			response.getMessages().add("Se ha presentado un problema inesperado. Por favor contacte con el administrador del sistema");
			log.error("Se ha prsentado un problema inesperado, Por favor validar la consola");
		}
		
		return new ResponseEntity<>(response,statusCode);
	}
	@PutMapping
	public ResponseEntity<Response<EstadoDTO>> update(@PathVariable UUID id, @RequestBody EstadoDTO dto) {
		var statusCode = HttpStatus.OK;
		var response = new Response<EstadoDTO>();
		
		try {
			var result = ModificarEstadoValidation.validate(dto);
			if(result.getMessages().isEmpty()) {
				facade = new EstadoFacadeImpl();
				facade.modify(dto);
				response.getMessages().add("El  estado fue modificado de forma satisfactoria");
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
	public ResponseEntity<Response<EstadoDTO>> drop(@PathVariable UUID id) {
		var statusCode = HttpStatus.OK;
		var response = new Response<EstadoDTO>();
		
		try {
			var result = EliminarEstadoValidation.validate(id);
			if(result.getMessages().isEmpty()) {
				facade = new EstadoFacadeImpl();
				facade.drop(id);
				response.getMessages().add("El estado fue eliminado de forma satisfactoria");
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
