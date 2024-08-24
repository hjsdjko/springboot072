package com.cl.dao;

import com.cl.entity.DianyingzhangpingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DianyingzhangpingView;


/**
 * 电影长评
 * 
 * @author 
 * @email 
 * @date 2024-03-03 19:07:14
 */
public interface DianyingzhangpingDao extends BaseMapper<DianyingzhangpingEntity> {
	
	List<DianyingzhangpingView> selectListView(@Param("ew") Wrapper<DianyingzhangpingEntity> wrapper);

	List<DianyingzhangpingView> selectListView(Pagination page,@Param("ew") Wrapper<DianyingzhangpingEntity> wrapper);
	
	DianyingzhangpingView selectView(@Param("ew") Wrapper<DianyingzhangpingEntity> wrapper);
	

}
