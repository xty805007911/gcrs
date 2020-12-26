package com.ctsi.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ctsi.entity.TbUser;
import com.ctsi.mapper.TbUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbUserService {

    @Autowired
    private TbUserMapper tbUserMapper;

    //根据手机号和密码查询用户
    public TbUser getUserByMobileAndPassword(String mobile,String password) {
        QueryWrapper<TbUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("mobile",mobile);
        queryWrapper.eq("password",password);

        return tbUserMapper.selectOne(queryWrapper);
    }

    //根据主键查询用户
    public TbUser getUserById(Integer userId) {
        return tbUserMapper.selectById(userId);
    }


}