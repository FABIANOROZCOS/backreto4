
package com.sergioarboleda.app.repositories.crud;

import com.sergioarboleda.app.model.Order;
import java.util.Date;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author FABIAN
 */
public interface OrderCrudRepository extends MongoRepository<Order, Integer>{
    
    List<Order> findBySalesManZone(String zone);
    List<Order> findBySalesManId(Integer id);
    List<Order> findBySalesManIdAndStatus(Integer id, String status);
    List<Order> findByRegisterDayAndSalesManId(Date registerDay, Integer id);
}
