package com.backend.controller;

import com.backend.pojo.Message;
import com.backend.service.DetailsService;
import com.backend.service.HistoryService;
import com.backend.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
/**
 * @Author: 李飞飞
 * @Description:
 * @Date: Created in 16:07 2021/3/31
 */


@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    DetailsService detailsService;

    @Autowired
    HistoryService historyService;

    /**
     * message插入操作
     */
    @Autowired
    MessageService messageService;

    @RequestMapping("/")
    public String index() throws Exception {
        return "index";
    }

    @ResponseBody
    @RequestMapping("/c1")
    public HashMap<Object, Object> get_c1_data(){
        return detailsService.get_c1_data();
    }

    @ResponseBody
    @RequestMapping("/c2")
    public HashMap<Object, Object> get_c2_data(){
        List<HashMap<Object, Object>> c2_data = detailsService.get_c2_data();
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put("data",c2_data);
        return hashMap;
    }

    @ResponseBody
    @RequestMapping("/l1")
    public HashMap<Object, Object> get_l1_data(){
        return historyService.get_l1_data();
    }


    @ResponseBody
    @RequestMapping("/l2")
    public HashMap<Object, Object> get_l2_data(){
        return historyService.get_l2_data();
    }

    @ResponseBody
    @RequestMapping(value = "/form",method = RequestMethod.GET)
    public String get_form(HttpServletRequest request){
        Message message = new Message();
        message.setName(request.getParameter("name"));
        message.setPhone(request.getParameter("phone"));
        message.setPrivince(request.getParameter("privince"));
        messageService.insertMessage(message);
        return "success";
    }

}
