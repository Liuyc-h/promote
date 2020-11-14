package com.bj58.finance.platform.promote.db.pojo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class TUser {

    /**
     *  自增id
     * */
    private Integer id;

    /**
     *  用户姓名
     * */
    private String userName;

    /**
     *  用户密码
     * **/
    private String passWord;

    /**
     *  真实姓名
     * */
    private String realName;


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", realName='" + realName + '\'' +
                '}';
    }

}
