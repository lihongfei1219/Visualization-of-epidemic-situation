package com.backend.service;

import com.backend.Utils.SendmailUtil;
import com.backend.Utils.SerializeUtil;
import com.backend.mapper.MessageMapper;
import com.backend.pojo.Message;
import com.backend.pojo.MessageRemind;
import com.backend.pojo.Number;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import javax.mail.MessagingException;


/**
 * @Author: 李飞飞
 * @Description:
 * @Date: Created in 10:05 2021/4/7
 */
@Service
public class MessageService {

    @Autowired
    MessageMapper messageMapper;

    @Autowired
    Jedis jedis;

    @Autowired
    SendmailUtil sendmailUtil;

    public void insertMessage(Message message){
        messageMapper.insertMessage(message);
        //去存redis加消息队列完成发短信业务
        Number number = messageMapper.selectNumber(message);
        MessageRemind messageRemind = new MessageRemind();
        messageRemind.setName(message.getName());
        messageRemind.setPhone(message.getPhone());
        messageRemind.setPrivince(message.getPrivince());
        messageRemind.setNumber(number.getConfirm());
        System.out.println(messageRemind);
        jedis.auth("123456");
        jedis.set(("messageRemind:"+messageRemind.getName()).getBytes(), SerializeUtil.serialize(messageRemind));
        try {
            sendmailUtil.sendMail(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }finally {
            System.out.println("success!");
        }
        Runnable runnable = new Runnable() {
            public volatile Boolean flag=true;
            public void run() {
                while (flag) {
                    try {
                        Thread.currentThread().sleep(1000 * 60);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Number newNum = messageMapper.selectNumber(message);
                    byte[] oldByte = jedis.get(("messageRemind:" + message.getName()).getBytes());
                    MessageRemind oldNum = (MessageRemind) SerializeUtil.unserialize(oldByte);
                    if (oldNum.getNumber() < newNum.getConfirm()) {
                        try {
                            System.out.println("检测到疫情变化！");
                            sendmailUtil.sendMailRemind(message);
                            flag = false;

                        } catch (MessagingException e) {
                            e.printStackTrace();
                        }
                    }
                }

                //
            }
        };
        new Thread(runnable).start();
//        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
///*
//         * 参数一:command：执行线程
//         * 参数二:initialDelay：初始化延时
//         * 参数三:period：两次开始执行最小间隔时间
//         * 参数四:unit：计时单位
//         */
//        service.scheduleAtFixedRate(runnable, 0, 60, TimeUnit.SECONDS);

    }
}
