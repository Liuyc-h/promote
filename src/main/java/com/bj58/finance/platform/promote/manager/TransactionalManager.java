package com.bj58.finance.platform.promote.manager;


import com.bj58.finance.platform.promote.db.pojo.TUser;
import com.bj58.finance.platform.promote.db.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionalManager {

    @Autowired
    private TestManager testManager;

    @Autowired
    private UserService userService;

    /**
     *  外层无事务得情况
     * **/
//    @Transactional(propagation = Propagation.REQUIRED)
    public void testNoTransactional(){
        //内层抛出异常得方式
//        insert();

        //内层无异常，外层抛出异常，这种情况插入成功
//        testManager.methodA();
//        testManager.methodB();
//        throw new RuntimeException();

    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void testTransactional(){

        //外层有事务，内层也有,外层抛出异常，两个都插入不进去
//        testManager.methodA();
//        testManager.methodB();
//        throw new RuntimeException();
        //外层有事务，内层也有事务，内层有异常,此时都不插入
//        testManager.methodC();
//        testManager.methodD();;

        methodC();
        methodD();
        throw new RuntimeException();


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
//        throw new RuntimeException();
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






//    // ======================  测试 propagation.REQUIRED  start =====================//
//    //============= 当前有事务，则加入，无事务则新建一个 ============//
//    /**
//     *  场景1  外层无事务，外层抛出异常
//     *         此时methodA 和methodB都插入，不受影响
//     * */
//    public void insert_REQUIRED1(){
//        methodA();
//        methodB();
//        throw new RuntimeException();
//    }
//    @Transactional(propagation =Propagation.REQUIRED ,rollbackFor = RuntimeException.class)
//    public void methodA(){
//        TUser user = buildUser("123456","zhaowanyi","zhwy");
//        userService.insert(user);
//    }
//    @Transactional(propagation =Propagation.REQUIRED ,rollbackFor = RuntimeException.class)
//    public void methodB(){
//        TUser user = buildUser("123456","zhuli","zhl");
//        userService.insert(user);
//    }
//
//
//    /**
//     *  场景2  外层有事务，外层抛出异常
//     *         此时methodA 和methodB都不插入
//     * */
//    @Transactional(propagation =Propagation.REQUIRED ,rollbackFor = Exception.class)
//    public void insert_REQUIRED2(){
//        methodA1();
//        methodB1();
//        throw new RuntimeException();
//    }
//    @Transactional(propagation =Propagation.REQUIRED,rollbackFor = Exception.class)
//    public void methodA1(){
//        TUser user = buildUser("123456","zhuxueying","zhxy");
//        userService.insert(user);
//    }
//    @Transactional(propagation =Propagation.REQUIRED,rollbackFor = Exception.class)
//    public void methodB1(){
//        TUser user = buildUser("123456","liyue","ly");
//        userService.insert(user);
//    }


}
