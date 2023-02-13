package com.klawund.client.entry.feign;

import com.klawund.client.entry.dto.EntryDTO;
import com.klawund.client.entry.dto.SaveEntryDTO;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "entry", path = "entries")
@Component
public interface EntryFeignClient
{
	@GetMapping("/")
	ResponseEntity<List<EntryDTO>> findAll();

	@PostMapping("/")
	ResponseEntity<EntryDTO> save(@RequestBody SaveEntryDTO saveEntryDTO);

	@PutMapping("/{id}")
	ResponseEntity<EntryDTO> update(@RequestParam("id") Long id, @RequestBody SaveEntryDTO saveEntryDTO);

	@DeleteMapping("/{id}")
	ResponseEntity<Void> delete(@RequestParam("id") Long id);
}
