package org.hyjava.hyall.module.artcategory.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hyjava.hyall.common.core.result.Result;

import org.hyjava.hyall.module.artcategory.pojo.Artcategory;
import org.hyjava.hyall.module.artcategory.pojo.dto.ArtcategoryDTO;
import org.hyjava.hyall.module.artcategory.service.IArtcategoryService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "艺术类别管理", description = "艺术类别的增删改查接口")
@RestController
@RequestMapping("/artcate")
public class ArtcategoryController {
    private final IArtcategoryService artCateService;

    public ArtcategoryController(IArtcategoryService artCateService) {
        this.artCateService = artCateService;
    }

    @Operation(summary = "添加艺术类别", description = "创建新的艺术类别")
    @PostMapping
    public Result<Artcategory> addCate(
            @Parameter(description = "艺术类别信息", required = true) @RequestBody @Validated ArtcategoryDTO artcategory) {
        Artcategory nartcategory = artCateService.addCate(artcategory);
        return Result.success(nartcategory);
    }

    @Operation(summary = "更新艺术类别", description = "修改艺术类别信息")
    @PutMapping
    public Result<Artcategory> updateCate(
            @Parameter(description = "艺术类别信息", required = true) @RequestBody @Validated ArtcategoryDTO artcategory) {
        Artcategory nartcategory = artCateService.updateCate(artcategory);
        return Result.success(nartcategory);
    }

    @Operation(summary = "删除艺术类别", description = "根据类别ID删除艺术类别")
    @DeleteMapping
    public Result<Artcategory> deleteCate(
            @Parameter(description = "艺术类别ID", required = true) @RequestBody Integer id) {
        artCateService.deleteCate(id);
        return Result.success(null);
    }

    @Operation(summary = "查询艺术类别", description = "根据类别ID查询艺术类别详情")
    @GetMapping
    public Result<Artcategory> getCate(
            @Parameter(description = "艺术类别ID", required = true) @RequestBody Integer cateId) {
        Artcategory nartCategory = artCateService.queryCate(cateId);
        return Result.success(nartCategory);
    }
}
