package com.sergioarboleda.app.controller;

import com.sergioarboleda.app.model.HairProduct;
import com.sergioarboleda.app.services.HairProductService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author FABIAN
 */
@RestController
@RequestMapping("hairproducts")
@CrossOrigin(origins = "*")

public class HairProductController {
    
    @Autowired
    private HairProductService service;
    
    @GetMapping("/all")
    public List<HairProduct> getAll() {
        return service.getAll();
    }
    
     @GetMapping("/{reference}")
    public Optional<HairProduct> getProduct(@PathVariable("reference") String reference) {
        return service.getProduct(reference);
    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public HairProduct create(@RequestBody HairProduct gadget){
        return service.create(gadget);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public HairProduct update(@RequestBody HairProduct gadget){
        return service.update(gadget);
    }
 
    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference){
        return service.delete(reference);
    }

}

