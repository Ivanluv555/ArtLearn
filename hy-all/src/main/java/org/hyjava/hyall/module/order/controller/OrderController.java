package org.hyjava.hyall.module.order.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hyjava.hyall.common.core.result.Result;

import org.hyjava.hyall.module.order.pojo.Order;
import org.hyjava.hyall.module.order.pojo.dto.OrderDTO;
import org.hyjava.hyall.module.order.service.IOrderService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "订单管理", description = "订单信息的增删改查接口")
@RestController
@RequestMapping("/order")
public class OrderController {
    private final IOrderService orderService;

    public OrderController(IOrderService orderService) {
        this.orderService = orderService;
    }

    @Operation(summary = "创建订单", description = "添加新的订单")
    @PostMapping
    public Result<Order> addOrder(
            @Parameter(description = "订单信息", required = true) @RequestBody @Validated OrderDTO order) {
        Order norder= orderService.addOrder(order);
        return Result.success(norder);
    }

    @Operation(summary = "删除订单", description = "根据订单ID删除订单")
    @DeleteMapping
    public void deleteOrder(
            @Parameter(description = "订单ID", required = true) @RequestBody Integer order_id) {
        orderService.deleteOrder(order_id);
    }

    @Operation(summary = "更新订单", description = "修改订单信息")
    @PutMapping
    public Result<Order> updateOrder(
            @Parameter(description = "订单信息", required = true) @RequestBody @Validated OrderDTO order) {
        Order norder = orderService.updateOrder(order);
        return Result.success(norder);
    }

    @Operation(summary = "查询订单", description = "根据订单ID查询订单详情")
    @GetMapping
    public Result<Order> queryOrder(
            @Parameter(description = "订单ID", required = true) @RequestBody Integer orderId) {
        Order norder = orderService.queryOrder(orderId);
        return Result.success(norder);
    }

    @Operation(summary = "批量查询订单", description = "根据用户ID列表批量查询订单")
    @PostMapping("/batch")
    public Result<List<Order>> queryAllOrderBatch(
            @Parameter(description = "用户ID列表", required = true) @RequestBody List<Integer> userIdlist) {
        List<Order> list = orderService.queryAllOrderBatch(userIdlist);
        return Result.success(list);
    }
}
