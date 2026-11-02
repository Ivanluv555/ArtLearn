package org.hyjava.hyall.module.collection.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hyjava.hyall.common.core.result.Result;
import org.hyjava.hyall.module.collection.pojo.Collection;
import org.hyjava.hyall.module.collection.pojo.dto.CollectionDTO;
import org.hyjava.hyall.module.collection.service.ICollectionService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "收藏管理", description = "收藏功能的增删改查接口")
@RestController
@RequestMapping("/collection")
public class CollectionController {

    private final ICollectionService collectionService;

    public CollectionController(ICollectionService collectionService) {
        this.collectionService = collectionService;
    }

    // 1. ADD (Create) -> POST /collection
    @Operation(summary = "添加收藏", description = "收藏内容到用户收藏夹")
    @PostMapping
    public Result<Collection> addCollection(
            @Parameter(description = "收藏信息", required = true) @RequestBody @Validated CollectionDTO collection){
        Collection ncollection = collectionService.addCollection(collection);
        return Result.success(ncollection);
    }

    @Operation(summary = "取消收藏", description = "根据收藏ID取消收藏")
    @DeleteMapping
    public void deleteCollection(
            @Parameter(description = "收藏ID", required = true) @RequestBody Integer collectionId){
        collectionService.deleteCollection(collectionId);
    }

    @Operation(summary = "更新收藏", description = "修改收藏信息")
    @PutMapping
    public Result<Collection> updateCollection(
            @Parameter(description = "收藏信息", required = true) @RequestBody @Validated CollectionDTO collection){
        Collection ncollection = collectionService.updateCollection(collection);
        return Result.success(ncollection);
    }

    @Operation(summary = "查询收藏", description = "根据收藏ID查询收藏详情")
    @GetMapping
    public Result<Collection> queryCollection(
            @Parameter(description = "收藏ID", required = true) @RequestParam Integer collectionId){
        Collection ncollection = collectionService.queryCollection(collectionId);
        return Result.success(ncollection);
    }

    // 2. BATCH QUERY -> POST /collection/batch
    // FIX: Added "/batch" to distinguish this from the addCollection method
    @Operation(summary = "批量查询收藏", description = "根据收藏ID列表批量查询收藏信息")
    @PostMapping("/batch")
    public Result<List<Collection>> queryAllCollectionBatch(
            @Parameter(description = "收藏ID列表", required = true) @RequestBody List<Integer> collectionId){
        List<Collection> list = collectionService.queryAllCollectionBatch(collectionId);
        return Result.success(list);
    }
}