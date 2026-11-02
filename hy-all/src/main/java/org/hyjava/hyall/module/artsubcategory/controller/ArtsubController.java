package org.hyjava.hyall.module.artsubcategory.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hyjava.hyall.common.core.result.Result;

import org.hyjava.hyall.module.artsubcategory.pojo.Artsubcategory;
import org.hyjava.hyall.module.artsubcategory.pojo.dto.ArtsubcategoryDTO;
import org.hyjava.hyall.module.artsubcategory.service.ArtsubService;
import org.springframework.web.bind.annotation.*;

@Tag(name = "艺术子类别管理", description = "艺术子类别的增删改查接口")
@RestController
@RequestMapping("/artsub")
public class ArtsubController {
    private final ArtsubService artSubService;

    public ArtsubController(ArtsubService artSubService) {
        this.artSubService = artSubService;
    }

    @Operation(summary = "添加艺术子类别", description = "创建新的艺术子类别")
    @PostMapping
    public Result<Artsubcategory> addArtSub(
            @Parameter(description = "艺术子类别信息", required = true) @RequestBody ArtsubcategoryDTO artSubCategory) {
        Artsubcategory nartSub = artSubService.addArtSub(artSubCategory);
        return Result.success(nartSub);
    }

    @Operation(summary = "删除艺术子类别", description = "根据子类别ID删除艺术子类别")
    @DeleteMapping
    public Result<Artsubcategory> delArtSub(
            @Parameter(description = "艺术子类别ID", required = true) @RequestBody Integer artsubId) {
        artSubService.deleteArtSub(artsubId);
        return Result.success(null);
    }

    @Operation(summary = "查询艺术子类别", description = "根据ID查询艺术子类别详情")
    @GetMapping
    public Result<Artsubcategory> queryArtSub(
            @Parameter(description = "艺术子类别ID", required = true) @RequestBody Integer id) {
        return Result.success(artSubService.queryArtSub(id));
    }

    @Operation(summary = "更新艺术子类别", description = "修改艺术子类别信息")
    @PutMapping
    public Result<Artsubcategory> updateArtSub(
            @Parameter(description = "艺术子类别信息", required = true) @RequestBody ArtsubcategoryDTO artSubCategory) {
        Artsubcategory artSub = artSubService.updateArtSub(artSubCategory);
        return Result.success(artSub);
    }
}
