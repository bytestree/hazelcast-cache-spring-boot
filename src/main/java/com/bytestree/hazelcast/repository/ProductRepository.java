package com.bytestree.hazelcast.repository;

import com.bytestree.hazelcast.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author bytesTree
 * @see <a href="http://www.bytestree.com/">BytesTree</a>
 */

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
