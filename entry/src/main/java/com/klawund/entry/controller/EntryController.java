package com.klawund.entry.controller;

import com.klawund.entry.model.Entry;
import com.klawund.entry.repository.EntryRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/entries")
// TODO standardize all returns as DTOs located in a client-lib
// TODO swagger docs
public class EntryController
{
	private final EntryRepository repository;

	@GetMapping("/")
	public ResponseEntity<List<Entry>> findAll()
	{
		return ResponseEntity.ok(repository.findAll());
	}

	@PostMapping("/")
	public ResponseEntity<Entry> save(@RequestBody Entry entry)
	{
		return ResponseEntity.ok(repository.save(entry));
	}
}
