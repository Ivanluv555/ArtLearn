package org.hyjava.hyall.module.comment.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hyjava.hyall.common.core.result.Result;

import org.hyjava.hyall.module.comment.pojo.Comment;
import org.hyjava.hyall.module.comment.pojo.dto.CommentDTO;
import org.hyjava.hyall.module.comment.service.ICommentService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "评论管理", description = "评论信息的增删改查接口")
@RestController
@RequestMapping("/comment")
public class CommentController {
    private final ICommentService commentService;

    public CommentController(ICommentService commentService) {
        this.commentService = commentService;
    }

    @Operation(summary = "添加评论", description = "发布新的评论")
    @PostMapping
    public Result<Comment> addComment(
            @Parameter(description = "评论信息", required = true) @RequestBody @Validated CommentDTO comment) {
        Comment ncomment= commentService.addComment(comment);
        return Result.success(ncomment);
    }

    @Operation(summary = "删除评论", description = "根据评论ID删除评论")
    @DeleteMapping
    public void deleteComment(
            @Parameter(description = "评论ID", required = true) @RequestBody Integer commentId) {
        commentService.deleteComment(commentId);
    }

    @Operation(summary = "更新评论", description = "修改评论内容")
    @PutMapping
    public Result<Comment> updateComment(
            @Parameter(description = "评论信息", required = true) @RequestBody @Validated CommentDTO comment) {
        Comment ncomment= commentService.updateComment(comment);
        return Result.success(ncomment);
    }

    @Operation(summary = "查询评论", description = "根据评论ID查询评论详情")
    @GetMapping
    public Result<Comment>  queryComment(
            @Parameter(description = "评论ID", required = true) @RequestBody  Integer commentId) {
        Comment ncomment= commentService.queryComment(commentId);
        return Result.success(ncomment);
    }
}
