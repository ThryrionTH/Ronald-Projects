package com.ronaldceballos.languages.languages.Controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ronaldceballos.languages.languages.Models.LanguagesModel;
import com.ronaldceballos.languages.languages.Services.LanguagesService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class LanguagesController {
    private final LanguagesService languagesService;

    public LanguagesController(LanguagesService languagesService) {
        this.languagesService = languagesService;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<LanguagesModel> language = languagesService.allLanguages();
        model.addAttribute("languages", language);
        return "index";
    }

    @RequestMapping("/languages/new")
    public String newLanguage(@ModelAttribute("language") LanguagesModel language) {
        return "new";
    }

    @RequestMapping(value= "/languages",  method = RequestMethod.POST)
    public String createLanguage(@Valid @ModelAttribute("language") LanguagesModel language, BindingResult result) {
        if (result.hasErrors()) {
            return "languages/new";
        } else {
            languagesService.createLanguage(language);
            Long createdLanguageId = language.getId();
            return "redirect:/languages/" + createdLanguageId;
        }
    }

    @RequestMapping("languages/{id}")
    public String showLanguage(@PathVariable("id") Long id, Model model) {
        LanguagesModel language = languagesService.findLanguage(id);
        model.addAttribute("language", language);
        return "show";
    }

    @RequestMapping("/languages/{id}/edit")
    public String editLanguage(@PathVariable("id") Long id, Model model) {
        LanguagesModel language = languagesService.findLanguage(id);
        model.addAttribute("language", language);
        return "edit";
    }

    @RequestMapping(value="/languages/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("language") LanguagesModel language, BindingResult result) {
        if (result.hasErrors()) {
            return "/languages/edit.jsp";
        } else {
            languagesService.updateLanguage(language);
            return "redirect:/languages/" + language.getId();
        }
    }
    
    @RequestMapping(value = "/languages/{id}", method = RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
        languagesService.deleteLanguage(id);
        return "redirect:/";
    }
}
