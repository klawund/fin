package com.klawund.entry.config;

import com.klawund.entry.model.Entry;
import com.klawund.entry.repository.EntryRepository;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.Set;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EntryConfig
{
	@Bean
	public CommandLineRunner entries(EntryRepository repository)
	{
		return args -> repository.saveAll(Set.of(
			Entry.builder().title("salary").ammount(new BigDecimal(4000))
				.dueDate(LocalDate.of(2023, Month.MARCH, 5)).labels(Set.of("income")).build(),

			Entry.builder().title("groceries").ammount(new BigDecimal(-600))
				.dueDate(LocalDate.of(2023, Month.MARCH, 7)).labels(Set.of("groceries")).build(),

			Entry.builder().title("rent").ammount(new BigDecimal(-1200))
				.dueDate(LocalDate.of(2023, Month.MARCH, 10)).labels(Set.of("utilities")).build()));
	}
}
