package com.bebetter.service;

import com.bebetter.po.UserPo;

import java.util.List;

public interface UserService {
    int add();
    List<UserPo> getAll();
}
