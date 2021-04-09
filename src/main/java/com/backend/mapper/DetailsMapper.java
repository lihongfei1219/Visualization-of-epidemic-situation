package com.backend.mapper;

import com.backend.pojo.C1Datail;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: 李飞飞
 * @Description:
 * @Date: Created in 19:13 2021/4/4
 */
public interface DetailsMapper {
    @Select("select sum(confirm) as confirm,(select suspect from history order by ds desc limit 1) as suspect,sum(heal) as heal,sum(dead) as dead from details where update_time=(select update_time from details order by update_time desc limit 1);")
    C1Datail get_c1_data();


    @Select("select province from details where update_time=(select update_time from details order by update_time desc limit 1) group by province")
    List<String> get_c2_data_province();
    @Select("select sum(confirm) from details where update_time=(select update_time from details order by update_time desc limit 1) group by province")
    List<String> get_c2_data_sum();
}
