package com.backend.mapper;

import com.backend.pojo.History;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: 李飞飞
 * @Description:
 * @Date: Created in 19:13 2021/4/4
 */
public interface HistoryMapper {

    @Select("select ds,confirm,suspect,heal,dead from history")
    List<History> get_data_l1();

    @Select("select ds,confirm_add,suspect_add from history")
    List<History> get_data_l2();

}
