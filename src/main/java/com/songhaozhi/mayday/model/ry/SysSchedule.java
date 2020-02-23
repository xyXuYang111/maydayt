package com.songhaozhi.mayday.model.ry;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: xuyang
 * @Date: 2020/1/22 22:52
 * @Description:
 */
@Data
@Document(value = "SysSchedule")
public class SysSchedule implements Serializable {

    private static final long serialVersionUID = -5290022225331387376L;

    @Id
    private String scheduleId;

    private String scheduleName;

    private String scheduleDesc;

    private String scheduleType;

    private String scheduleStatus;

    private String hasMessage;

    private String hasValid;

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
