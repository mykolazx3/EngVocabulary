package com.mykola.engvocabulary.models;

import javax.persistence.*;

@Entity
@Table(name = "words_row")
public class WordsRow {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "noun_pronoun")
    private String nounPronoun;
    @Column(name = "noun_pronoun_translate")
    private String nounPronounTranslate;

    @Column(name = "gerund")
    private String gerund;
    @Column(name = "gerund_translate")
    private String gerundTranslate;

    @Column(name = "adjective")
    private String adjective;
    @Column(name = "adjective_translate")
    private String adjectiveTranslate;

    @Column(name = "adverb_preposition_conjunction")
    private String adverbPrepositionConjunction;
    @Column(name = "adverb_preposition_conjunction_translate")
    private String adverbPrepositionConjunctionTranslate;

    @Column(name = "infinitive")
    private String infinitive;
    @Column(name = "infinitive_translate")
    private String infinitiveTranslate;

    @Column(name = "past_simple")
    private String pastSimple;
    @Column(name = "past_simple_translate")
    private String pastSimpleTranslate;

    @Column(name = "participle_2")
    private String participle2;
    @Column(name = "participle_2_translate")
    private String participle2Translate;

    @Column(name = "participle_1")
    private String participle1;
    @Column(name = "participle_1_translate")
    private String participle1Translate;

    @ManyToOne
    @JoinColumn(name = "words_rows_set_id", referencedColumnName = "id")
    private WordsRowsSet wordsRowOwner;

    public WordsRow(){

    }

    public WordsRow(String nounPronoun, String nounPronounTranslate, String gerund, String gerundTranslate, String adjective, String adjectiveTranslate, String adverbPrepositionConjunction, String adverbPrepositionConjunctionTranslate, String infinitive, String infinitiveTranslate, String pastSimple, String pastSimpleTranslate, String participle2, String participle2Translate, String participle1, String participle1Translate, WordsRowsSet wordsRowOwner) {
        this.nounPronoun = nounPronoun;
        this.nounPronounTranslate = nounPronounTranslate;
        this.gerund = gerund;
        this.gerundTranslate = gerundTranslate;
        this.adjective = adjective;
        this.adjectiveTranslate = adjectiveTranslate;
        this.adverbPrepositionConjunction = adverbPrepositionConjunction;
        this.adverbPrepositionConjunctionTranslate = adverbPrepositionConjunctionTranslate;
        this.infinitive = infinitive;
        this.infinitiveTranslate = infinitiveTranslate;
        this.pastSimple = pastSimple;
        this.pastSimpleTranslate = pastSimpleTranslate;
        this.participle2 = participle2;
        this.participle2Translate = participle2Translate;
        this.participle1 = participle1;
        this.participle1Translate = participle1Translate;
        this.wordsRowOwner = wordsRowOwner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNounPronoun() {
        return nounPronoun;
    }

    public void setNounPronoun(String nounPronoun) {
        this.nounPronoun = nounPronoun;
    }

    public String getNounPronounTranslate() {
        return nounPronounTranslate;
    }

    public void setNounPronounTranslate(String nounPronounTranslate) {
        this.nounPronounTranslate = nounPronounTranslate;
    }

    public String getGerund() {
        return gerund;
    }

    public void setGerund(String gerund) {
        this.gerund = gerund;
    }

    public String getGerundTranslate() {
        return gerundTranslate;
    }

    public void setGerundTranslate(String gerundTranslate) {
        this.gerundTranslate = gerundTranslate;
    }

    public String getAdjective() {
        return adjective;
    }

    public void setAdjective(String adjective) {
        this.adjective = adjective;
    }

    public String getAdjectiveTranslate() {
        return adjectiveTranslate;
    }

    public void setAdjectiveTranslate(String adjectiveTranslate) {
        this.adjectiveTranslate = adjectiveTranslate;
    }

    public String getAdverbPrepositionConjunction() {
        return adverbPrepositionConjunction;
    }

    public void setAdverbPrepositionConjunction(String adverbPrepositionConjunction) {
        this.adverbPrepositionConjunction = adverbPrepositionConjunction;
    }

    public String getAdverbPrepositionConjunctionTranslate() {
        return adverbPrepositionConjunctionTranslate;
    }

    public void setAdverbPrepositionConjunctionTranslate(String adverbPrepositionConjunctionTranslate) {
        this.adverbPrepositionConjunctionTranslate = adverbPrepositionConjunctionTranslate;
    }

    public String getInfinitive() {
        return infinitive;
    }

    public void setInfinitive(String infinitive) {
        this.infinitive = infinitive;
    }

    public String getInfinitiveTranslate() {
        return infinitiveTranslate;
    }

    public void setInfinitiveTranslate(String infinitiveTranslate) {
        this.infinitiveTranslate = infinitiveTranslate;
    }

    public String getPastSimple() {
        return pastSimple;
    }

    public void setPastSimple(String pastSimple) {
        this.pastSimple = pastSimple;
    }

    public String getPastSimpleTranslate() {
        return pastSimpleTranslate;
    }

    public void setPastSimpleTranslate(String pastSimpleTranslate) {
        this.pastSimpleTranslate = pastSimpleTranslate;
    }

    public String getParticiple2() {
        return participle2;
    }

    public void setParticiple2(String participle2) {
        this.participle2 = participle2;
    }

    public String getParticiple2Translate() {
        return participle2Translate;
    }

    public void setParticiple2Translate(String participle2Translate) {
        this.participle2Translate = participle2Translate;
    }

    public String getParticiple1() {
        return participle1;
    }

    public void setParticiple1(String participle1) {
        this.participle1 = participle1;
    }

    public String getParticiple1Translate() {
        return participle1Translate;
    }

    public void setParticiple1Translate(String participle1Translate) {
        this.participle1Translate = participle1Translate;
    }

    public WordsRowsSet getWordsRowOwner() {
        return wordsRowOwner;
    }

    public void setWordsRowOwner(WordsRowsSet wordsRowOwner) {
        this.wordsRowOwner = wordsRowOwner;
    }
}
