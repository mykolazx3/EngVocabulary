package com.mykola.engvocabulary.services;

import com.mykola.engvocabulary.models.WordsRow;
import com.mykola.engvocabulary.models.WordsRowsSet;
import com.mykola.engvocabulary.repositories.WordsRowSetsRepository;
import com.mykola.engvocabulary.repositories.WordsRowsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class VocabularyService {

    private final WordsRowSetsRepository wordsRowSetsRepository;
    private final WordsRowsRepository wordsRowsRepository;

    @Autowired
    public VocabularyService(WordsRowSetsRepository wordsRowSetsRepository, WordsRowsRepository wordsRowsRepository) {
        this.wordsRowSetsRepository = wordsRowSetsRepository;
        this.wordsRowsRepository = wordsRowsRepository;
    }

    //SET///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public List<WordsRowsSet> findAll() {
        return wordsRowSetsRepository.findAll();
    }

    @Transactional
    public void createSet() {
        WordsRowsSet wordsRowsSet = new WordsRowsSet();
        wordsRowSetsRepository.save(wordsRowsSet);
    }

    @Transactional
    public void deleteSet(int id) {
        wordsRowSetsRepository.deleteById(id);
    }

    //ROW///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Transactional
    public void createRow(int id) {
        Optional<WordsRowsSet> wordsRowsSet = wordsRowSetsRepository.findById(id);
        WordsRowsSet wordsRowsSet_ = wordsRowsSet.get();

        WordsRow wordsRow = new WordsRow();
        wordsRow.setNounPronoun("-");
        wordsRow.setGerund("-");
        wordsRow.setAdjective("-");
        wordsRow.setAdverbPrepositionConjunction("-");
        wordsRow.setInfinitive("-");
        wordsRow.setPastSimple("-");
        wordsRow.setParticiple2("-");
        wordsRow.setParticiple1("-");
        wordsRow.setWordsRowOwner(wordsRowsSet_);
        wordsRowsRepository.save(wordsRow);
    }

    @Transactional
    public void deleteRow(int id) {
        wordsRowsRepository.deleteById(id);
    }

    @Transactional
    public WordsRow findWordsRowToEdit(int id){
       Optional<WordsRow> wordsRowToEdit = wordsRowsRepository.findById(id);
       return wordsRowToEdit.get();
    }

    @Transactional
    public void editWordsRow(int id, WordsRow wordsRowToEdit){
        Optional<WordsRow> editedWordsRow = wordsRowsRepository.findById(id);
        WordsRow editedWordsRow_ = editedWordsRow.get();

        editedWordsRow_.setId(id);
        editedWordsRow_.setNounPronoun(wordsRowToEdit.getNounPronoun());
        editedWordsRow_.setNounPronounTranslate((wordsRowToEdit.getNounPronounTranslate()));

        editedWordsRow_.setGerund(wordsRowToEdit.getGerund());
        editedWordsRow_.setGerundTranslate(wordsRowToEdit.getGerundTranslate());

        editedWordsRow_.setAdjective(wordsRowToEdit.getAdjective());
        editedWordsRow_.setAdjectiveTranslate(wordsRowToEdit.getAdjectiveTranslate());

        editedWordsRow_.setAdverbPrepositionConjunction(wordsRowToEdit.getAdverbPrepositionConjunction());
        editedWordsRow_.setAdverbPrepositionConjunctionTranslate(wordsRowToEdit.getAdverbPrepositionConjunctionTranslate());

        editedWordsRow_.setInfinitive(wordsRowToEdit.getInfinitive());
        editedWordsRow_.setInfinitiveTranslate(wordsRowToEdit.getInfinitiveTranslate());

        editedWordsRow_.setPastSimple(wordsRowToEdit.getPastSimple());
        editedWordsRow_.setPastSimpleTranslate(wordsRowToEdit.getPastSimpleTranslate());

        editedWordsRow_.setParticiple2(wordsRowToEdit.getParticiple2());
        editedWordsRow_.setParticiple2Translate(wordsRowToEdit.getParticiple2Translate());

        editedWordsRow_.setParticiple1(wordsRowToEdit.getParticiple1());
        editedWordsRow_.setParticiple1Translate(wordsRowToEdit.getParticiple1Translate());

        wordsRowsRepository.save(editedWordsRow_);
    }

}
