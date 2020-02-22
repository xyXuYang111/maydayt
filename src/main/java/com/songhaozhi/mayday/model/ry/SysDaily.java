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
@Document(value = "SysDaily")
public class SysDaily implements Serializable {

    private static final long serialVersionUID = 1092416681922599174L;

    @Id
    private String dailyId;

    private String dailyName;

    private String dailyContent;

    private String weather;

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
