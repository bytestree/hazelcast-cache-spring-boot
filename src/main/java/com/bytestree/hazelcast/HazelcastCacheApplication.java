package com.bytestree.hazelcast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author bytesTree
 * @see <a href="http://www.bytestree.com/">BytesTree</a>
 */

@SpringBootApplication
@EnableCaching
public class HazelcastCacheApplication {
    public static void main(String[] args) {
        SpringApplication.run(HazelcastCacheApplication.class, args);
    }
}
