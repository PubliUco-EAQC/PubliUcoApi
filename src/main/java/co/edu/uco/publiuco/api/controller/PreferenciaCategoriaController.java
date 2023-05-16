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

import co.edu.uco.publiuco.dto.PreferenciaCategoriaDTO;

public class PreferenciaCategoriaController {
	@GetMapping("/dummy")
	public PreferenciaCategoriaDTO dummy() {
		return PreferenciaCategoriaDTO.create();
	}
	
	@GetMapping
	public List<PreferenciaCategoriaDTO> list(@RequestParam PreferenciaCategoriaDTO dto) {
		List<PreferenciaCategoriaDTO> list = new ArrayList<>();
		return list;
	}
	@GetMapping("/{id}")
	public PreferenciaCategoriaDTO listById(@PathVariable UUID id) {
		return PreferenciaCategoriaDTO.create().setIdentificador(id);
	}
	@PostMapping
	public PreferenciaCategoriaDTO create(@RequestParam PreferenciaCategoriaDTO dto) {
		return dto;
	}
	@PutMapping
	public PreferenciaCategoriaDTO update(@PathVariable UUID id, @RequestParam PreferenciaCategoriaDTO dto) {
		return dto.setIdentificador(id);
	}
	@DeleteMapping
	public PreferenciaCategoriaDTO create(@PathVariable UUID id) {
		return PreferenciaCategoriaDTO.create().setIdentificador(id);
	}
}
