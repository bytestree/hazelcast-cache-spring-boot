package com.bytestree.hazelcast.controller;

import com.bytestree.hazelcast.model.Product;
import com.bytestree.hazelcast.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author bytesTree
 * @see <a href="http://www.bytestree.com/">BytesTree</a>
 */

@Slf4j
@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    Environment environment;

    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        String port = environment.getProperty("local.server.port");
        product.setSource("Application@" + port);
        Product savedProduct = productService.saveProduct(product);
        return ResponseEntity.ok().body(savedProduct);
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Integer id) {
        Product product = productService.getProduct(id);
        if (product != null) {
            log.info("Product: {}", product);
            return ResponseEntity.ok().body(product);
        } else {
            log.info("Product with id {} not found", id);
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> removeProduct(@PathVariable("id") Integer id) {
        productService.removeProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
