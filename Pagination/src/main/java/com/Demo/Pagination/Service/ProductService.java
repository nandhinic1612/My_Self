package com.Demo.Pagination.Service;

import com.Demo.Pagination.Entity.Product;
import com.Demo.Pagination.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;


    public List<Product> saveProducts(List<Product> products) {
        return productRepo.saveAll(products);
    }
    public List<Product> findAllProducts() {
        return productRepo.findAll();
    }

    public List<Product> WithSorting(String field){
        return productRepo.findAll(Sort.by(Sort.Direction.ASC,field));
    }

    public Page<Product> ProductsWithPagination(int offset, int pagesize){
        Page<Product> products = productRepo.findAll(PageRequest.of(offset,pagesize));
        return products;
    }

    public Page<Product> PaginationAndSorting(int offset, int pagesize, String field){
        Page<Product> products = productRepo.findAll(PageRequest.of(offset,pagesize).withSort(Sort.by(field)));
        return products;
    }
}
