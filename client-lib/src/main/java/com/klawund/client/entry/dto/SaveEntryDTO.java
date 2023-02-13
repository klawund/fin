package com.klawund.client.entry.dto;

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
public class SaveEntryDTO implements Serializable
{
	private static final long serialVersionUID = 1L;

	private String title;
	private BigDecimal ammount;
	private LocalDate dueDate;
	private Set<String> labels;
}
