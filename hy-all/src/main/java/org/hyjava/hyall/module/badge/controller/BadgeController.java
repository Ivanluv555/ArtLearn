package org.hyjava.hyall.module.badge.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hyjava.hyall.common.core.result.Result;

import org.hyjava.hyall.module.badge.pojo.Badge;
import org.hyjava.hyall.module.badge.pojo.dto.BadgeDTO;
import org.hyjava.hyall.module.badge.service.IBadgeService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "徽章管理", description = "用户徽章的增删改查接口")
@RestController
@RequestMapping("/badge")
public class BadgeController {
    private final IBadgeService badgeService;

    public BadgeController(IBadgeService badgeService) {
        this.badgeService = badgeService;
    }

    @Operation(summary = "添加徽章", description = "创建新的徽章")
    @PostMapping
    public Result<Badge> addBadge(
            @Parameter(description = "徽章信息", required = true) @RequestBody @Validated BadgeDTO badge) {
        Badge nbadge = badgeService.addBadge(badge);
        return Result.success(nbadge);
    }

    @Operation(summary = "删除徽章", description = "根据徽章ID删除徽章")
    @DeleteMapping
    public void deleteBadge(
            @Parameter(description = "徽章ID", required = true) @RequestBody Integer badgeId) {
        badgeService.deleteBadge(badgeId);
    }

    @Operation(summary = "更新徽章", description = "修改徽章信息")
    @PutMapping
    public Result<Badge> updateBadge(
            @Parameter(description = "徽章信息", required = true) @RequestBody @Validated BadgeDTO badge) {
        Badge nbadge = badgeService.updateBadge(badge);
        return Result.success(nbadge);
    }

    @Operation(summary = "查询徽章", description = "根据徽章ID查询徽章详情")
    @GetMapping
    public Result<Badge> queryBadge(
            @Parameter(description = "徽章ID", required = true) @RequestParam Integer badgeId) {
        Badge nbadge = badgeService.queryBadge(badgeId);
        return Result.success(nbadge);
    }
}