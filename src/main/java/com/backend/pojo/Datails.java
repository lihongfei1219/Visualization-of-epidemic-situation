package com.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: 李飞飞
 * @Description:
 * @Date: Created in 18:26 2021/4/4
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Datails {
    private int id;
    private String update_time;
    private String province;
    private String city;
    private int confirm;
    private int confirm_add;
    private int heal;
    private int dead;

}
