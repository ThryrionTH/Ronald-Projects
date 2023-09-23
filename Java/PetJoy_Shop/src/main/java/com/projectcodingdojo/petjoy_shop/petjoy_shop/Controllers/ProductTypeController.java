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

import com.projectcodingdojo.petjoy_shop.petjoy_shop.models.ProductType;
import com.projectcodingdojo.petjoy_shop.petjoy_shop.services.ProductTypeService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/dashboard/categories")
public class ProductTypeController {

    @Autowired
    private ProductTypeService productTypeService;

    @GetMapping("")
    public String productType(@ModelAttribute("productType") ProductType productType, Model model) {
        List<ProductType> productsTypes = productTypeService.findActive();
        model.addAttribute("productsTypes", productsTypes);
        return "dashProductType";
    }

    @PostMapping("")
    public String saveProductType(@Valid @ModelAttribute("productType") ProductType productType, BindingResult result) {
        ProductType existingActiveType = productTypeService.findByCategoriaAndActive(productType.getCategoria(), 1);
        if (existingActiveType != null) {
            result.rejectValue("categoria", "duplicate", "Ya existe una categoría con el mismo nombre.");
        }
        
        if (result.hasErrors()) {
            return "dashProductType";
        }
        productTypeService.save(productType);
        return "redirect:/dashboard/categories";
    }

    @PutMapping("/{id}/editProductType")
    public String editProductType(@Valid @PathVariable("id") Long id,
            @ModelAttribute("productType") ProductType productType, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "dashProductType";
        }
        productTypeService.update(productType);
        return "redirect:/dashboard/categories";
    }

    // Eliminar un producto
        @DeleteMapping("/{id}/delete")
        public String deleteProductType(@PathVariable("id") Long id) {
        ProductType productType = productTypeService.findById(id);
        if (productType != null) {
            productType.setActive(0);
            productTypeService.update(productType);
        }
        return "redirect:/dashboard/categories";
    }
}
