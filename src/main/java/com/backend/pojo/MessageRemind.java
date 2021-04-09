package com.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: 李飞飞
 * @Description:
 * @Date: Created in 22:23 2021/4/7
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageRemind implements Serializable {
    private String privince;
    private String name;
    private String phone;
    private int number;
}
