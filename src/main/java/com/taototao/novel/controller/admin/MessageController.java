package com.taototao.novel.controller.admin;

import com.taototao.novel.bean.MessageSearchBean;
import com.taototao.novel.constant.TaoToTaoConfig;
import com.taototao.novel.constant.TaoToTaoConstants;
import com.taototao.novel.controller.base.AbstractAdminBaseController;
import com.taototao.novel.entity.Message;
import com.taototao.novel.service.MessageService;
import com.taototao.novel.utils.Pagination;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author yangcb
 * @create 2017-07-21 15:42
 **/
@Controller
@RequestMapping(AbstractAdminBaseController.NAMESPACE)
public class MessageController extends AbstractAdminBaseController {

    @Autowired
    private MessageService messageService;


    @RequestMapping("message/list")
    public String list(Pagination pagination, ModelMap map) {


        if (pagination.getPageSize() == 0) {
            pagination.setPageSize(TaoToTaoConstants.taoToTaoConf.getInt(TaoToTaoConfig.NUMBER_PER_PAGE));
        }
        if (pagination.getPageNumber() == 0) {
            pagination.setPageNumber(1);
            pagination.setStart(0);
        } else {
            pagination.setStart(pagination.getPageSize() * (pagination.getPageNumber() - 1));
        }
        if (StringUtils.isEmpty(pagination.getSortColumn())) {
            pagination.setSortColumn("postdate");
            pagination.setSortOrder("DESC");
        }

        MessageSearchBean searchBean = new MessageSearchBean();
        pagination.setPreperties(messageService.getCount(searchBean));
        searchBean.setPagination(pagination);

        List<Message> messageList = messageService.find(searchBean);
        pagination.setPageRecords(messageList.size());

        map.put("pagination", pagination);
        map.put("messageList", messageList);

        return "admin/messageList";

    }


    @RequestMapping("message/del/{messageno}")
    public String delete(@PathVariable int messageno) {
        logger.debug("删除消息------------->messageno={}",messageno);
        Message message = new Message();
        message.setMessageno(messageno);
        message.setDeleteflag(true);
        message.setModifyuserno(0);
        message.setModifytime(new Date());

        messageService.deleteByNo(message);


        return "redirect:/admin/message/list";

    }


}
