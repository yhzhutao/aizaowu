package xyz.icloudbadguy.aizaowu.dao;

import xyz.icloudbadguy.aizaowu.entity.Product;

import java.util.List;

public interface ProductDao {
    List<Product> getProduct(String type, String subType);
}
