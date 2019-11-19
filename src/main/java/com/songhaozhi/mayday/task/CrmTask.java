package com.songhaozhi.mayday.task;

import com.songhaozhi.mayday.model.crm.Message;
import com.songhaozhi.mayday.model.domain.Article;
import com.songhaozhi.mayday.service.ArticleService;
import com.songhaozhi.mayday.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Auther: cypc
 * @Date: 2019/11/19 14:25
 * @Description:
 */
@Component
public class CrmTask {

    @Autowired
    private MessageService messageService;

    @Autowired
    private ArticleService articleService;

    @Scheduled(cron = "0 0 /1 * * ?")
    public void messageTask(){
        try {
            Message message = new Message();
            List<Message> messageList = messageService.messageList(message);

            if(messageList != null){
                for(Message messageLine : messageList){
                    String messageName = messageLine.getMessageName();
                    String messageDes = messageLine.getMessageDes();
                    String messageContent = messageLine.getMessageContent();

                    Article article = new Article();
                    article.setArticleTitle(messageName);
                    article.setArticleSummary(messageDes);
                    article.setArticleContentMd(messageContent);

                    articleService.save(article, null, null);

                    //项目已经废弃：只需要里面的数据
                    messageService.deleteMessage(messageLine);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
