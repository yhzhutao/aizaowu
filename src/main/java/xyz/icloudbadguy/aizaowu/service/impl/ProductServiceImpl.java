package xyz.icloudbadguy.aizaowu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.icloudbadguy.aizaowu.dao.ProductDao;
import xyz.icloudbadguy.aizaowu.dao.UserDao;
import xyz.icloudbadguy.aizaowu.entity.Product;
import xyz.icloudbadguy.aizaowu.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;
    @Override
    public List<Product> getProductList(String type, String subType, String currentPage, String pageSize) {
        List<Product> list = productDao.getProduct(type,subType);
        return list;
    }
}
