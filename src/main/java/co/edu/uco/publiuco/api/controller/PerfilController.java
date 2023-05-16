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

import co.edu.uco.publiuco.dto.PerfilDTO;

public class PerfilController {
	@GetMapping("/dummy")
	public PerfilDTO dummy() {
		return PerfilDTO.create();
	}
	
	@GetMapping
	public List<PerfilDTO> list(@RequestParam PerfilDTO dto) {
		List<PerfilDTO> list = new ArrayList<>();
		return list;
	}
	@GetMapping("/{id}")
	public PerfilDTO listById(@PathVariable UUID id) {
		return PerfilDTO.create().setIdentificador(id);
	}
	@PostMapping
	public PerfilDTO create(@RequestParam PerfilDTO dto) {
		return dto;
	}
	@PutMapping
	public PerfilDTO update(@PathVariable UUID id, @RequestParam PerfilDTO dto) {
		return dto.setIdentificador(id);
	}
	@DeleteMapping
	public PerfilDTO create(@PathVariable UUID id) {
		return PerfilDTO.create().setIdentificador(id);
	}
}
