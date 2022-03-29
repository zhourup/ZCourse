package com.zhourup.zcourse.course.service.impl;

import com.zhourup.zcourse.common.api.ResponseDTO;
import com.zhourup.zcourse.common.domain.PageResultDTO;
import com.zhourup.zcourse.common.util.CourseBeanUtil;
import com.zhourup.zcourse.course.dao.CourseDao;
import com.zhourup.zcourse.course.domain.dto.CourseAddDTO;
import com.zhourup.zcourse.course.domain.dto.CourseQueryDTO;
import com.zhourup.zcourse.course.domain.entity.CourseEntity;
import com.zhourup.zcourse.course.domain.vo.CourseVo;
import com.zhourup.zcourse.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhourup
 * @date 2022/3/29 13:53
 */
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

    @Override
    public ResponseDTO<PageResultDTO<CourseVo>> queryByPage(CourseQueryDTO queryDTO) {
        return null;
    }

    /**
     * 添加课程
     *
     * @param addTo 课程dto
     * @return
     */
    @Override
    public ResponseDTO<String> add(CourseAddDTO addTo) {
        CourseEntity courseEntity = CourseBeanUtil.copy(addTo, CourseEntity.class);
        courseEntity.setIsDelete(0);
        courseDao.insert(courseEntity);
        return ResponseDTO.succ();
    }
}
