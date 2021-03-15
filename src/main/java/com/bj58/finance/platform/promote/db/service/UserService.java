package com.bj58.finance.platform.promote.db.service;


import com.bj58.finance.platform.promote.db.mapper.TUserMapper;
import com.bj58.finance.platform.promote.db.pojo.TUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private TUserMapper userMapper;

    public TUser getUser(int id) {
        return userMapper.findById(id);
    }

    public int insert(TUser user){
        return userMapper.insert(user);

    }

}
