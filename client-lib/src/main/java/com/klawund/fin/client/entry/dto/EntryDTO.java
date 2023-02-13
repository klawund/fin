package com.klawund.fin.client.entry.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EntryDTO implements Serializable
{
	private static final long serialVersionUID = 1L;

	private Long id;
	private String title;
	private BigDecimal ammount;
	private LocalDate dueDate;
	private Set<String> labels;
}
