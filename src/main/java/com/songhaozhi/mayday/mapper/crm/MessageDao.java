package com.songhaozhi.mayday.mapper.crm;

import com.songhaozhi.mayday.annotation.MyBatisDao;
import com.songhaozhi.mayday.model.crm.Message;

import java.util.List;

/**
 * @Auther: xuyang
 * @Date: 2019/9/8 13:19
 * @Description:
 */
@MyBatisDao
public interface MessageDao {

    /**
     * 查询单个文件信息
     * @param message
     * @return
     * @throws Exception
     */
    public Message messageInfo(Message message) throws Exception;

    /**
     * 查询多个文件信息
     * @param message
     * @return
     * @throws Exception
     */
    public List<Message> messageList(Message message) throws Exception;

    /**
     * 新增文件信息
     * @param message
     * @return
     * @throws Exception
     */
    public void insertMessage(Message message) throws Exception;

    /**
     * 新增文件信息
     * @param message
     * @return
     * @throws Exception
     */
    public void updateMessage(Message message) throws Exception;

    /**
     * 新增文件信息
     * @param message
     * @return
     * @throws Exception
     */
    public void deleteMessage(Message message) throws Exception;
}
