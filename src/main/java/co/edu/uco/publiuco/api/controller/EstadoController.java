ackage co.edu.uco.publiuco.api.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.publiuco.api.controller.response.Response;
import co.edu.uco.publiuco.api.validator.estado.RegistrarEstadoValidation;
import co.edu.uco.publiuco.business.facade.EstadoFacade;
import co.edu.uco.publiuco.business.facade.impl.EstadoFacadeImpl;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoException;
import co.edu.uco.publiuco.dto.EstadoDTO;

@RestController
@RequestMapping("publiuco/api/v1/estado")
public final class EstadoController {
	
	private EstadoFacade facade;
	
	public EstadoController() {
		facade = new EstadoFacadeImpl();
	}
	@GetMapping("/dummy")
	public EstadoDTO dummy() {
		return EstadoDTO.create();
	}
	
	@GetMapping
	public ResponseEntity<Response<EstadoDTO>> list(@RequestParam EstadoDTO dto) {
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
	public EstadoDTO create(@RequestParam EstadoDTO dto) {
		var statusCode = HttpStatus.OK;
		
		try {
			var result = RegistrarEstadoValidation.validate(dto);
			if(result.getMessages().isEmpty()) {
				statusCode = HttpStatus.BAD_REQUEST;
			}
		}catch (PubliucoException e) {
			statusCode = HttpStatus.BAD_REQUEST;
		}catch (Exception e) {
			statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
		}A
		
		return dto;
	}
	@PutMapping
	public EstadoDTO update(@PathVariable UUID id, @RequestParam EstadoDTO dto) {
		return dto.setIdentificador(id);
	}
	@DeleteMapping
	public EstadoDTO create(@PathVariable UUID id) {
		return EstadoDTO.create().setIdentificador(id);
	}
}