package com.Demo.Pagination.Repository;

import com.Demo.Pagination.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Integer> {

}
