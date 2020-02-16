package com.jg.restApi.entities;

import com.jg.restApi.repositories.DiscountRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private float price;
    private int view;
    private String type;

    public void getDiscount(float discount){
        this.price = price - (price * discount);
    }


}
