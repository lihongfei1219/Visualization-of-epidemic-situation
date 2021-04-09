package com.backend.service;

import com.backend.mapper.HistoryMapper;
import com.backend.pojo.History;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: 李飞飞
 * @Description:
 * @Date: Created in 19:31 2021/4/4
 */
@Service
public class HistoryService {

    @Autowired
    HistoryMapper historyMapper;
    public HashMap<Object, Object> get_l2_data(){
        HashMap<Object, Object> hashMap = new HashMap<>();
        List<History> data_l2 = historyMapper.get_data_l2();
        List<String> ds = new ArrayList<>();
        List<Integer> confirm_add = new ArrayList<>();
        List<Integer> suspect_add = new ArrayList<>();
        for (History history :data_l2) {
            ds.add(history.getDs());
            confirm_add.add(history.getConfirm_add());
            suspect_add.add(history.getSuspect_add());
        }
        hashMap.put("ds",ds);
        hashMap.put("confirm_add",confirm_add);
        hashMap.put("suspect_add",suspect_add);
        return hashMap;
    }
    public HashMap<Object, Object> get_l1_data(){
        HashMap<Object, Object> hashMap = new HashMap<>();
        List<History> data_l1 = historyMapper.get_data_l1();
        List<String> ds = new ArrayList<>();
        List<Integer> confirm = new ArrayList<>();
        List<Integer> suspect = new ArrayList<>();
        List<Integer> heal = new ArrayList<>();
        List<Integer> dead = new ArrayList<>();
        for (History history :data_l1) {
            ds.add(history.getDs());
            confirm.add(history.getConfirm());
            suspect.add(history.getSuspect());
            heal.add(history.getHeal());
            dead.add(history.getDead());
        }
        hashMap.put("ds",ds);
        hashMap.put("confirm",confirm);
        hashMap.put("suspect",suspect);
        hashMap.put("heal",heal);
        hashMap.put("dead",dead);
        return hashMap;
    }

}
