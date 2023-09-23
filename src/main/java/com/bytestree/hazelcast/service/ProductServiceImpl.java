package com.bytestree.hazelcast.service;

import com.bytestree.hazelcast.model.Product;
import com.bytestree.hazelcast.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author bytesTree
 * @see <a href="http://www.bytestree.com/">BytesTree</a>
 */
@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    @CachePut(value = "products", key = "#product.id")
    public Product saveProduct(Product product) {
        productRepository.save(product);
        log.info("Adding Product: {}", product);
        return product;
    }

    @Override
    @CacheEvict(value = "products", key = "#id")
    public void removeProduct(Integer id) {
        productRepository.deleteById(id);
        log.info("Removed Product with id: {}", id);
    }

    @Override
    @Cacheable(value = "products", key = "#id")
    public Product getProduct(Integer id) {
        log.info("Getting Product with id {} from Repository", id);
        Product product = productRepository.findById(id).orElse(null);
        log.info("Product retrieved from Repository: {}", product);
        return product;
    }
}
