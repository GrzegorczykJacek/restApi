package com.jg.restApi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.jg.restApi.entities.Discount;
import com.jg.restApi.entities.Product;
import com.jg.restApi.entities.ResultObject;
import com.jg.restApi.repositories.DiscountRepository;
import com.jg.restApi.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;

@Controller
public class HomeController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private DiscountRepository discountRepository;

    @Autowired
    ObjectMapper mapper = new ObjectMapper();

    @GetMapping("/product")
    @ResponseBody
    public String home(
            @RequestParam(defaultValue = "1") Long id
    ) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Product product = productRepository.getOne(id);
            Discount discount = discountRepository.getOne(product.getType());
            product.setView(product.getView() + 1);
            float regularPrice = product.getPrice();
            productRepository.saveAndFlush(product);
            product.getDiscount(discount.getDiscount());
            float discountPrice = product.getPrice();
            return "Regular price: " + regularPrice +
                    "  Price with discount: " + discountPrice +
                    "  Product views: " + product.getView();
        } catch (Exception e) {
            e.printStackTrace();
            return "No such product!";
        }
    }

    @GetMapping("/productJSON")
    @ResponseBody
    public ObjectNode productJSON(
            @RequestParam(defaultValue = "1") Long id
    ) {
            Product product = productRepository.getOne(id);
            Discount discount = discountRepository.getOne(product.getType());
            product.setView(product.getView() + 1);
            float regularPrice = product.getPrice();
            productRepository.saveAndFlush(product);
            product.getDiscount(discount.getDiscount());
            float discountPrice = product.getPrice();
            ObjectNode objectNode = mapper.createObjectNode();
            objectNode.put("regularPrice",regularPrice);
            objectNode.put("discountPrice",discountPrice);
            objectNode.put("productViews",product.getView());
            return objectNode;
    }

    @RequestMapping(value = "/")
    public String home(){
        return "home";
    }

}
