package com.mykola.engvocabulary.models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "words_rows_set")
public class WordsRowsSet {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "wordsRowOwner")
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.REMOVE})
    private List<WordsRow> wordsRows;

    public WordsRowsSet() {

    }

    public WordsRowsSet(String name, List<WordsRow> wordsRows) {
        this.name = name;
        this.wordsRows = wordsRows;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<WordsRow> getWordsRows() {
        return wordsRows;
    }

    public void setWordsRows(List<WordsRow> wordsRows) {
        this.wordsRows = wordsRows;
    }

    public int getSizeOfWordsRows(){
        return wordsRows.size();
    }
}
