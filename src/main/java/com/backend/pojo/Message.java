package com.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: 李飞飞
 * @Description:
 * @Date: Created in 9:31 2021/4/7
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message implements Serializable {
    private String name;
    private String phone;
    private String privince;
}
