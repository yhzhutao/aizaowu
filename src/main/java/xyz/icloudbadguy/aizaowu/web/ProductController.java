package xyz.icloudbadguy.aizaowu.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.icloudbadguy.aizaowu.entity.Product;
import xyz.icloudbadguy.aizaowu.entity.Result;
import xyz.icloudbadguy.aizaowu.service.ProductService;
import xyz.icloudbadguy.aizaowu.service.UserService;
import xyz.icloudbadguy.aizaowu.util.JsonResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@CrossOrigin
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping(value = "/getProductList")
    private Result getProductList(HttpServletRequest request , HttpServletResponse response){
        String type = request.getParameter("type");
        String subType = request.getParameter("subType");
        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");
        List<Product> list = productService.getProductList(type,subType,currentPage,pageSize);
        return JsonResult.success(list);
    }
}
