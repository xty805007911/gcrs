package com.ctsi.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ctsi.entity.TbChat;
import com.ctsi.entity.TbUser;
import com.ctsi.mapper.TbChatMapper;
import com.ctsi.mapper.TbUserMapper;
import com.ctsi.util.PageResult;
import com.ctsi.util.RelativeDateFormat;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName : TbChatService
 * @Description :
 * @Author : Xiaotianyu  //作者
 * @Date: 2021-01-08 15:43
 */
@Service
public class TbChatService {

    @Autowired
    private TbChatMapper chatMapper;
    @Autowired
    private TbUserMapper userMapper;

    //分页查询
    public PageResult<TbChat> pageResult(TbUser currentUser,Integer toUserId) {

        // 给谁发送
        TbUser toUser = userMapper.selectById(toUserId);

        PageHelper.startPage(1,100);//查询100条

        QueryWrapper<TbChat> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("from_user_id",currentUser.getId());
        queryWrapper.eq("to_user_id",toUserId);
        queryWrapper.orderByAsc("id");
        List<TbChat> chatList = chatMapper.selectList(queryWrapper);
        for(TbChat chat : chatList) {
            chat.setTime(RelativeDateFormat.format(chat.getCreate_time()));
            chat.setToUser(toUser);
            chat.setFromUser(currentUser);
            chat.setFromUserId(currentUser.getId());
        }
        PageInfo<TbChat> pageInfo = new PageInfo<>(chatList);
        PageResult<TbChat> pageResult = new PageResult<>(pageInfo);
        return pageResult;
    }
}
