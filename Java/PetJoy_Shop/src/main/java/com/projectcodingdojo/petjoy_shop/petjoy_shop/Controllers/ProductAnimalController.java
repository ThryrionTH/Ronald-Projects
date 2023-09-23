package com.projectcodingdojo.petjoy_shop.petjoy_shop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projectcodingdojo.petjoy_shop.petjoy_shop.models.ProductAnimal;
import com.projectcodingdojo.petjoy_shop.petjoy_shop.services.ProductAnimalService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/dashboard/animals")
public class ProductAnimalController {

    @Autowired 
    private ProductAnimalService productAnimalService;
    
    @GetMapping("")
    public String productAnimal(@ModelAttribute("productAnimal") ProductAnimal productAnimal, Model model){
        List<ProductAnimal> productsAnimals = productAnimalService.findActive();
        model.addAttribute("productsAnimals", productsAnimals);
        return "dashProductAnimal";
    }

    @PostMapping("")
    public String saveProductAnimal(@Valid @ModelAttribute("productAnimal") ProductAnimal productAnimal, BindingResult result){
        ProductAnimal existingActiveAnimal = productAnimalService.findByAnimalandActive(productAnimal.getAnimal(), 1);
        if (existingActiveAnimal != null) {
            result.rejectValue("animal", "duplicate", "Ya existe un tipo de animal con el mismo nombre.");
        }
        if(result.hasErrors()){
            return "dashProductAnimal";
        }
        productAnimalService.save(productAnimal);
        return "redirect:/dashboard/animals";
    }

    @PutMapping("/{id}/editProductAnimal")
    public String editProductAnimal(@Valid @PathVariable("id") Long id, @ModelAttribute("productAnimal") ProductAnimal productAnimal, BindingResult result, Model model){
        if(result.hasErrors()){
            return "dashProductAnimal";
        }
        productAnimalService.update(productAnimal);
        return "redirect:/dashboard/animals";
    }

    @DeleteMapping("/{id}/delete")
    public String deleteProductAnimal(@PathVariable("id") Long id) {
        ProductAnimal productAnimal = productAnimalService.findById(id);
        if (productAnimal != null) {
            productAnimal.setActive(0);
            productAnimalService.update(productAnimal);
        }
        return "redirect:/dashboard/animals";
    }

}

