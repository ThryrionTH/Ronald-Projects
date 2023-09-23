package com.projectcodingdojo.petjoy_shop.petjoy_shop.controllers;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.projectcodingdojo.petjoy_shop.petjoy_shop.models.Product;
import com.projectcodingdojo.petjoy_shop.petjoy_shop.models.ProductType;
import com.projectcodingdojo.petjoy_shop.petjoy_shop.services.ProductService;
import com.projectcodingdojo.petjoy_shop.petjoy_shop.services.ProductTypeService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductTypeService productTypeService;

    private final int MAYOR_EDAD_DIAS = 6570;

    @GetMapping("")
    public String home(Model model) {
        addRandomProductList(model);
        LocalDate date = LocalDate.now().minusDays(MAYOR_EDAD_DIAS);
        return "home";
    }

    @GetMapping("/verification")
    public String verificationClient(HttpSession session, Model model) {
        Long clientId = (Long) session.getAttribute("client_id");
        if (clientId != null) {
            return "redirect:/checkout";
        }
        return "verification";
    }

    @GetMapping("products")
    public String products(Model model, @RequestParam(name = "idCateg", required = false) Integer idCateg,
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) String s) {
        int idCategoria = (idCateg == null ? 0 : idCateg);
        String search = (s == null ? "" : s.trim().toLowerCase());

        if (page == null || page == 0) {
            page = 0;
        } else {
            page = page - 1;
        }

        PageRequest pageRequest = PageRequest.of(page, 8);

        List<ProductType> productsTypes = productTypeService.findActive();

        Page<Product> productsList = productService.findByIdTypeProductPage(idCategoria, search, pageRequest);
        int totalPage = productsList.getTotalPages();

        if (totalPage > 0) {
            List<Integer> pages = IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList());
            model.addAttribute("pages", pages);
        }

        model.addAttribute("productsTypes", productsTypes);
        model.addAttribute("idCateg", idCategoria);
        model.addAttribute("productsList", productsList.getContent());

        model.addAttribute("actual", page + 1);
        model.addAttribute("siguiente", page + 2);
        model.addAttribute("anterior", page);
        model.addAttribute("ultimo", totalPage);
        model.addAttribute("s", search);

        return "products";
    }

	private void addRandomProductList(Model model) {
		List<Product> productsList = productService.findActive(); 
		Collections.shuffle(productsList); 
		List<Product> randomProducts = productsList.stream().limit(8).collect(Collectors.toList()); 
		model.addAttribute("randomProducts", randomProducts); 
	}
	

}
