package com.zhourup.zcourse.course.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhourup.zcourse.course.domain.entity.CourseEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author zhourup
 * @date 2022/3/29 13:58
 */
@Mapper
@Component
public interface CourseDao extends BaseMapper<CourseEntity> {
}
