package com.cl.entity.view;

import com.cl.entity.DiscussdianyingzhangpingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 电影长评评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-03 19:07:14
 */
@TableName("discussdianyingzhangping")
public class DiscussdianyingzhangpingView  extends DiscussdianyingzhangpingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussdianyingzhangpingView(){
	}
 
 	public DiscussdianyingzhangpingView(DiscussdianyingzhangpingEntity discussdianyingzhangpingEntity){
 	try {
			BeanUtils.copyProperties(this, discussdianyingzhangpingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
