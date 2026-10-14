package com.dailycodework.dream_shops.controller;

import java.util.List;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dailycodework.dream_shops.model.Product;
import com.dailycodework.dream_shops.request.AddProductRequest;
import com.dailycodework.dream_shops.request.ProductUpdateRequest;
import com.dailycodework.dream_shops.response.ApiResponse;
import com.dailycodework.dream_shops.service.product.IProductService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.prefix}/products/")
public class ProductController {

    private final IProductService productService;

    @GetMapping("all")
    public ResponseEntity<ApiResponse> getAllProducts() {
        return ResponseEntity.ok(new ApiResponse("success", productService.getAllProducts()));
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(new ApiResponse("success", productService.getProductById(id)));
    }

    @PostMapping("add")
    public ResponseEntity<ApiResponse> addProduct(@RequestBody AddProductRequest product) {

        Product theProduct = productService.addProduct(product);
        return ResponseEntity.ok(new ApiResponse("Product added.", theProduct));
    }

    @PutMapping("update/{productId}")
    public ResponseEntity<ApiResponse> updatePorduct(@RequestBody ProductUpdateRequest request,
            @PathVariable Long productId) {
        Product theProduct = productService.updateProduct(request, productId);

        return ResponseEntity.ok(new ApiResponse("updated", theProduct));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ApiResponse> deleteProduct(Long id) {

        productService.deleteProductById(id);

        return ResponseEntity.ok(new ApiResponse("deleted", null));
    }

    @GetMapping("by/brand-and-name/{brandName}/{productName}")
    public ResponseEntity<ApiResponse> getProducstByBrandName(@RequestParam String brandName,
            @PathVariable String productName) {
        List<Product> products = productService.getProductsByBrandAndName(brandName, productName);

        return ResponseEntity.ok(new ApiResponse("success", products));
    }

    @GetMapping("by/category-and-brand/{brandName}/{productName}")
    public ResponseEntity<ApiResponse> getProductsbyCategoryAndBrand(@PathVariable String category,
            @PathVariable String brand) {
        List<Product> products = productService.getProductsByCategorAndBrand(category, brand);

        return ResponseEntity.ok(new ApiResponse("success", products));
    }

    @GetMapping("/{name}/products")
    public ResponseEntity<ApiResponse> getProductsByName(@PathVariable String name) {
        List<Product> products = productService.getProductsByName(name);

        return ResponseEntity.ok(new ApiResponse("success", products));
    }

    @GetMapping("by-brand")
    public ResponseEntity<ApiResponse> getProductsByBrand(@RequestParam String brand) {
        List<Product> products = productService.getProductsByBrand(brand);

        return ResponseEntity.ok(new ApiResponse("success", products));
    }

    @GetMapping("by-category}")
    public ResponseEntity<ApiResponse> getProductsByCategory(@RequestParam String category) {
        List<Product> products = productService.getProductsByCategory(category);

        return ResponseEntity.ok(new ApiResponse("success", products));
    }

    @GetMapping("brand/{brandName}/{name}/count")
    public ResponseEntity<ApiResponse> getProductsCountByBrandName(@PathVariable String brandName,
            @PathVariable String name) {
        Long count = productService.countPorductsByBrandAndName(brandName, name);

        return ResponseEntity.ok(new ApiResponse("success", count));
    }
}
