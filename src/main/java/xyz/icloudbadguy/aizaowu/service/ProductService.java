package xyz.icloudbadguy.aizaowu.service;

import xyz.icloudbadguy.aizaowu.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProductList(String type, String subType, String currentPage, String pageSize);
}
