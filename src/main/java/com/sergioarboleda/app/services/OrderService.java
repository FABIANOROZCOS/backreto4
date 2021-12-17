
package com.sergioarboleda.app.services;

import com.sergioarboleda.app.model.Order;
import com.sergioarboleda.app.repositories.OrderRepository;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author FABIAN
 */
@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;

   
    public List<Order> getAll(){
        return repository.getAll();
    }
    
    public Optional<Order> getOrder(Integer id){
        return repository.getOrder(id);
    
    }
    
    public Order create(Order order){
        if (order.getId() == null){
            return order;
        }else{
            return repository.create(order);
        }
        
          
    }
    
    public Order update (Order order) {
        
        if(order.getId() !=null){
            Optional<Order> orderDB = repository.getOrder(order.getId());
            if(!orderDB.isEmpty()){
                
                if(order.getId()!=null){
                    orderDB.get().setId(order.getId());
                }
                if (order.getRegisterDay() != null) {
                    orderDB.get().setRegisterDay(order.getRegisterDay());
                }

                if (order.getStatus() != null) {
                    orderDB.get().setStatus(order.getStatus());
                }

                if (order.getSalesMan() != null) {
                    orderDB.get().setSalesMan(order.getSalesMan());
                }

                if (order.getProducts() != null) {
                    orderDB.get().setProducts(order.getProducts());
                }

                if (order.getQuantities() != null) {
                    orderDB.get().setQuantities(order.getQuantities());
                }
                repository.update(orderDB.get());
                return orderDB.get();
            } else {
                return order;
            }
            
        } else {
            return order;
        }
    }
    
     public boolean delete(Integer Id){
        return getOrder(Id).map(order -> {
            repository.delete(order);
            return true;
        }).orElse(false);
 
    }
     
    public List<Order> getOrderByZone (String Zone){
        return repository.getOrderByZone(Zone);
    } 
    
    public List<Order> getBySalesManId (Integer id){
        return repository.getByOrderSalesManId(id);
    }
    
    public List<Order> getBySalesManIdAndStatus (Integer id, String status){
        return repository.getBySalesManIdAndStatus(id, status);
    } 
    
    public List<Order> getByRegisterDayAndSalesManId(String registerDay, Integer id){
        return repository.getByRegisterDayAndSalesManId(registerDay, id);
    } 
}
