package com.taototao.novel.service.impl;

import com.taototao.novel.bean.SystemBlockSearchBean;
import com.taototao.novel.dao.SystemBlockDao;
import com.taototao.novel.entity.SystemBlock;
import com.taototao.novel.service.SystemBlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author yangcb
 * @create 2017-07-17 17:58
 **/
@Service
public class SystemBlockServiceImpl implements SystemBlockService {


    @Autowired
    private SystemBlockDao systemBlockDao;

    public Integer getCount(SystemBlockSearchBean searchBean) {

        return systemBlockDao.getCount(searchBean);
    }

    public List<SystemBlock> find(SystemBlockSearchBean searchBean) {
        return systemBlockDao.find(searchBean);
    }

    public SystemBlock getByNo(int blockNo) {
        return systemBlockDao.getByNo(blockNo);
    }

    public void save(SystemBlock systemBlock) {
        systemBlock.setModifytime(new Date());
        systemBlockDao.save(systemBlock);
    }

    public void update(SystemBlock systemBlock) {
        systemBlock.setModifytime(new Date());
        systemBlockDao.update(systemBlock);
    }
}
