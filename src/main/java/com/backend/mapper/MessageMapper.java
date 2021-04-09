package com.backend.mapper;

import com.backend.pojo.Message;
import com.backend.pojo.Number;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: 李飞飞
 * @Description:
 * @Date: Created in 9:52 2021/4/7
 */
public interface MessageMapper {
    @Insert("insert into message(name, phone, privince) values(#{name}, #{phone}, #{privince})")
    void insertMessage(Message message);

    @Select("select confirm from details where province=#{privince} order by confirm desc limit 1")
    Number selectNumber(Message message);
}
