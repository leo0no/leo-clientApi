package com.leoono.api.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.leoono.api.model.Client;
import com.leoono.api.repository.ClientRepository;

@RestController
@RequestMapping("/clients")
public class ClientController {
	//Local Variables
	@Autowired
	private ClientRepository clientRepo;
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<Client> addClient(@RequestBody Client client) {
		Client saved = clientRepo.save(client);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
				replacePath("/clients").path("/{id}").buildAndExpand(saved.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping
	public ResponseEntity<List<Client>> getClientList() {
		return ResponseEntity.ok().body(clientRepo.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Client> getClient(@PathVariable Integer id) {
		return ResponseEntity.ok().body(clientRepo.findById(id).get());
	}
}
