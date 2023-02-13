package com.klawund.entry.repository;

import com.klawund.entry.model.Entry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntryRepository extends JpaRepository<Entry, Long>
{
}
