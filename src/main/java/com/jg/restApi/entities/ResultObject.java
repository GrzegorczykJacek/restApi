package com.jg.restApi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResultObject {

    private float regularPrice;
    private float priceWithDiscount;
    private int productViews;

}
