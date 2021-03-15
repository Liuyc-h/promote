package com.bj58.finance.platform.promote.manager;


import com.bj58.finance.platform.promote.db.pojo.TUser;
import com.bj58.finance.platform.promote.db.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *  测试类
 * **/
@Service
public class TestManager {

    @Autowired
    private UserService userService;


    /**
     *  事务作用在  private/protected方法中不起作用
     * **/
    @Transactional(propagation = Propagation.REQUIRED)
    public void insert(){
        TUser user = new TUser();
        user.setPassWord("1234561");
        user.setUserName("孔明");
        user.setRealName("诸葛亮");
        userService.insert(user);
        throw new RuntimeException("异常返回");
    }


    /***
     *  创建user对象
     * **/
    private  TUser buildUser(String passWord,String userName,String realName){
        TUser user = new TUser();
        user.setRealName(realName);
        user.setUserName(userName);
        user.setPassWord(passWord);
        return user;
    }

    @Transactional(propagation =Propagation.REQUIRED)
    public void methodA(){
        TUser user = buildUser("123456","玄德","刘备");
        userService.insert(user);
    }
    @Transactional(propagation =Propagation.REQUIRED )
    public void methodB(){
        TUser user = buildUser("123456","云长","关羽");
        userService.insert(user);
    }

    @Transactional(propagation =Propagation.REQUIRED)
    public void methodC(){
        TUser user = buildUser("123456","益德","张飞");
        userService.insert(user);
    }
    @Transactional(propagation =Propagation.REQUIRED )
    public void methodD(){
        TUser user = buildUser("123456","子龙","赵云");
        userService.insert(user);
        throw new RuntimeException();
    }





}
