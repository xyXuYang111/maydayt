package com.songhaozhi.mayday.model.domain;

import cn.hutool.core.date.DateTime;
import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: xuyang
 * @Date: 2019/11/25 00:39
 * @Description:
 */
@Data
public class Schedule implements Serializable {

    private static final long serialVersionUID = 9221729125717316392L;

    private String scheduleID;

    private String scheduleTitle;

    private String scheduleDesc;

    private String scheduleMessage;

    private String scheduleTip;

    private String scheduleStatus;

    private String scheduleType;

    private String scheduleClassify;

    private String scheduleUrl;

    private String schedulePhoto;

    private Integer useID;

    private DateTime createDate;

    private DateTime updateDate;
}
