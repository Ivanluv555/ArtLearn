package org.hyjava.hyall.module.orderitem.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hyjava.hyall.common.core.result.Result;

import org.hyjava.hyall.module.orderitem.pojo.Orderitem;
import org.hyjava.hyall.module.orderitem.pojo.dto.OrderitemDTO;
import org.hyjava.hyall.module.orderitem.service.IOrderitemService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "订单项管理", description = "订单明细项的增删改查接口")
@RestController
@RequestMapping("/orderitem")
public class OrderitemController {
    private final IOrderitemService orderItemService;

    public OrderitemController(IOrderitemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    @Operation(summary = "添加订单项", description = "向订单中添加商品项")
    @PostMapping
    public Result<Orderitem> addOrderItem(
            @Parameter(description = "订单项信息", required = true) @RequestBody @Validated OrderitemDTO orderItem) {
        Orderitem norderitem = orderItemService.addOrderItem(orderItem);
        return Result.success(norderitem);
    }

    @Operation(summary = "删除订单项", description = "根据订单项ID删除订单项")
    @DeleteMapping
    public void deleteOrderItem(
            @Parameter(description = "订单项ID", required = true) @RequestBody Integer orderItemId) {
        orderItemService.deleteOrderItem(orderItemId);
    }

    @Operation(summary = "更新订单项", description = "修改订单项信息")
    @PutMapping
    public Result<Orderitem> updateOrderItem(
            @Parameter(description = "订单项信息", required = true) @RequestBody @Validated OrderitemDTO orderItem) {
        Orderitem norderitem = orderItemService.updateOrderItem(orderItem);
        return Result.success(norderitem);
    }

    @Operation(summary = "查询订单项", description = "根据订单项ID查询订单项详情")
    @GetMapping
    public Result<Orderitem> queryOrderItem(
            @Parameter(description = "订单项ID", required = true) @RequestBody Integer orderItemId) {
         Orderitem norderitem = orderItemService.queryOrderItem(orderItemId);
        return Result.success(norderitem);
    }
}
