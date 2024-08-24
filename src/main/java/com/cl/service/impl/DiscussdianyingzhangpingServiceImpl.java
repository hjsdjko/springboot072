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


import com.cl.dao.DiscussdianyingzhangpingDao;
import com.cl.entity.DiscussdianyingzhangpingEntity;
import com.cl.service.DiscussdianyingzhangpingService;
import com.cl.entity.view.DiscussdianyingzhangpingView;

@Service("discussdianyingzhangpingService")
public class DiscussdianyingzhangpingServiceImpl extends ServiceImpl<DiscussdianyingzhangpingDao, DiscussdianyingzhangpingEntity> implements DiscussdianyingzhangpingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussdianyingzhangpingEntity> page = this.selectPage(
                new Query<DiscussdianyingzhangpingEntity>(params).getPage(),
                new EntityWrapper<DiscussdianyingzhangpingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussdianyingzhangpingEntity> wrapper) {
		  Page<DiscussdianyingzhangpingView> page =new Query<DiscussdianyingzhangpingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DiscussdianyingzhangpingView> selectListView(Wrapper<DiscussdianyingzhangpingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussdianyingzhangpingView selectView(Wrapper<DiscussdianyingzhangpingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
