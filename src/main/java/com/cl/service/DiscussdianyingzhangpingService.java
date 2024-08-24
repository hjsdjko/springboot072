package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DiscussdianyingzhangpingEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussdianyingzhangpingView;


/**
 * 电影长评评论表
 *
 * @author 
 * @email 
 * @date 2024-03-03 19:07:14
 */
public interface DiscussdianyingzhangpingService extends IService<DiscussdianyingzhangpingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussdianyingzhangpingView> selectListView(Wrapper<DiscussdianyingzhangpingEntity> wrapper);
   	
   	DiscussdianyingzhangpingView selectView(@Param("ew") Wrapper<DiscussdianyingzhangpingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussdianyingzhangpingEntity> wrapper);
   	

}

