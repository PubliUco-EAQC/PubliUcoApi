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

import co.edu.uco.publiuco.dto.LectorDTO;

public class LectorController {
	@GetMapping("/dummy")
	public LectorDTO dummy() {
		return LectorDTO.create();
	}
	
	@GetMapping
	public List<LectorDTO> list(@RequestParam LectorDTO dto) {
		List<LectorDTO> list = new ArrayList<>();
		return list;
	}
	@GetMapping("/{id}")
	public LectorDTO listById(@PathVariable UUID id) {
		return LectorDTO.create().setIdentificador(id);
	}
	@PostMapping
	public LectorDTO create(@RequestParam LectorDTO dto) {
		return dto;
	}
	@PutMapping
	public LectorDTO update(@PathVariable UUID id, @RequestParam LectorDTO dto) {
		return dto.setIdentificador(id);
	}
	@DeleteMapping
	public LectorDTO create(@PathVariable UUID id) {
		return LectorDTO.create().setIdentificador(id);
	}
}
