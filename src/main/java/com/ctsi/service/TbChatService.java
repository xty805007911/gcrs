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

import java.text.SimpleDateFormat;
import java.util.Date;
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
        queryWrapper.or();
        queryWrapper.eq("from_user_id",toUserId);
        queryWrapper.eq("to_user_id",currentUser.getId());
        queryWrapper.orderByDesc("id");//时间倒序
        List<TbChat> chatList = chatMapper.selectList(queryWrapper);
        for(TbChat chat : chatList) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            chat.setTime(sdf.format(chat.getCreateTime()));
            chat.setToUser(toUser);
            chat.setFromUser(currentUser);
            if(currentUser.getId() == chat.getFromUserId()) {
                chat.setTplClass("left");
            }else {
                chat.setTplClass("right");
            }
        }
        PageInfo<TbChat> pageInfo = new PageInfo<>(chatList);
        PageResult<TbChat> pageResult = new PageResult<>(pageInfo);
        return pageResult;
    }

    //添加一条消息
    public void insertChat(String message,Integer toUserId,Integer fromUserId) {
        TbChat chat = new TbChat();
        chat.setFromUserId(fromUserId);
        chat.setToUserId(toUserId);
        chat.setCreateTime(new Date());
        chat.setMessage(message);
        chatMapper.insert(chat);
    }
}
