package com.klawund.entry.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klawund.client.entry.dto.EntryDTO;
import com.klawund.client.entry.dto.SaveEntryDTO;
import com.klawund.entry.service.EntryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/entries")
// TODO swagger docs
public class EntryController
{
	private final EntryService service;

	@GetMapping("/")
	public ResponseEntity<List<EntryDTO>> findAll()
	{
		return ResponseEntity.ok(service.findAll());
	}

	@PostMapping("/")
	public ResponseEntity<EntryDTO> save(@RequestBody SaveEntryDTO entry)
	{
		return ResponseEntity.ok(service.save(entry));
	}
}
