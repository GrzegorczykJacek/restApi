package com.jg.restApi.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity(name = "discounts")
public class Discount {

    @Id
    private String type;
    private String name;
    private String description;
    private float discount;


}
