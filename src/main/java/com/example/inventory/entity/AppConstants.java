package com.example.inventory.entity;

public class AppConstants {


    public static final String PRODUCT_NAME_EMPTY = "Product name cannot be empty.";
    public static final String PRODUCT_PRICE_INVALID = "Price must be greater than 0.";
    public static final String CATEGORY_ID_INVALID = "Category ID cannot be null.";

    public static final String INVALID_PRODUCT_ID = "Product with the given ID does not exist.";
    public static final String INVALID_CATEGORY_ID = "Category with the given ID does not exist.";
    public static final String LOW_STOCK_WARNING = "Stock for product %s is low (%d remaining).";


    public static final String FIELD_NOT_EMPTY = "%s cannot be empty.";
    public static final String FIELD_NOT_NULL = "%s cannot be null.";
    public static final String PRICE_GREATER_THAN_ZERO = "Price must be greater than 0.";

    public static final String BASE_URL = "/api";
    public static final String PRODUCT_URL = BASE_URL + "/products";
    public static final String CATEGORY_URL = BASE_URL + "/categories";
    

    public static final int DEFAULT_STOCK_THRESHOLD = 10;
    

    public static final int DEFAULT_PAGE_SIZE = 20;
    public static final String SORT_BY_NAME = "name";
    public static final String SORT_BY_PRICE = "price";
}
