package com.ctsi.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ctsi.entity.TbAvatar;
import com.ctsi.entity.TbUser;
import com.ctsi.mapper.TbAvatarMapper;
import com.ctsi.mapper.TbUserMapper;
import com.ctsi.util.PageResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class TbUserService {

    @Autowired
    private TbUserMapper tbUserMapper;
    @Autowired
    private TbAvatarMapper tbAvatarMapper;

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

    //保存用户信息
    public void save(TbUser formUser,String selectSender) {
        //是否开启派单员角色
        boolean isSelectSender = (selectSender != null);

        //如果选择了派单员角色，enable = 0
        if(isSelectSender == true) {
            formUser.setEnabled(0);
            formUser.setRoleId(2);
        }else {//普通用户角色
            formUser.setEnabled(1);
            formUser.setRoleId(1);
        }

        //设置通用属性
        formUser.setCreateTime(new Date());

        //选择一个随机的头像
        List<TbAvatar> avatarList = tbAvatarMapper.selectList(new QueryWrapper<>());
        Random random = new Random();
        TbAvatar randomAvatar = avatarList.get(random.nextInt(avatarList.size()));
        formUser.setAvatar(randomAvatar.getUrl());

        //添加
        tbUserMapper.insert(formUser);
    }

    //查询手机号是否存在
    public boolean isMobileExist(String mobile) {
        QueryWrapper<TbUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("mobile",mobile);
        List<TbUser> tbUserList = tbUserMapper.selectList(queryWrapper);
        if(tbUserList == null || tbUserList.size() == 0) {
            return false;
        }
        return true;
    }

    //用户头像分页列表
    public PageResult<TbAvatar> avatarPageList(Integer page,Integer size) {
        if(page == null || page <= 0) {
            page = 1;
        }

        PageHelper.startPage(page,size);

        QueryWrapper<TbAvatar> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("create_time");

        List<TbAvatar> avatarList = tbAvatarMapper.selectList(queryWrapper);

        PageInfo<TbAvatar> pageInfo = new PageInfo<>(avatarList);
        PageResult<TbAvatar> pageResult = new PageResult<>(pageInfo);
        return pageResult;
    }

    //查询所有头像
    public List<TbAvatar> avatarListAll() {
        return tbAvatarMapper.selectList(null);
    }


    //用户头像添加
    public void saveAvatar(TbAvatar avatar) {
        avatar.setEnabled(1);
        avatar.setCreateTime(new Date());
        tbAvatarMapper.insert(avatar);
    }

    //根据角色id查询用户集合
    public PageResult<TbUser> userListByRole(Integer roleId,Integer page,Integer size) {
        if(page == null || page <= 0) {
            page = 1;
        }
        QueryWrapper<TbUser> queryWrapper = new QueryWrapper();
        queryWrapper.eq("role_id",roleId);
        queryWrapper.orderByDesc("id");
        PageHelper.startPage(page,size);
        List<TbUser> userList = tbUserMapper.selectList(queryWrapper);
        PageInfo<TbUser> pageInfo = new PageInfo<>(userList);
        PageResult<TbUser> pageResult = new PageResult<>(pageInfo);
        return pageResult;
    }

    //更新用户
    public void updateUserInfo(TbUser user) {
        tbUserMapper.updateById(user);
    }


}