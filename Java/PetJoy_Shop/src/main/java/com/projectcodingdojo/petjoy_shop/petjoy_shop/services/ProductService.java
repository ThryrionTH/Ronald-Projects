package com.projectcodingdojo.petjoy_shop.petjoy_shop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.projectcodingdojo.petjoy_shop.petjoy_shop.models.Product;
import com.projectcodingdojo.petjoy_shop.petjoy_shop.repositories.ProductRepository;

@Service
public class ProductService extends BaseService<Product> {

    private ProductRepository repository;

    public ProductService(ProductRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public List<Product> findByIdTypeProduct(int id){
        return repository.findByIdTypeProduct(id);
    }
    
    public Page<Product> findByIdTypeProductPage(int id, String search , Pageable pageable){
        return repository.findByIdTypeProductPage(id,search ,pageable);
    }

    public Product findByNombreAndActive(String nombre, int active) {
        Optional<Product> optionalProduct= repository.findByNombreAndActive(nombre, active);
        if (optionalProduct.isPresent()) {
            return optionalProduct.get();
        } else { 
            return null; 
        }
    }

    public Product findByCodigoAndActive(String codigo, int active) {
        Optional<Product> optionalProduct= repository.findByCodigoAndActive(codigo, active);
        if (optionalProduct.isPresent()) {
            return optionalProduct.get();
        } else { 
            return null; 
        }
    }

    @Override
    public Product update(Product updatedProduct) {
            Optional<Product> optionalProduct = repository.findById(updatedProduct.getId());
            if(optionalProduct.isPresent()){
                Product product = optionalProduct.get();
                product.setNombre(updatedProduct.getNombre());
                product.setImagen(updatedProduct.getImagen());
                product.setPrecio(updatedProduct.getPrecio());
                product.setDescripcion(updatedProduct.getDescripcion());
                product.setStock(updatedProduct.getStock());
                product.setMarca_producto(updatedProduct.getMarca_producto());
                product.setProducto_animal(updatedProduct.getProducto_animal());
                product.setTipo_producto(updatedProduct.getTipo_producto());
                return repository.save(product);
            }else{
                return null;
            }
    } 
    
}
