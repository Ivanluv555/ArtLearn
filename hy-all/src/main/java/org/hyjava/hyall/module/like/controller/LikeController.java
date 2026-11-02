package org.hyjava.hyall.module.like.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hyjava.hyall.common.core.result.Result;

import org.hyjava.hyall.module.like.pojo.Like;
import org.hyjava.hyall.module.like.pojo.dto.LikeDTO;
import org.hyjava.hyall.module.like.service.LikeService;
import org.springframework.web.bind.annotation.*;

@Tag(name = "点赞管理", description = "点赞功能的增删改查接口")
@RestController
@RequestMapping("/like")
public class LikeController {
    private final LikeService likeservice;

    public LikeController(LikeService likeservice) {
        this.likeservice = likeservice;
    }

    @Operation(summary = "添加点赞", description = "为内容添加点赞")
    @PostMapping
    public Result<Like> addLike(
            @Parameter(description = "点赞信息", required = true) @RequestBody LikeDTO like) {
        Like nLike = likeservice.addLike(like);
        return Result.success(nLike);
    }

    @Operation(summary = "取消点赞", description = "根据点赞ID取消点赞")
    @DeleteMapping
    public Result<Like> deleteLike(
            @Parameter(description = "点赞ID", required = true) @RequestBody Integer likeId) {
        likeservice.deleteLike(likeId);
        return Result.success(null);
    }

    @Operation(summary = "查询点赞", description = "根据点赞ID查询点赞信息")
    @GetMapping
    public Result<Like> getLike(
            @Parameter(description = "点赞ID", required = true) @RequestBody Integer likeId) {
        Like nlike = likeservice.queryLike(likeId);
        return Result.success(nlike);
    }

    @Operation(summary = "更新点赞", description = "修改点赞信息")
    @PutMapping
    public Result<Like> updateLike(
            @Parameter(description = "点赞信息", required = true) @RequestBody  LikeDTO like) {
        Like nLike = likeservice.updateLike(like);
        return Result.success(nLike);
    }
}
