package com.ctsi.service;

import com.ctsi.entity.TbRole;
import com.ctsi.mapper.TbRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbRoleService {

    @Autowired
    private TbRoleMapper tbRoleMapper;


	
}