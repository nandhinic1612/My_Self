package com.Demo.Pagination.Controller;

import com.Demo.Pagination.DTO.APIResponse;
import com.Demo.Pagination.Entity.Product;
import com.Demo.Pagination.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/products")
    public List<Product> addProducts(@RequestBody List<Product> products) {
        return productService.saveProducts(products);
    }

    @GetMapping("/get-products")
    private APIResponse<List<Product>> getProducts() {
        List<Product> allProducts = productService.findAllProducts();
        return new APIResponse<>(allProducts.size(), allProducts);
    }

    @GetMapping("/{field}")
    private APIResponse<List<Product>> getProductswithSort(@PathVariable String field) {
        List<Product> allProducts = productService.WithSorting(field);
        return new APIResponse<>(allProducts.size(), allProducts);
    }

    @GetMapping("/sort-by-color")
    private APIResponse<List<Product>> getProductsSortedByColor() {
        List<Product> sortedProducts = productService.WithSorting("color");
        return new APIResponse<>(sortedProducts.size(), sortedProducts);
    }

    @GetMapping("/sort-by-quantity")
    private APIResponse<List<Product>> getProductsSortedByQuantity() {
        List<Product> sortedProducts = productService.WithSorting("quantity");
        return new APIResponse<>(sortedProducts.size(), sortedProducts);
    }

    @GetMapping("/pagination/{offset}/{pageSize}")
    private APIResponse<Page<Product>> getProductswithPagination(@PathVariable int offset, @PathVariable int pageSize) {
        Page<Product> productsWithPagination = productService.ProductsWithPagination(offset, pageSize);
        return new APIResponse<>(productsWithPagination.getSize(), productsWithPagination);
    }

    @GetMapping("/paginationAndSort/{offset}/{pageSize}/{field}")
    private APIResponse<Page<Product>> getPaginationAndSort(@PathVariable int offset, @PathVariable int pageSize, @PathVariable String field) {
        Page<Product> productsWithPagination = productService.PaginationAndSorting(offset, pageSize, field);
        return new APIResponse<>(productsWithPagination.getSize(), productsWithPagination);
    }
}

/*

http://localhost:8050/api/v1/products  --Posting list of products
http://localhost:8050/api/v1/get-products  --Getting list of products
http://localhost:8050/api/v1/sort-by-quantity  --Sorting
http://localhost:8050/api/v1/pagination/1/5  --Pagination
http://localhost:8050/api/v1/paginationAndSort/0/5/color  --Pagination and Sorting

*/
