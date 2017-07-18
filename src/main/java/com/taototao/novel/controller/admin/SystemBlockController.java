package com.taototao.novel.controller.admin;

import java.util.List;

import com.taototao.novel.bean.SystemBlockSearchBean;
import com.taototao.novel.constant.TaoToTaoConfig;
import com.taototao.novel.constant.TaoToTaoConstants;
import com.taototao.novel.controller.base.AbstractAdminBaseController;
import com.taototao.novel.entity.SystemBlock;
import com.taototao.novel.service.SystemBlockService;
import com.taototao.novel.utils.Pagination;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 区块管理
 *
 * @author yangcb
 * @create 2017-07-17 17:19
 **/
@Controller
@RequestMapping(AbstractAdminBaseController.NAMESPACE)
public class SystemBlockController extends AbstractAdminBaseController {

    @Autowired
    private SystemBlockService systemBlockService;


    @RequestMapping("systemblock/blockList")
    public String list( Pagination pagination, ModelMap map) {
        logger.debug("block start");
        if(pagination.getPageSize()==0){
            pagination.setPageSize(TaoToTaoConstants.taoToTaoConf.getInt(TaoToTaoConfig.NUMBER_PER_PAGE));
        }
        if(pagination.getPageNumber()==0){
            pagination.setPageNumber(1);
        }
        if (StringUtils.isEmpty(pagination.getSortColumn())) {
            pagination.setSortColumn("blockno");
        }
        SystemBlockSearchBean searchBean = new SystemBlockSearchBean();
        searchBean.setPagination(pagination);
        // 总件数设置
        pagination.setPreperties(systemBlockService.getCount(searchBean));
        List<SystemBlock> blockList = systemBlockService.find(searchBean);
        pagination.setPageRecords(blockList.size());
        map.put("pagination",pagination);
        map.put("blockList",blockList);
        return "admin/blockList";
    }


    @RequestMapping("systemblock/edit/{blockno}")
    public String editPage(@PathVariable("blockno") int blockno,ModelMap map){
        SystemBlock systemBlock=systemBlockService.getByNo(blockno);
        map.put("block",systemBlock);
        return "admin/blockEdit";
    }





}
