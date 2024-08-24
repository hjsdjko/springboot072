package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DianyingzhangpingEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DianyingzhangpingView;


/**
 * 电影长评
 *
 * @author 
 * @email 
 * @date 2024-03-03 19:07:14
 */
public interface DianyingzhangpingService extends IService<DianyingzhangpingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DianyingzhangpingView> selectListView(Wrapper<DianyingzhangpingEntity> wrapper);
   	
   	DianyingzhangpingView selectView(@Param("ew") Wrapper<DianyingzhangpingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DianyingzhangpingEntity> wrapper);
   	

}

