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

import co.edu.uco.publiuco.dto.CategoriaDTO;


public class CategoriaController {
	@GetMapping("/dummy")
	public CategoriaDTO dummy() {
		return CategoriaDTO.create();
	}
	
	@GetMapping
	public List<CategoriaDTO> list(@RequestParam CategoriaDTO dto) {
		List<CategoriaDTO> list = new ArrayList<>();
		return list;
	}
	@GetMapping("/{id}")
	public CategoriaDTO listById(@PathVariable UUID id) {
		return CategoriaDTO.create().setIdentificador(id);
	}
	@PostMapping
	public CategoriaDTO create(@RequestParam CategoriaDTO dto) {
		return dto;
	}
	@PutMapping
	public CategoriaDTO update(@PathVariable UUID id, @RequestParam CategoriaDTO dto) {
		return dto.setIdentificador(id);
	}
	@DeleteMapping
	public CategoriaDTO create(@PathVariable UUID id) {
		return CategoriaDTO.create().setIdentificador(id);
	}
}
