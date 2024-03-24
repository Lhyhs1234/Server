package com.example.server.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("pic_table")
public class Pic {
    private int id;
    private String url;
    private int poiId;
}
