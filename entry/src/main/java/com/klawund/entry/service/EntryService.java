package com.klawund.entry.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.klawund.client.entry.dto.EntryDTO;
import com.klawund.client.entry.dto.SaveEntryDTO;
import com.klawund.entry.model.Entry;
import com.klawund.entry.repository.EntryRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
// TODO alocate DTO mapping logic to client-lib
public class EntryService
{
	private final EntryRepository repository;
	
	public List<EntryDTO> findAll()
	{
		return repository.findAll().stream().map(entry -> EntryDTO.builder()
				.id(entry.getId())
				.title(entry.getTitle())
				.ammount(entry.getAmmount())
				.dueDate(entry.getDueDate())
				.labels(entry.getLabels()).build()).collect(Collectors.toList());
	}
	
	public EntryDTO save(SaveEntryDTO entry)
	{
		Entry newEntry = repository.save(Entry.builder()
				.title(entry.getTitle())
				.ammount(entry.getAmmount())
				.dueDate(entry.getDueDate())
				.labels(entry.getLabels())
				.build());
		
		return EntryDTO.builder()
				.id(newEntry.getId())
				.title(newEntry.getTitle())
				.ammount(newEntry.getAmmount())
				.dueDate(newEntry.getDueDate())
				.labels(entry.getLabels())
				.build();
	}
}
