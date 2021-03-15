package com.bj58.finance.platform.promote.db.mapper;


import com.bj58.finance.platform.promote.db.pojo.TUser;
import org.springframework.stereotype.Repository;

@Repository
public interface TUserMapper {

    TUser findById(int id);

    int insert(TUser user);
}
