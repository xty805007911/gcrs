package com.ctsi.controller;

import com.ctsi.entity.TbChat;
import com.ctsi.entity.TbUser;
import com.ctsi.mapper.TbUserMapper;
import com.ctsi.service.TbChatService;
import com.ctsi.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName : ChatController
 * @Description :
 * @Author : Xiaotianyu  //作者
 * @Date: 2021-01-08 15:03
 */
@RestController
public class ChatRestController {
    @Autowired
    private TbChatService chatService;
    @Autowired
    private UserRestController userRestController;

    // 分页查询
    @GetMapping("/api/chat/pageList")
    public PageResult<TbChat> chatPageResult(Integer toUserId, HttpServletRequest request) {
        TbUser currentUser = userRestController.getCurrentUser(request);
        return chatService.pageResult(currentUser,toUserId);
    }

    //发送消息
    @GetMapping("/api/chat/sendMessage")
    public void sendMessage(String message,Integer toUserId,Integer fromUserId) {
        chatService.insertChat(message,toUserId,fromUserId);
    }
}
