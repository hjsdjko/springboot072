package com.cl.dao;

import com.cl.entity.DiscussdianyingzhangpingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussdianyingzhangpingView;


/**
 * 电影长评评论表
 * 
 * @author 
 * @email 
 * @date 2024-03-03 19:07:14
 */
public interface DiscussdianyingzhangpingDao extends BaseMapper<DiscussdianyingzhangpingEntity> {
	
	List<DiscussdianyingzhangpingView> selectListView(@Param("ew") Wrapper<DiscussdianyingzhangpingEntity> wrapper);

	List<DiscussdianyingzhangpingView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussdianyingzhangpingEntity> wrapper);
	
	DiscussdianyingzhangpingView selectView(@Param("ew") Wrapper<DiscussdianyingzhangpingEntity> wrapper);
	

}
