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

import co.edu.uco.publiuco.dto.PlanCategoriaDTO;

public class PlanCategoriaController {
	@GetMapping("/dummy")
	public PlanCategoriaDTO dummy() {
		return PlanCategoriaDTO.create();
	}
	
	@GetMapping
	public List<PlanCategoriaDTO> list(@RequestParam PlanCategoriaDTO dto) {
		List<PlanCategoriaDTO> list = new ArrayList<>();
		return list;
	}
	@GetMapping("/{id}")
	public PlanCategoriaDTO listById(@PathVariable UUID id) {
		return PlanCategoriaDTO.create().setIdentificador(id);
	}
	@PostMapping
	public PlanCategoriaDTO create(@RequestParam PlanCategoriaDTO dto) {
		return dto;
	}
	@PutMapping
	public PlanCategoriaDTO update(@PathVariable UUID id, @RequestParam PlanCategoriaDTO dto) {
		return dto.setIdentificador(id);
	}
	@DeleteMapping
	public PlanCategoriaDTO create(@PathVariable UUID id) {
		return PlanCategoriaDTO.create().setIdentificador(id);
	}

}
