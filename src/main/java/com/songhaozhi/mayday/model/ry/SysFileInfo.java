package com.songhaozhi.mayday.model.ry;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: xuyang
 * @Date: 2020/1/23 18:41
 * @Description:
 */
@Data
@Document(value = "SysFileInfo")
public class SysFileInfo implements Serializable {

    private static final long serialVersionUID = 3882523920150629261L;

    @Id
    private String fileId;

    private String fileName;

    private String fileTitle;

    private String fileUrl;

    private String typeId;

    private String typeName;

    private String orderNum;

    @JsonProperty(value = "file")
    private MultipartFile file;

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
