package org.hyjava.hyall.module.course.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hyjava.hyall.common.core.result.Result;

import org.hyjava.hyall.module.course.pojo.Course;
import org.hyjava.hyall.module.course.pojo.dto.CourseDTO;
import org.hyjava.hyall.module.course.service.ICourseService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "课程管理", description = "课程信息的增删改查接口")
@RestController
@RequestMapping("/course")
public class CourseController {
    private final ICourseService courseService;

    public CourseController(ICourseService courseService) {
        this.courseService = courseService;
    }

    @Operation(summary = "添加课程", description = "创建新的课程")
    @PostMapping
    public Result<Course> addCourse(
            @Parameter(description = "课程信息", required = true) @RequestBody CourseDTO course){
        Course ncourse = courseService.addCourse(course);
        return Result.success(ncourse);
    }

    @Operation(summary = "删除课程", description = "根据课程ID删除课程")
    @DeleteMapping
    public void deleteCourse(
            @Parameter(description = "课程ID", required = true) @RequestBody Integer courseId){
        courseService.deleteCourse(courseId);
    }

    @Operation(summary = "更新课程信息", description = "修改课程的详细信息")
    @PutMapping
    public Result<Course> updateCourse(
            @Parameter(description = "课程信息", required = true) @RequestBody @Validated CourseDTO course){
        Course ncourse = courseService.updateCourse(course);
        return Result.success(ncourse);
    }

    @Operation(summary = "查询单个课程", description = "根据课程ID查询课程详细信息")
    @GetMapping
    public Result<Course> queryCourse(
            @Parameter(description = "课程ID", required = true) @RequestBody Integer courseId){
        Course ncourse = courseService.queryCourse(courseId);
        return Result.success(ncourse);
    }

    @Operation(summary = "批量查询课程", description = "根据课程ID列表批量查询课程信息")
    @PostMapping("/batch")
    public Result<List<Course>> queryAllCourse(
            @Parameter(description = "课程ID列表", required = true) @RequestBody List<Integer> courseIdList){
        List<Course> list = courseService.queryAllCourses(courseIdList);
        return Result.success(list);
    }
}
