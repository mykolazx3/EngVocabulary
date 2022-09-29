package com.mykola.engvocabulary.repositories;

import com.mykola.engvocabulary.models.WordsRow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordsRowsRepository extends JpaRepository<WordsRow, Integer> {
}
