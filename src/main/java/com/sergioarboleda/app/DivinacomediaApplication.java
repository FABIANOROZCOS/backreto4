package com.sergioarboleda.app;

import com.sergioarboleda.app.repositories.crud.HairProductCrudRepository;
import com.sergioarboleda.app.repositories.crud.OrderCrudRepository;
import com.sergioarboleda.app.repositories.crud.UserCrudRepository;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;


@Component
@SpringBootApplication
public class DivinacomediaApplication implements CommandLineRunner{
    @Autowired
    private HairProductCrudRepository productRepository;
    @Autowired
    private UserCrudRepository userRepository;
    @Autowired
    private OrderCrudRepository orderRepository;
    public static void main(String[] args) {
        SpringApplication.run(DivinacomediaApplication.class, args);
    }        
    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat ft   = new SimpleDateFormat("yyyy-MM-dd");
        DateTimeFormatter dtf =  DateTimeFormatter.ofPattern("yyyy-MM-dd");
        productRepository.deleteAll();
        userRepository.deleteAll();
        orderRepository.deleteAll();
        
    }

}
