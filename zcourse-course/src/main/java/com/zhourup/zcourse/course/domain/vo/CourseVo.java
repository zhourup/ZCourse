package com.zhourup.zcourse.course.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author zhourup
 * @date 2022/3/29 16:02
 */
@Data
public class CourseVo {

    @ApiModelProperty("课程ID")
    private Long id;

    @ApiModelProperty("课程标题")
    private String title;

    @ApiModelProperty("课程分类")
    private String category;

    @ApiModelProperty("课程详细简介")
    private String details;

    @ApiModelProperty("课程图片路径")
    private String pic;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    @ApiModelProperty("是否删除")
    private Integer isDelete;
}
