package com.sergioarboleda.app.repositories.crud;

import com.sergioarboleda.app.model.HairProduct;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author FABIAN
 */
public interface HairProductCrudRepository extends MongoRepository<HairProduct, String> {
    
}
