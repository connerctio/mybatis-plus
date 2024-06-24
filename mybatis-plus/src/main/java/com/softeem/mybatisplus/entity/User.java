
package com.softeem.mybatisplus.entity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user") // 指定实体类对应的表名
public class User {
    //@TableId(type=IdType.AUTO)// 指定主键类型以及主键生成策略，这里是自增
    //IdType.ASSIGN_ID：使用基于雪花算法的策略生成数据id
    @TableId
    private Long uid;
    private String name;
    private Integer age;
    private String email;

    @TableField(fill = FieldFill.INSERT)// 指定字段自动填充策略,这个是在插入时填充
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)// 指定字段自动填充策略,这个是在插入和更新时填充
    private LocalDateTime updateTime;

    @TableLogic// 指定逻辑删除字段
    @TableField(value = "is_delete")// 指定逻辑删除字段
    private Integer deleted;
}