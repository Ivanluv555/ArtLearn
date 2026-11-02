package org.hyjava.hyall.module.instructor.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hyjava.hyall.common.core.result.Result;

import org.hyjava.hyall.module.instructor.pojo.Instructor;
import org.hyjava.hyall.module.instructor.pojo.dto.InstructorDTO;
import org.hyjava.hyall.module.instructor.service.InstructorService;
import org.springframework.web.bind.annotation.*;

@Tag(name = "讲师管理", description = "讲师信息的增删改查接口")
@RestController
@RequestMapping("/instructor")
public class InstructorController {
    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @Operation(summary = "添加讲师", description = "创建新的讲师信息")
    @PostMapping
    public Result<Instructor> addInstructor(
            @Parameter(description = "讲师信息", required = true) @RequestBody InstructorDTO instructor) {
        Instructor ninstructor = instructorService.addInstructor(instructor);
        return Result.success(ninstructor);
    }

    @Operation(summary = "删除讲师", description = "根据讲师ID删除讲师")
    @DeleteMapping
    public Result<Instructor> deleteInstructor(
            @Parameter(description = "讲师ID", required = true) @RequestBody Integer instructorId) {
        instructorService.deleteInstructor(instructorId);
        return Result.success(null);
    }

    @Operation(summary = "更新讲师", description = "修改讲师信息")
    @PutMapping
    public Result<Instructor> updateInstructor(
            @Parameter(description = "讲师信息", required = true) @RequestBody InstructorDTO instructor) {
        Instructor ninstrutor = instructorService.updateInstructor(instructor);
        return Result.success(ninstrutor);
    }

    @Operation(summary = "查询讲师", description = "根据讲师ID查询讲师详情")
    @GetMapping
    public Result<Instructor> queryInstructor(
            @Parameter(description = "讲师ID", required = true) @RequestBody  Integer instructorId) {
        return Result.success(instructorService.queryInstructor(instructorId));
    }
}
