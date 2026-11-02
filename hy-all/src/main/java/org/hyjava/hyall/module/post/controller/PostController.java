package org.hyjava.hyall.module.post.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hyjava.hyall.common.core.result.Result;

import org.hyjava.hyall.module.post.pojo.Post;
import org.hyjava.hyall.module.post.pojo.dto.PostDTO;
import org.hyjava.hyall.module.post.service.IPostService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "帖子管理", description = "社区帖子的增删改查接口")
@RestController
@RequestMapping("/post")
public class PostController {
    private final IPostService postService;

    public PostController(IPostService postService) {
        this.postService = postService;
    }

    @Operation(summary = "发布帖子", description = "创建新的社区帖子")
    @PostMapping
    public Result<Post> addPost(
            @Parameter(description = "帖子信息", required = true) @RequestBody @Validated PostDTO post)
    {
        Post npost = postService.addPost(post);
        return Result.success(npost);
    }

    @Operation(summary = "删除帖子", description = "根据帖子ID删除帖子")
    @DeleteMapping
    public void deletePost(
            @Parameter(description = "帖子ID", required = true) @RequestBody Integer postId){
        postService.deletePost(postId);
    }

    @Operation(summary = "更新帖子", description = "修改帖子的内容信息")
    @PutMapping
    public Result<Post> updatePost(
            @Parameter(description = "帖子信息", required = true) @RequestBody @Validated PostDTO post){
        Post npost = postService.updatePost(post);
        return Result.success(npost);
    }

    @Operation(summary = "查询帖子", description = "根据帖子ID查询帖子详细信息")
    @GetMapping
    public Result<Post> queryPost(
            @Parameter(description = "帖子ID", required = true) @RequestParam Integer postId){
        Post npost = postService.queryPost(postId);
        return Result.success(npost);
    }
}
