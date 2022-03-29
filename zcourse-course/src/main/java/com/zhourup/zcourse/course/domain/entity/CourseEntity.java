package com.zhourup.zcourse.course.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zhourup.zcourse.common.domain.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zhourup
 * @date 2022/3/29 15:13
 */
@Data
@TableName("t_course")
public class CourseEntity extends BaseEntity {

    @ApiModelProperty("课程标题")
    private String title;

    @ApiModelProperty("课程分类")
    private String category;

    @ApiModelProperty("课程详细简介")
    private String details;

    @ApiModelProperty("课程图片路径")
    private String pic;

    @ApiModelProperty("是否删除")
    private Integer isDelete;
}
