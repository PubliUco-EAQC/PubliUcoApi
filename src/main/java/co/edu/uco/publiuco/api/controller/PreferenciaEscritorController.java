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

import co.edu.uco.publiuco.dto.PreferenciaEscritorDTO;

public class PreferenciaEscritorController {
	@GetMapping("/dummy")
	public PreferenciaEscritorDTO dummy() {
		return PreferenciaEscritorDTO.create();
	}
	
	@GetMapping
	public List<PreferenciaEscritorDTO> list(@RequestParam PreferenciaEscritorDTO dto) {
		List<PreferenciaEscritorDTO> list = new ArrayList<>();
		return list;
	}
	@GetMapping("/{id}")
	public PreferenciaEscritorDTO listById(@PathVariable UUID id) {
		return PreferenciaEscritorDTO.create().setIdentificador(id);
	}
	@PostMapping
	public PreferenciaEscritorDTO create(@RequestParam PreferenciaEscritorDTO dto) {
		return dto;
	}
	@PutMapping
	public PreferenciaEscritorDTO update(@PathVariable UUID id, @RequestParam PreferenciaEscritorDTO dto) {
		return dto.setIdentificador(id);
	}
	@DeleteMapping
	public PreferenciaEscritorDTO create(@PathVariable UUID id) {
		return PreferenciaEscritorDTO.create().setIdentificador(id);
	}
}
