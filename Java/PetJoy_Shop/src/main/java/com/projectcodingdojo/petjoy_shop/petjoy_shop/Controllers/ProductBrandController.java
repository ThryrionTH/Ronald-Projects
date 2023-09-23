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

import com.projectcodingdojo.petjoy_shop.petjoy_shop.models.ProductBrand;
import com.projectcodingdojo.petjoy_shop.petjoy_shop.services.ProductBrandService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/dashboard/brands")
public class ProductBrandController {

    @Autowired
    private ProductBrandService productBrandService;

    @GetMapping("")
    public String productBrand(@ModelAttribute("productBrand") ProductBrand productBrand, Model model) {
        List<ProductBrand> productsBrands = productBrandService.findActive();
        model.addAttribute("productsBrands", productsBrands);
        return "dashProductBrand";
    }

    @PostMapping("")
    public String saveProductBrand(@Valid @ModelAttribute("productBrand") ProductBrand productBrand, BindingResult result){
    
        ProductBrand existingActiveBrand = productBrandService.findByNombre_marcaAndActive(productBrand.getNombremarca(), 1);
        if (existingActiveBrand != null) {
            result.rejectValue("nombremarca", "duplicate", "Ya existe una marca con el mismo nombre.");
        }
        
        if(result.hasErrors()){
            return "dashProductBrand";
        }
        productBrandService.save(productBrand); 
        return "redirect:/dashboard/brands";
    }

    @PutMapping("/{id}/editProductBrand")
    public String editProductBrand(@Valid @PathVariable("id") Long id,
            @ModelAttribute("productBrand") ProductBrand productBrand, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "dashProductBrand";
        }
        productBrandService.update(productBrand);
        return "redirect:/dashboard/brands";
    }

    @DeleteMapping("/{id}/delete")
    public String deleteProductBrand(@PathVariable("id") Long id) {
        ProductBrand productBrand = productBrandService.findById(id);
        if (productBrand != null) {
            productBrand.setActive(0);
            productBrandService.update(productBrand);
        }
        return "redirect:/dashboard/brands";
    }
}
