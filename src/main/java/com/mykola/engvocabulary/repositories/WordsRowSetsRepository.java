package com.mykola.engvocabulary.repositories;

import com.mykola.engvocabulary.models.WordsRowsSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordsRowSetsRepository extends JpaRepository<WordsRowsSet, Integer> {
}
