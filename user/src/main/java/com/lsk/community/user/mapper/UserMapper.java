package com.lsk.community.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lsk.community.user.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
