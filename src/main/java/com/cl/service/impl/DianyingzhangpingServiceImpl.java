package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.DianyingzhangpingDao;
import com.cl.entity.DianyingzhangpingEntity;
import com.cl.service.DianyingzhangpingService;
import com.cl.entity.view.DianyingzhangpingView;

@Service("dianyingzhangpingService")
public class DianyingzhangpingServiceImpl extends ServiceImpl<DianyingzhangpingDao, DianyingzhangpingEntity> implements DianyingzhangpingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DianyingzhangpingEntity> page = this.selectPage(
                new Query<DianyingzhangpingEntity>(params).getPage(),
                new EntityWrapper<DianyingzhangpingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DianyingzhangpingEntity> wrapper) {
		  Page<DianyingzhangpingView> page =new Query<DianyingzhangpingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DianyingzhangpingView> selectListView(Wrapper<DianyingzhangpingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DianyingzhangpingView selectView(Wrapper<DianyingzhangpingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
