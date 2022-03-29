package com.zhourup.zcourse.course.service;

import com.zhourup.zcourse.common.api.ResponseDTO;
import com.zhourup.zcourse.common.domain.PageResultDTO;
import com.zhourup.zcourse.course.domain.dto.CourseAddDTO;
import com.zhourup.zcourse.course.domain.dto.CourseQueryDTO;
import com.zhourup.zcourse.course.domain.vo.CourseVo;

/**
 * @author zhourup
 * @date 2022/3/29 13:53
 */
public interface CourseService {

    /**
     * 分页查询课程信息
     *
     * @param queryDTO
     * @return
     */
    ResponseDTO<PageResultDTO<CourseVo>> queryByPage(CourseQueryDTO queryDTO);

    /**
     * 课程添加
     *
     * @param addTo 课程dto
     * @return 操作结果
     */
    ResponseDTO<String> add(CourseAddDTO addTo);

}
