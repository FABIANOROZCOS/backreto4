package com.sergioarboleda.app.services;

import com.sergioarboleda.app.model.HairProduct;
import com.sergioarboleda.app.repositories.HairProductRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author FABIAN
 */
@Service
public class HairProductService {
    @Autowired
    private HairProductRepository repository;
    
    public List<HairProduct> getAll(){
        return repository.getAll();
    }
    
    public Optional<HairProduct> getProduct(String reference){
        return repository.getProduct(reference);
    
    }
    
    public HairProduct create(HairProduct product){
        if(product.getReference()==null){
            return product;
        }else{
            return repository.create(product);
            
        }
    }

    public HairProduct update(HairProduct product){
        
        if (product.getReference()!=null) {
            Optional<HairProduct> productH = repository.getProduct(product.getReference());
            if (!productH.isEmpty()) {
                
                if (product.getBrand()!=null) {
                    productH.get().setBrand(product.getBrand());
                }
                if (product.getCategory()!=null) {
                    productH.get().setCategory(product.getCategory());
                }
                if (product.getDescription()!=null) {
                    productH.get().setDescription(product.getDescription());
                }
                if (product.getPrice()!=0.0){
                    productH.get().setPrice(product.getPrice());
                }
                if (product.getQuantity()!= 0){
                    productH.get().setQuantity(product.getQuantity());
                }
                if (product.getPhotography()!=null) {
                    productH.get().setPhotography(product.getPhotography());
                
                }
                productH.get().setAvailability(product.isAvailability());
                repository.update(productH.get());
                return productH.get();
            }else{
                return product;
            }
        }else{
            return product;
        }
    }
    
    public Boolean delete(String reference){
        Boolean result = getProduct(reference).map(product -> {
            repository.delete(product);
            return true;
        }).orElse(false);
        return result;
    }

}
   
