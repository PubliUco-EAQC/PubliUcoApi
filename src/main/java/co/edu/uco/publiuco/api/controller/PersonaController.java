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

import co.edu.uco.publiuco.dto.PersonaDTO;

public class PersonaController {
	@GetMapping("/dummy")
	public PersonaDTO dummy() {
		return PersonaDTO.create();
	}
	
	@GetMapping
	public List<PersonaDTO> list(@RequestParam PersonaDTO dto) {
		List<PersonaDTO> list = new ArrayList<>();
		return list;
	}
	@GetMapping("/{id}")
	public PersonaDTO listById(@PathVariable UUID id) {
		return PersonaDTO.create().setIdentificador(id);
	}
	@PostMapping
	public PersonaDTO create(@RequestParam PersonaDTO dto) {
		return dto;
	}
	@PutMapping
	public PersonaDTO update(@PathVariable UUID id, @RequestParam PersonaDTO dto) {
		return dto.setIdentificador(id);
	}
	@DeleteMapping
	public PersonaDTO create(@PathVariable UUID id) {
		return PersonaDTO.create().setIdentificador(id);
	}
}
