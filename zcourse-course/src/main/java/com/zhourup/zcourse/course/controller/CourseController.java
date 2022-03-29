package com.zhourup.zcourse.course.controller;

import com.zhourup.zcourse.common.api.ResponseDTO;
import com.zhourup.zcourse.common.domain.PageResultDTO;
import com.zhourup.zcourse.course.domain.dto.CourseAddDTO;
import com.zhourup.zcourse.course.domain.dto.CourseQueryDTO;
import com.zhourup.zcourse.course.domain.dto.CourseUpdateDTO;
import com.zhourup.zcourse.course.domain.vo.CourseVo;
import com.zhourup.zcourse.course.service.CourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhourup
 * @date 2022/3/27 17:02
 */
@RestController
@RequestMapping("course")
@Api("课程管理")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @ApiOperation(value = "分页查询课程", notes = "@author zhourup")
    @PostMapping("/page/query")
    public ResponseDTO<PageResultDTO<CourseVo>> queryByPage(@RequestBody CourseQueryDTO queryDTO) {
        return courseService.queryByPage(queryDTO);
    }

    @ApiOperation(value = "添加课程", notes = "@author zhourup")
    @PostMapping("/add")
    public ResponseDTO<String> add(@RequestBody @Validated CourseAddDTO addTo) {
        return courseService.add(addTo);
    }

    @ApiOperation(value = "更新课程", notes = "@author zhourup")
    @PostMapping("/update")
    public ResponseDTO<String> update(@RequestBody @Validated CourseUpdateDTO updateDTO) {
        return null;
    }

//    @ApiOperation(value = "批量删除课程", notes = "@author zhourup")
//    @PostMapping("/deleteByIds")
//    public ResponseDTO<String> delete(@RequestBody @Validated ValidateList<Long> idList) {
//    }
}
