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

import co.edu.uco.publiuco.dto.PalabraClavePublicacionDTO;

public class PalabraClavePublicacionController {
	@GetMapping("/dummy")
	public PalabraClavePublicacionDTO dummy() {
		return PalabraClavePublicacionDTO.create();
	}
	
	@GetMapping
	public List<PalabraClavePublicacionDTO> list(@RequestParam PalabraClavePublicacionDTO dto) {
		List<PalabraClavePublicacionDTO> list = new ArrayList<>();
		return list;
	}
	@GetMapping("/{id}")
	public PalabraClavePublicacionDTO listById(@PathVariable UUID id) {
		return PalabraClavePublicacionDTO.create().setIdentificador(id);
	}
	@PostMapping
	public PalabraClavePublicacionDTO create(@RequestParam PalabraClavePublicacionDTO dto) {
		return dto;
	}
	@PutMapping
	public PalabraClavePublicacionDTO update(@PathVariable UUID id, @RequestParam PalabraClavePublicacionDTO dto) {
		return dto.setIdentificador(id);
	}
	@DeleteMapping
	public PalabraClavePublicacionDTO create(@PathVariable UUID id) {
		return PalabraClavePublicacionDTO.create().setIdentificador(id);
	}
}
