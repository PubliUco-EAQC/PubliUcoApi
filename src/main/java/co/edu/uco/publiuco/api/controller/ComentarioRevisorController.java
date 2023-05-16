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

import co.edu.uco.publiuco.dto.ComentarioRevisorDTO;


public class ComentarioRevisorController {
	@GetMapping("/dummy")
	public ComentarioRevisorDTO dummy() {
		return ComentarioRevisorDTO.create();
	}
	
	@GetMapping
	public List<ComentarioRevisorDTO> list(@RequestParam ComentarioRevisorDTO dto) {
		List<ComentarioRevisorDTO> list = new ArrayList<>();
		return list;
	}
	@GetMapping("/{id}")
	public ComentarioRevisorDTO listById(@PathVariable UUID id) {
		return ComentarioRevisorDTO.create().setIdentificador(id);
	}
	@PostMapping
	public ComentarioRevisorDTO create(@RequestParam ComentarioRevisorDTO dto) {
		return dto;
	}
	@PutMapping
	public ComentarioRevisorDTO update(@PathVariable UUID id, @RequestParam ComentarioRevisorDTO dto) {
		return dto.setIdentificador(id);
	}
	@DeleteMapping
	public ComentarioRevisorDTO create(@PathVariable UUID id) {
		return ComentarioRevisorDTO.create().setIdentificador(id);
	}
}
