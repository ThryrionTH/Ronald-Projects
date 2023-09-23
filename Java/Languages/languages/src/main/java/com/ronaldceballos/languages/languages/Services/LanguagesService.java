package com.ronaldceballos.languages.languages.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ronaldceballos.languages.languages.Models.LanguagesModel;
import com.ronaldceballos.languages.languages.Repositories.LanguagesRepositorie;

@Service
public class LanguagesService {
    private final LanguagesRepositorie languagesRepositorie;

    public LanguagesService(LanguagesRepositorie languagesRepositorie) {
        this.languagesRepositorie = languagesRepositorie;
    }

    public List<LanguagesModel> allLanguages() {
        return languagesRepositorie.findAll();
    }

    public LanguagesModel createLanguage(LanguagesModel language) {
        return languagesRepositorie.save(language);
    }

    public LanguagesModel findLanguage(Long id) {
        Optional<LanguagesModel> optionalLanguage = languagesRepositorie.findById(id);
        if (optionalLanguage.isPresent()) {
            return optionalLanguage.get();
        } else {
            return null;
        }
    }

    public LanguagesModel updateLanguage(LanguagesModel language) {
        Optional<LanguagesModel> optionalLanguage = languagesRepositorie.findById(language.getId());
        if (optionalLanguage.isPresent()) {
            LanguagesModel existingLanguage = optionalLanguage.get();
            existingLanguage.setName(language.getName());
            existingLanguage.setCreator(language.getCreator());
            existingLanguage.setCurrentVersion(language.getCurrentVersion());
            return languagesRepositorie.save(existingLanguage);
        } else {
            return null;
        }
    }

    public void deleteLanguage(Long id) {
        languagesRepositorie.deleteById(id);
    }
}
