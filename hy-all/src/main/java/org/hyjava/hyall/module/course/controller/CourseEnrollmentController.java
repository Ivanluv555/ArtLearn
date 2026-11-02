package org.hyjava.hyall.module.course.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hyjava.hyall.common.core.result.Result;
import org.hyjava.hyall.module.course.pojo.UserCourseChapterCompleted;
import org.hyjava.hyall.module.course.pojo.UserCourseEnrollment;
import org.hyjava.hyall.module.course.pojo.dto.ChapterCompleteDTO;
import org.hyjava.hyall.module.course.pojo.dto.EnrollRequestDTO;
import org.hyjava.hyall.module.course.service.ICourseEnrollmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "课程报名管理", description = "用户课程报名、学习进度管理接口")
@RestController
@RequestMapping("/course/enroll") // 定义统一路由前缀
public class CourseEnrollmentController {

    private final ICourseEnrollmentService enrollmentService;

    public CourseEnrollmentController(ICourseEnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    // 1. 报名课程
    // POST /course/enroll
    @Operation(summary = "报名课程", description = "用户报名参加课程")
    @PostMapping
    public Result<UserCourseEnrollment> enroll(
            @Parameter(description = "报名信息", required = true) @RequestBody EnrollRequestDTO enrollDTO) {
        return Result.success(enrollmentService.enrollCourse(enrollDTO));
    }

    // 2. 章节打卡 (完成章节)
    // POST /course/enroll/complete
    @Operation(summary = "完成章节", description = "标记课程章节为已完成")
    @PostMapping("/complete")
    public Result<UserCourseChapterCompleted> completeChapter(
            @Parameter(description = "章节完成信息", required = true) @RequestBody ChapterCompleteDTO completeDTO) {
        return Result.success(enrollmentService.completeChapter(completeDTO));
    }

    // 3. 查询我的课程
    // GET /course/enroll/my
    @Operation(summary = "查询我的课程", description = "查询当前用户已报名的所有课程")
    @GetMapping("/my")
    public Result<List<UserCourseEnrollment>> getMyCourses() {
        return Result.success(enrollmentService.queryMyCourses());
    }
}