package com.bytestree.hazelcast.service;

import com.bytestree.hazelcast.model.Product;

/**
 * @author bytesTree
 * @see <a href="http://www.bytestree.com/">BytesTree</a>
 */

public interface ProductService {

    Product saveProduct(Product product);

    void removeProduct(Integer id);

    Product getProduct(Integer id);
}
