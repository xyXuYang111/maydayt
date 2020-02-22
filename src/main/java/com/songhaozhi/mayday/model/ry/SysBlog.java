package com.songhaozhi.mayday.model.ry;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: xuyang
 * @Date: 2020/1/21 19:33
 * @Description:
 */
@Data
@Document(value = "SysBlog")
public class SysBlog implements Serializable {

    private static final long serialVersionUID = -6727931258275941468L;
    @Id
    private String blogId;

    private String blogTitle;

    private String blogRemark;

    private String blogContent;

    private String blogType;

    private String blogTypeId;

    private String blogUrl;

    private String userId;

    private String ids;

    /** 创建者 */
    private String createBy;

    /** 创建时间 */
    private Date createTime;

    /** 更新者 */
    private String updateBy;

    /** 更新时间 */
    private Date updateTime;

    /** 备注 */
    private String remark;
}
