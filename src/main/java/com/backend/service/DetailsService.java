package com.backend.service;

import com.backend.mapper.DetailsMapper;
import com.backend.pojo.C1Datail;
import com.backend.pojo.Datails;
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
public class DetailsService {

    @Autowired
    DetailsMapper detailsMapper;


    public HashMap<Object, Object> get_c1_data(){
        HashMap<Object, Object> hashMap = new HashMap<>();
        /*
        * SQL的问题这个地方写死了先！重建一个POJO已经解决了该问题，这个地方SQL语句查询的结果名和类属性对不上的话会报空指针异常，注意！
        * */
        C1Datail datail = detailsMapper.get_c1_data();
        hashMap.put("confirm",datail.getConfirm());
        hashMap.put("suspect",datail.getSuspect());
        hashMap.put("heal",datail.getHeal());
        hashMap.put("dead",datail.getDead());
        return hashMap;

    }

    public List<HashMap<Object, Object>> get_c2_data(){
        List<HashMap<Object, Object>> list = new ArrayList<>();
        //  返回的数据是一个列表，里面包含的是一个个字典  每个字典由两对组成｛“name”:"","value":""｝
        List<String> c2_data_province = detailsMapper.get_c2_data_province();
        List<String> c2_data_sum = detailsMapper.get_c2_data_sum();
        int length=c2_data_province.size();
        for (int i=0;i<length;i++){
            HashMap<Object, Object> hashMap = new HashMap<>();
            hashMap.put("name",c2_data_province.get(i));
            hashMap.put("value",c2_data_sum.get(i));
            list.add(hashMap);
        }
        return list;
    }

}
