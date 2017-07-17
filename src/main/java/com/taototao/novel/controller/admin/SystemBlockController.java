package com.taototao.novel.controller.admin;

import com.taototao.novel.bean.SystemBlockSearchBean;
import com.taototao.novel.controller.base.AbstractAdminBaseController;
import com.taototao.novel.service.SystemBlockService;
import com.taototao.novel.utils.Pagination;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *区块管理
 * @author yangcb
 * @create 2017-07-17 17:19
 **/
@Controller
@RequestMapping(AbstractAdminBaseController.NAMESPACE)
public class SystemBlockController extends AbstractAdminBaseController {

    @Autowired
    private SystemBlockService systemBlockService;


    @RequestMapping("systemblock/list")
    public String list( Pagination pagination){
        logger.debug("block start");

        if(StringUtils.isEmpty(pagination.getSortColumn())){
            pagination.setSortColumn("blockno");
        }
        SystemBlockSearchBean searchBean = new SystemBlockSearchBean();
        searchBean.setPagination(pagination);

        // 总件数设置
        pagination.setPreperties(systemBlockService.getCount(searchBean));
//        blockList = systemBlockService.find(searchBean);
//
//        // Setting number of records in the particular page
//        pagination.setPageRecords(blockList.size());



        return "admin/blockList";
    }


}
