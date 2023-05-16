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

import co.edu.uco.publiuco.dto.EscritorPublicacionDTO;

public class EscritorPublicacionController {
	@GetMapping("/dummy")
	public EscritorPublicacionDTO dummy() {
		return EscritorPublicacionDTO.create();
	}
	
	@GetMapping
	public List<EscritorPublicacionDTO> list(@RequestParam EscritorPublicacionDTO dto) {
		List<EscritorPublicacionDTO> list = new ArrayList<>();
		return list;
	}
	@GetMapping("/{id}")
	public EscritorPublicacionDTO listById(@PathVariable UUID id) {
		return EscritorPublicacionDTO.create().setIdentificador(id);
	}
	@PostMapping
	public EscritorPublicacionDTO create(@RequestParam EscritorPublicacionDTO dto) {
		return dto;
	}
	@PutMapping
	public EscritorPublicacionDTO update(@PathVariable UUID id, @RequestParam EscritorPublicacionDTO dto) {
		return dto.setIdentificador(id);
	}
	@DeleteMapping
	public EscritorPublicacionDTO create(@PathVariable UUID id) {
		return EscritorPublicacionDTO.create().setIdentificador(id);
	}
}
