package com.zhourup.zcourse.course.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zhourup
 * @date 2022/3/29 16:03
 */
@Data
public class CourseQueryDTO {

    @ApiModelProperty("课程ID")
    private Long id;

    @ApiModelProperty("课程标题")
    private String title;

    @ApiModelProperty("课程分类")
    private String category;

    @ApiModelProperty("是否删除")
    private Integer isDelete;

}
