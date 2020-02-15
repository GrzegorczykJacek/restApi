package com.jg.restApi;

import com.jg.restApi.entities.Product;
import com.jg.restApi.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/product")
    @ResponseBody
    public String home(
            @RequestParam(defaultValue = "1") Long id
    ) {
        try {
            Product product = productRepository.getOne(id);
            product.setView(product.getView() + 1);
            float regularPrice = product.getPrice();
            productRepository.saveAndFlush(product);
            product.getDiscount();
            float discountPrice = product.getPrice();
            return "Regular price: " + regularPrice +
                    " Price with discount 1: " + discountPrice +
                    " Product views: " + product.getView();
        } catch (Exception e) {
            e.printStackTrace();
            return "No such product!";
        }
    }

}
