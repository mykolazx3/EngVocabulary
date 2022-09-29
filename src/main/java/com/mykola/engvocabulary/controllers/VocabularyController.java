package com.mykola.engvocabulary.controllers;

import com.mykola.engvocabulary.models.WordsRow;
import com.mykola.engvocabulary.services.VocabularyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/vocabulary")
public class VocabularyController {

    private final VocabularyService vocabularyService;

    @Autowired
    public VocabularyController(VocabularyService vocabularyService) {
        this.vocabularyService = vocabularyService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("wordsRowsSets", vocabularyService.findAll());
        vocabularyService.createSet();
        return "vocabulary/index";
    }
    //SET///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @PostMapping("/new-set")
    public String createSet() {
        vocabularyService.createSet();
        return "redirect:/vocabulary";
    }

    @DeleteMapping("/{id}/delete-set")
    public String deleteSet(@PathVariable("id") int id) {
        vocabularyService.deleteSet(id);
        return "redirect:/vocabulary";
    }
    //ROW///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @PostMapping("/{id}/new-row")
    public String createRow(@PathVariable("id") int id) {
        vocabularyService.createRow(id);
        return "redirect:/vocabulary";
    }

    @DeleteMapping("/{id}/delete-row")
    public String deleteRow(@PathVariable("id") int id) {
        vocabularyService.deleteRow(id);
        return "redirect:/vocabulary";
    }
    //WORD//////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping("/{id}/edit-word/{type}")
    public String edit(@PathVariable("id") int id,
                       @PathVariable("type") String type, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("type", type);
        model.addAttribute("wordsRowToEdit", vocabularyService.findWordsRowToEdit(id));
        model.addAttribute("wordsRowsSets", vocabularyService.findAll());
        return "vocabulary/edit-word";
    }

    @PatchMapping("/{id}/edit-word")
    public String update(@ModelAttribute("wordsRowToEdit") WordsRow wordsRowToEdit,
                         @PathVariable("id") int id) {
        vocabularyService.editWordsRow(id, wordsRowToEdit);
        return "redirect:/vocabulary";
    }
}
