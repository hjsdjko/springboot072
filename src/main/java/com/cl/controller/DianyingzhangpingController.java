package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.DianyingzhangpingEntity;
import com.cl.entity.view.DianyingzhangpingView;

import com.cl.service.DianyingzhangpingService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 电影长评
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-03 19:07:14
 */
@RestController
@RequestMapping("/dianyingzhangping")
public class DianyingzhangpingController {
    @Autowired
    private DianyingzhangpingService dianyingzhangpingService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DianyingzhangpingEntity dianyingzhangping,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			dianyingzhangping.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<DianyingzhangpingEntity> ew = new EntityWrapper<DianyingzhangpingEntity>();

		PageUtils page = dianyingzhangpingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dianyingzhangping), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DianyingzhangpingEntity dianyingzhangping, 
		HttpServletRequest request){
        EntityWrapper<DianyingzhangpingEntity> ew = new EntityWrapper<DianyingzhangpingEntity>();

		PageUtils page = dianyingzhangpingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dianyingzhangping), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DianyingzhangpingEntity dianyingzhangping){
       	EntityWrapper<DianyingzhangpingEntity> ew = new EntityWrapper<DianyingzhangpingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( dianyingzhangping, "dianyingzhangping")); 
        return R.ok().put("data", dianyingzhangpingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DianyingzhangpingEntity dianyingzhangping){
        EntityWrapper< DianyingzhangpingEntity> ew = new EntityWrapper< DianyingzhangpingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( dianyingzhangping, "dianyingzhangping")); 
		DianyingzhangpingView dianyingzhangpingView =  dianyingzhangpingService.selectView(ew);
		return R.ok("查询电影长评成功").put("data", dianyingzhangpingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DianyingzhangpingEntity dianyingzhangping = dianyingzhangpingService.selectById(id);
		dianyingzhangping = dianyingzhangpingService.selectView(new EntityWrapper<DianyingzhangpingEntity>().eq("id", id));
        return R.ok().put("data", dianyingzhangping);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DianyingzhangpingEntity dianyingzhangping = dianyingzhangpingService.selectById(id);
		dianyingzhangping = dianyingzhangpingService.selectView(new EntityWrapper<DianyingzhangpingEntity>().eq("id", id));
        return R.ok().put("data", dianyingzhangping);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DianyingzhangpingEntity dianyingzhangping, HttpServletRequest request){
    	dianyingzhangping.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(dianyingzhangping);
        dianyingzhangpingService.insert(dianyingzhangping);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DianyingzhangpingEntity dianyingzhangping, HttpServletRequest request){
    	dianyingzhangping.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(dianyingzhangping);
        dianyingzhangpingService.insert(dianyingzhangping);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DianyingzhangpingEntity dianyingzhangping, HttpServletRequest request){
        //ValidatorUtils.validateEntity(dianyingzhangping);
        dianyingzhangpingService.updateById(dianyingzhangping);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<DianyingzhangpingEntity> list = new ArrayList<DianyingzhangpingEntity>();
        for(Long id : ids) {
            DianyingzhangpingEntity dianyingzhangping = dianyingzhangpingService.selectById(id);
            dianyingzhangping.setSfsh(sfsh);
            dianyingzhangping.setShhf(shhf);
            list.add(dianyingzhangping);
        }
        dianyingzhangpingService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        dianyingzhangpingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
