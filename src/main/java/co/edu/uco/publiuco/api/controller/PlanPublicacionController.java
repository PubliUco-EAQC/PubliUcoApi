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

import co.edu.uco.publiuco.dto.PlanPublicacionDTO;

public class PlanPublicacionController {
	@GetMapping("/dummy")
	public PlanPublicacionDTO dummy() {
		return PlanPublicacionDTO.create();
	}
	
	@GetMapping
	public List<PlanPublicacionDTO> list(@RequestParam PlanPublicacionDTO dto) {
		List<PlanPublicacionDTO> list = new ArrayList<>();
		return list;
	}
	@GetMapping("/{id}")
	public PlanPublicacionDTO listById(@PathVariable UUID id) {
		return PlanPublicacionDTO.create().setIdentificador(id);
	}
	@PostMapping
	public PlanPublicacionDTO create(@RequestParam PlanPublicacionDTO dto) {
		return dto;
	}
	@PutMapping
	public PlanPublicacionDTO update(@PathVariable UUID id, @RequestParam PlanPublicacionDTO dto) {
		return dto.setIdentificador(id);
	}
	@DeleteMapping
	public PlanPublicacionDTO create(@PathVariable UUID id) {
		return PlanPublicacionDTO.create().setIdentificador(id);
	}
}
