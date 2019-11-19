package com.songhaozhi.mayday.model.crm;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

@Data
@Slf4j
@ToString
public class Files implements Serializable {

    private static final long serialVersionUID = -831903812173794075L;

    private String fileID;

    private String systemName;

    @JsonProperty(value = "fileName")
    private String fileName;

    @JsonProperty(value = "fileByte")
    private String fileByte;

    @JsonProperty(value = "fileNum")
    private String fileNum;

    @JsonProperty(value = "createTime")
    private String createTime;

    @JsonProperty(value = "filePath")
    private String filePath;

    @JsonProperty(value = "fileType")
    private String fileType;

    private MultipartFile multipartFile;
}
