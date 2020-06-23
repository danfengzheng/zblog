package com.zblog.pojo.sys;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.zblog.common.validator.AddGroup;
import com.zblog.common.validator.UpdateGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @ClassName User
 * @Description TODO
 * @Author zhengdf
 * @Data 2020/5/16 17:23
 * @Version 1.0
 **/
@Data
@ApiModel(value = "SysUser对象", description = "用户管理")
public class SysUser implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    @NotBlank(message = "用户名不能为空" , groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "用户名")
    private String username;

    @NotBlank(message = "密码不能为空" ,groups = AddGroup.class)
    @ApiModelProperty(value = "密码")
    private String password;

    @NotBlank(message="邮箱不能为空", groups = {AddGroup.class, UpdateGroup.class})
    @Email(message="邮箱格式不正确", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "创建者Id")
    @TableField(fill = FieldFill.INSERT)
    private Integer createUserId = -1;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime = LocalDateTime.now();

    @ApiModelProperty(value = "0禁用，1正常")
    private Integer status = 1;
}
