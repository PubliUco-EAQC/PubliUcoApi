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

import co.edu.uco.publiuco.dto.HistorialAccesoPublicacionDTO;


public class HistorialAccesoPublicacionController {
	@GetMapping("/dummy")
	public HistorialAccesoPublicacionDTO dummy() {
		return HistorialAccesoPublicacionDTO.create();
	}
	
	@GetMapping
	public List<HistorialAccesoPublicacionDTO> list(@RequestParam HistorialAccesoPublicacionDTO dto) {
		List<HistorialAccesoPublicacionDTO> list = new ArrayList<>();
		return list;
	}
	@GetMapping("/{id}")
	public HistorialAccesoPublicacionDTO listById(@PathVariable UUID id) {
		return HistorialAccesoPublicacionDTO.create().setIdentificador(id);
	}
	@PostMapping
	public HistorialAccesoPublicacionDTO create(@RequestParam HistorialAccesoPublicacionDTO dto) {
		return dto;
	}
	@PutMapping
	public HistorialAccesoPublicacionDTO update(@PathVariable UUID id, @RequestParam HistorialAccesoPublicacionDTO dto) {
		return dto.setIdentificador(id);
	}
	@DeleteMapping
	public HistorialAccesoPublicacionDTO create(@PathVariable UUID id) {
		return HistorialAccesoPublicacionDTO.create().setIdentificador(id);
	}
}
