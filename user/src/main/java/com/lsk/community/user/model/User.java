package com.lsk.community.user.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@TableName("user")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @TableId(type= IdType.AUTO)
    private Integer id;

    private String username;

    private String password;

    private Integer role;

    private Integer like;

    private Integer article;

    private Integer follower;

    private Date joinDate;

    private Integer userLevel;

    private Boolean enabled;

    private String email;

    private Integer avatar;

    private String brief;
}
