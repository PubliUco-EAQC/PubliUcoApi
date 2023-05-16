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

import co.edu.uco.publiuco.dto.CalificacionDTO;

public class CalificacionController {
	@GetMapping("/dummy")
	public CalificacionDTO dummy() {
		return CalificacionDTO.create();
	}
	
	@GetMapping
	public List<CalificacionDTO> list(@RequestParam CalificacionDTO dto) {
		List<CalificacionDTO> list = new ArrayList<>();
		return list;
	}
	@GetMapping("/{id}")
	public CalificacionDTO listById(@PathVariable UUID id) {
		return CalificacionDTO.create().setIdentificador(id);
	}
	@PostMapping
	public CalificacionDTO create(@RequestParam CalificacionDTO dto) {
		return dto;
	}
	@PutMapping
	public CalificacionDTO update(@PathVariable UUID id, @RequestParam CalificacionDTO dto) {
		return dto.setIdentificador(id);
	}
	@DeleteMapping
	public CalificacionDTO create(@PathVariable UUID id) {
		return CalificacionDTO.create().setIdentificador(id);
	}
}
