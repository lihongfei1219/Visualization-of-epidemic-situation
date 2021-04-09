package com.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: 李飞飞
 * @Description:
 * @Date: Created in 19:18 2021/4/4
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class History {
    private String ds;
    private int confirm;
    private int confirm_add;
    private int suspect;
    private int suspect_add;
    private int heal;
    private int heal_add;
    private int dead;
    private int dead_add;
}
