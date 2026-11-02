package org.hyjava.hyall.module.chapter.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hyjava.hyall.common.core.result.Result;

import org.hyjava.hyall.module.chapter.pojo.Chapter;
import org.hyjava.hyall.module.chapter.pojo.dto.ChapterDTO;
import org.hyjava.hyall.module.chapter.service.IChapterService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "章节管理", description = "课程章节的增删改查接口")
@RestController
@RequestMapping("/chapter")
public class ChapterController {
    private final IChapterService chapterService;

    public ChapterController(IChapterService chapterService) {
        this.chapterService = chapterService;
    }

    @Operation(summary = "添加章节", description = "创建新的课程章节")
    @PostMapping
    public Result<Chapter> addChapter(
            @Parameter(description = "章节信息", required = true) @RequestBody @Validated ChapterDTO chapter){
        Chapter nchapter = chapterService.addChapter(chapter);
        return Result.success(nchapter);
    }

    @Operation(summary = "删除章节", description = "根据章节ID删除章节")
    @DeleteMapping
    public void deleteChapter(
            @Parameter(description = "章节ID", required = true) @RequestBody Integer chapterId){
        chapterService.deleteChapter(chapterId);
    }

    @Operation(summary = "更新章节", description = "修改章节信息")
    @PutMapping
    public Result<Chapter> updateChapter(
            @Parameter(description = "章节信息", required = true) @RequestBody @Validated ChapterDTO chapter){
        Chapter nchapter = chapterService.updateChapter(chapter);
        return Result.success(nchapter);
    }

    @Operation(summary = "查询章节", description = "根据章节ID查询章节详情")
    @GetMapping
    public Result<Chapter> queryChapter(
            @Parameter(description = "章节ID", required = true) @RequestBody  Integer chapterId){
        Chapter nchapter = chapterService.queryChapter(chapterId);
        return Result.success(nchapter);
    }
}