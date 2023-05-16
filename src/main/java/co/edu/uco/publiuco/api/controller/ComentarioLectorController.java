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

import co.edu.uco.publiuco.dto.ComentarioLectorDTO;

public class ComentarioLectorController {
	@GetMapping("/dummy")
	public ComentarioLectorDTO dummy() {
		return ComentarioLectorDTO.create();
	}
	
	@GetMapping
	public List<ComentarioLectorDTO> list(@RequestParam ComentarioLectorDTO dto) {
		List<ComentarioLectorDTO> list = new ArrayList<>();
		return list;
	}
	@GetMapping("/{id}")
	public ComentarioLectorDTO listById(@PathVariable UUID id) {
		return ComentarioLectorDTO.create().setIdentificador(id);
	}
	@PostMapping
	public ComentarioLectorDTO create(@RequestParam ComentarioLectorDTO dto) {
		return dto;
	}
	@PutMapping
	public ComentarioLectorDTO update(@PathVariable UUID id, @RequestParam ComentarioLectorDTO dto) {
		return dto.setIdentificador(id);
	}
	@DeleteMapping
	public ComentarioLectorDTO create(@PathVariable UUID id) {
		return ComentarioLectorDTO.create().setIdentificador(id);
	}
}
