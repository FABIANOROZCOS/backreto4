
package com.sergioarboleda.app.repositories;

import com.sergioarboleda.app.model.Order;
import com.sergioarboleda.app.repositories.crud.OrderCrudRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author FABIAN
 */
@Repository
public class OrderRepository {
    @Autowired
    private OrderCrudRepository repository;
    
    
    public List<Order> getAll() {
        return (List<Order>) repository.findAll();
    }


    public Optional<Order> getOrder(Integer id){
        return repository.findById(id);
    }
    
    public Order create(Order Order) {
        return repository.save(Order);
    }
    
    public void update(Order Order) {
        repository.save(Order);
    }
    
    public void delete(Order Order) {
        repository.delete(Order);
    }
    
       
    public List<Order> getOrderByZone(String zone){
        return repository.findBySalesManZone(zone);
    }
    
    public List<Order> getByOrderSalesManId(Integer id){
        return repository.findBySalesManId(id);
    }
    
    public List<Order> getBySalesManIdAndStatus(Integer id, String status){
        return repository.findBySalesManIdAndStatus(id, status);
    }
    
    public List<Order> getByRegisterDayAndSalesManId(String registerDay, Integer id){
        
        try {
            return repository.findByRegisterDayAndSalesManId(new SimpleDateFormat("yyyy-MM-dd").parse(registerDay), id);
        } catch (ParseException e) {
           e.printStackTrace();
           return null;
        }
   }
    
}
