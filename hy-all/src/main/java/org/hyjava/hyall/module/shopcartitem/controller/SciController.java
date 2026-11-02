package org.hyjava.hyall.module.shopcartitem.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hyjava.hyall.common.core.result.Result;

import org.hyjava.hyall.module.shopcartitem.pojo.Sci;
import org.hyjava.hyall.module.shopcartitem.pojo.dto.SciDTO;
import org.hyjava.hyall.module.shopcartitem.service.ISciService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name = "购物车管理", description = "购物车商品的增删改查接口")
@RestController
@RequestMapping("/sci")
public class SciController {
    private final ISciService sciService;

    public SciController(ISciService sciService) {
        this.sciService = sciService;
    }

    @Operation(summary = "添加购物车项", description = "向购物车中添加商品")
    @PostMapping
    public Result<Sci> addSci(
            @Parameter(description = "购物车项信息", required = true) @RequestBody @Validated SciDTO sci) {
        Sci nsci = sciService.addSci(sci);
        return Result.success(nsci);
    }

    @Operation(summary = "删除购物车项", description = "根据购物车项ID删除购物车中的商品")
    @DeleteMapping
    public void deleteSci(
            @Parameter(description = "购物车项ID", required = true) @RequestBody Integer cartItemId) {
        sciService.deleteSci(cartItemId);
    }

    @Operation(summary = "更新购物车项", description = "修改购物车中的商品信息")
    @PutMapping
    public Result<Sci> updateSci(
            @Parameter(description = "购物车项信息", required = true) @RequestBody @Validated SciDTO sci) {
        Sci nsci = sciService.updateSci(sci);
        return Result.success(nsci);
    }

    @Operation(summary = "查询购物车项", description = "根据购物车项ID查询购物车商品详情")
    @GetMapping
    public Result<Sci> querySci(
            @Parameter(description = "购物车项ID", required = true) @RequestBody Integer cartItemId) {
        Sci nsci = sciService.querySci(cartItemId);
        return Result.success(nsci);
    }

    @Operation(summary = "批量查询购物车", description = "根据用户ID列表批量查询购物车商品")
    @PostMapping("/batch")
    public Result<List<Sci>> queryAllSciBatch(
            @Parameter(description = "用户ID列表", required = true) @RequestBody List<Integer> userIdList) {
        List<Sci> list = sciService.queryAllSciBatch(userIdList);
        return Result.success(list);
    }
}