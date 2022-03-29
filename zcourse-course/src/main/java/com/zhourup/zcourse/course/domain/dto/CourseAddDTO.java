package com.zhourup.zcourse.course.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 新建课程
 *
 * @author zhourup
 * @date 2022/3/29 13:43
 */
@Data
public class CourseAddDTO {
    @ApiModelProperty("课程标题")
    private String title;

    @ApiModelProperty("课程分类")
    private String category;

    @ApiModelProperty("课程简介")
    private String details;

    @ApiModelProperty("图片链接")
    private String pic;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
}
