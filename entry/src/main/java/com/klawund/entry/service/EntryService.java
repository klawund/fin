package com.klawund.entry.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Transactional
	public EntryDTO update(Long id, SaveEntryDTO saveEntryDTO)
	{
		Optional<Entry> existingEntryOptional = repository.findById(id);
		if (existingEntryOptional.isPresent())
		{
			// TODO throw exception
			return null;
		}
		
		Entry existingEntry = existingEntryOptional.get();
		
		String newTitle = saveEntryDTO.getTitle();
		if (existingEntry.getTitle() != newTitle)
		{
			existingEntry.setTitle(newTitle);
		}
		
		BigDecimal newAmmount = saveEntryDTO.getAmmount();
		if (!Objects.equals(existingEntry.getAmmount(), newAmmount))
		{
			existingEntry.setAmmount(newAmmount);
		}
		
		LocalDate newDueDate = saveEntryDTO.getDueDate();
		if (!Objects.equals(existingEntry.getDueDate(), newDueDate))
		{
			existingEntry.setDueDate(newDueDate);
		}
		
		Set<String> newLabels = existingEntry.getLabels();
		if (!Objects.equals(existingEntry.getLabels(), newLabels))
		{
			existingEntry.setLabels(newLabels);
		}
		
		return EntryDTO.builder()
				.id(existingEntry.getId())
				.title(existingEntry.getTitle())
				.ammount(existingEntry.getAmmount())
				.dueDate(existingEntry.getDueDate())
				.labels(existingEntry.getLabels())
				.build();
	}
	
	public void remove(Long id)
	{
		repository.deleteById(id);
	}
}
