package co.edu.uco.publiuco.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import co.edu.uco.publiuco.dto.EscritorDTO;

public class PaisController {
	@GetMapping("/dummy")
	public EscritorDTO dummy() {
		return EscritorDTO.create();
	}
	
	@GetMapping
	public List<EscritorDTO> list(@RequestParam EscritorDTO dto) {
		List<EscritorDTO> list = new ArrayList<>();
		return list;
	}
	@GetMapping("/{id}")
	public EscritorDTO listById(@PathVariable UUID id) {
		return EscritorDTO.create().setIdentificador(id);
	}

}
