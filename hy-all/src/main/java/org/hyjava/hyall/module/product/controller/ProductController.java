package org.hyjava.hyall.module.product.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hyjava.hyall.common.core.result.Result;

import org.hyjava.hyall.module.product.pojo.dto.ProductDTO;
import org.hyjava.hyall.module.product.pojo.Product;
import org.hyjava.hyall.module.product.service.IProductService;
import org.springframework.web.bind.annotation.*;

@Tag(name = "商品管理", description = "商品信息的增删改查接口")
@RestController
@RequestMapping("/product")
public class ProductController {
    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @Operation(summary = "添加商品", description = "添加单个商品")
    @PostMapping
    public Result<Product> addOneProduct(
            @Parameter(description = "商品信息", required = true) @RequestBody ProductDTO product) {
        Product nProduct = productService.addOneProduct(product);
        return Result.success(nProduct);
    }

    @Operation(summary = "批量添加商品", description = "批量添加多个商品")
    @PostMapping("/batch")
    public Result<Product> addProducts(
            @Parameter(description = "商品列表", required = true) @RequestBody Iterable<Product> product) {
        productService.addProducts(product);
        return Result.success(null);
    }

    @Operation(summary = "删除商品", description = "根据商品ID删除单个商品")
    @DeleteMapping
    public Result<Product> deleteOneProduct(
            @Parameter(description = "商品ID", required = true) @RequestBody Integer productId) {
        productService.deleteOneProduct(productId);
        return Result.success(null);
    }

    @Operation(summary = "批量删除商品", description = "根据商品ID列表批量删除商品")
    @DeleteMapping("/dbatch")
    public Result<Product> deleteProducts(
            @Parameter(description = "商品ID列表", required = true) @RequestBody Iterable<Integer> productId) {
        productService.deleteProducts(productId);
        return Result.success(null);
    }

    @Operation(summary = "更新商品", description = "修改商品信息")
    @PutMapping
    public Result<Product> updateOneProduct(
            @Parameter(description = "商品信息", required = true) @RequestBody ProductDTO product) {
        Product nProduct = productService.updateOneProduct(product);
        return Result.success(nProduct);
    }

    @Operation(summary = "查询商品", description = "根据商品ID查询商品详情")
    @GetMapping
    public Result<Product> queryOneProduct(
            @Parameter(description = "商品ID", required = true) @RequestParam Integer productId) {
        Product nProduct = productService.queryOneProduct(productId);
        return Result.success(nProduct);
    }

}
