package co.edu.uco.publiuco.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.edu.uco.publiuco.dto.ObservacionRevisionDTO;

public class ObservacionRevisionController {
	@GetMapping("/dummy")
	public ObservacionRevisionDTO dummy() {
		return ObservacionRevisionDTO.create();
	}
	
	@GetMapping
	public List<ObservacionRevisionDTO> list(@RequestParam ObservacionRevisionDTO dto) {
		List<ObservacionRevisionDTO> list = new ArrayList<>();
		return list;
	}
	@GetMapping("/{id}")
	public ObservacionRevisionDTO listById(@PathVariable UUID id) {
		return ObservacionRevisionDTO.create().setIdentificador(id);
	}
	@PostMapping
	public ObservacionRevisionDTO create(@RequestParam ObservacionRevisionDTO dto) {
		return dto;
	}
	@PutMapping
	public ObservacionRevisionDTO update(@PathVariable UUID id, @RequestParam ObservacionRevisionDTO dto) {
		return dto.setIdentificador(id);
	}
	@DeleteMapping
	public ObservacionRevisionDTO create(@PathVariable UUID id) {
		return ObservacionRevisionDTO.create().setIdentificador(id);
	}
}
