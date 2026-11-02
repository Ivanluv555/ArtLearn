package org.hyjava.hyall.module.user.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hyjava.hyall.common.core.result.Result;

import org.hyjava.hyall.module.user.pojo.User;
import org.hyjava.hyall.module.user.pojo.dto.UserDTO;
import org.hyjava.hyall.module.user.service.IUserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "用户管理", description = "用户信息的增删改查及登录接口")
@RestController
@RequestMapping("/user")
@Validated
public class UserController {
    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "添加用户", description = "创建新的用户账号")
    @PostMapping
    public Result<User> addUser(
            @Parameter(description = "用户信息", required = true) @RequestBody @Validated UserDTO user) {
        User nuser = userService.addUser(user);
        return Result.success(nuser);
    }

    @Operation(summary = "删除用户", description = "根据用户ID删除用户")
    @DeleteMapping
    public void deleteUser(
            @Parameter(description = "用户ID", required = true) @RequestParam Integer userId) {
        userService.deleteUser(userId);
    }

    @Operation(summary = "更新用户信息", description = "修改用户的基本信息")
    @PutMapping
    public Result<User> updateUser(
            @Parameter(description = "用户信息", required = true) @RequestBody @Validated UserDTO user) {
        User nuser = userService.updateUser(user);
        return Result.success(nuser);
    }

    @Operation(summary = "查询单个用户", description = "根据用户ID查询用户详细信息")
    @GetMapping
    public Result<User> queryUser(
            @Parameter(description = "用户ID", required = true) @RequestParam Integer userId) {
        User nuser = userService.queryUser(userId);
        return Result.success(nuser);
    }

    // 修正点：加上了 @RequestBody
    @Operation(summary = "批量查询用户", description = "根据用户ID列表批量查询用户信息")
    @PostMapping("/batch")
    public Result<List<User>> queryAllUser(
            @Parameter(description = "用户ID列表", required = true) @RequestBody List<Integer> userIds) {
        List<User> nLUser = userService.queryAllUser(userIds);
        return Result.success(nLUser);
    }

    @Operation(summary = "用户登录", description = "用户登录并返回JWT token")
    @PostMapping("/login")
    public Result<String> login(
            @Parameter(description = "登录信息（用户名和密码）", required = true) @RequestBody UserDTO userDTO) {
        String token = userService.login(userDTO.getUserName(), userDTO.getPassword());
        return Result.success(token);
    }
}