package com.zblog.pojo.operation;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @ClassName Tag
 * @Description TODO
 * @Author zhengdf
 * @Data 2020/5/17 21:31
 * @Version 1.0
 **/
@Data
@ApiModel(value = "Tag对象", description = "标签")
@TableName("tag")
public class Tag implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @NotNull
    @Size(max = 30 , min = 2 ,message = "")
    @ApiModelProperty(value = "标签名字")
    private String name;

    @ApiModelProperty(value = "所属类型：0文章，1阅读")
    private Integer type;
}
