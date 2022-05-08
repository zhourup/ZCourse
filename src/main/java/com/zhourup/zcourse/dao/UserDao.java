package com.zhourup.zcourse.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhourup.zcourse.domain.dto.UserDTO;
import com.zhourup.zcourse.domain.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * 用户dao接口
 *
 * @author zhourup
 * @date 2022/5/3 21:20
 */
@Mapper
@Component
public interface UserDao extends BaseMapper<UserEntity> {


    /**
     * 登录
     *
     * @param loginName
     * @param loginPwd
     * @return
     */
    UserDTO login(@Param("loginName") String loginName, @Param("loginPwd") String loginPwd);

}
