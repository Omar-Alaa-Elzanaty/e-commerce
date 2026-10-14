package com.dailycodework.dream_shops.request;

import java.math.BigDecimal;
import java.util.List;

import com.dailycodework.dream_shops.model.Category;
import com.dailycodework.dream_shops.model.Image;

import lombok.Data;

@Data
public class AddProductRequest {
    private Long id;
    private String name;
    private String brand;
    private String description;
    private BigDecimal price;
    private int inverntory;

    private Category category;

    private List<Image> images;
}
