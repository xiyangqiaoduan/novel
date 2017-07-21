package com.taototao.novel.controller.admin;

import com.taototao.novel.bean.ReviewSearchBean;
import com.taototao.novel.constant.TaoToTaoConfig;
import com.taototao.novel.constant.TaoToTaoConstants;
import com.taototao.novel.controller.base.AbstractAdminBaseController;
import com.taototao.novel.entity.Review;
import com.taototao.novel.service.ReviewService;
import com.taototao.novel.utils.Pagination;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author yangcb
 * @create 2017-07-21 16:33
 **/
@Controller
@RequestMapping(AbstractAdminBaseController.NAMESPACE)
public class ReviewController extends AbstractAdminBaseController {

    @Autowired
    private ReviewService reviewService;

    @RequestMapping("review/list")
    public String list(Pagination pagination, ModelMap map, String option, String key) {
        logger.debug("评论搜索-------------->pagination={},option={},key={}", pagination, option, key);
        ReviewSearchBean searchBean = new ReviewSearchBean();
        if ("articlename".equals(option)) {
            searchBean.setArticlename(key);
        } else if ("loginid".equals(option)) {
            searchBean.setLoginid(key);
        } else if ("chaptername".equals(option)) {
            searchBean.setChaptername(key);
        }
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
        // 总件数设置
        pagination.setPreperties(reviewService.getCount(searchBean));
        searchBean.setPagination(pagination);
        List<Review> reviewList = reviewService.find(searchBean);
        // Setting number of records in the particular page
        pagination.setPageRecords(reviewList.size());

        if(StringUtils.isNotEmpty(option)){
            map.put("option",option);
        }
        if(StringUtils.isNotEmpty(key)){
            map.put("key",key);
        }
        map.put("pagination", pagination);
        map.put("reviewList", reviewList);
        return "admin/reviewList";
    }

    @RequestMapping("review/del/{reviewno}")
    public String delete(@PathVariable int reviewno) {


        reviewService.deleteByNo(reviewno);

        return "redirect:/admin/review/list";
    }


}
