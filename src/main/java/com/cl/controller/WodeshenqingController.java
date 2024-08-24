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

import com.cl.entity.WodeshenqingEntity;
import com.cl.entity.view.WodeshenqingView;

import com.cl.service.WodeshenqingService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 我的申请
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-09 22:10:41
 */
@RestController
@RequestMapping("/wodeshenqing")
public class WodeshenqingController {
    @Autowired
    private WodeshenqingService wodeshenqingService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,WodeshenqingEntity wodeshenqing,
		HttpServletRequest request){
    	if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
    		wodeshenqing.setUserid((Long)request.getSession().getAttribute("userId"));
    	}
        EntityWrapper<WodeshenqingEntity> ew = new EntityWrapper<WodeshenqingEntity>();

		PageUtils page = wodeshenqingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, wodeshenqing), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,WodeshenqingEntity wodeshenqing, 
		HttpServletRequest request){
        EntityWrapper<WodeshenqingEntity> ew = new EntityWrapper<WodeshenqingEntity>();

		PageUtils page = wodeshenqingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, wodeshenqing), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( WodeshenqingEntity wodeshenqing){
       	EntityWrapper<WodeshenqingEntity> ew = new EntityWrapper<WodeshenqingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( wodeshenqing, "wodeshenqing")); 
        return R.ok().put("data", wodeshenqingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(WodeshenqingEntity wodeshenqing){
        EntityWrapper< WodeshenqingEntity> ew = new EntityWrapper< WodeshenqingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( wodeshenqing, "wodeshenqing")); 
		WodeshenqingView wodeshenqingView =  wodeshenqingService.selectView(ew);
		return R.ok("查询我的申请成功").put("data", wodeshenqingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        WodeshenqingEntity wodeshenqing = wodeshenqingService.selectById(id);
		wodeshenqing = wodeshenqingService.selectView(new EntityWrapper<WodeshenqingEntity>().eq("id", id));
        return R.ok().put("data", wodeshenqing);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        WodeshenqingEntity wodeshenqing = wodeshenqingService.selectById(id);
		wodeshenqing = wodeshenqingService.selectView(new EntityWrapper<WodeshenqingEntity>().eq("id", id));
        return R.ok().put("data", wodeshenqing);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody WodeshenqingEntity wodeshenqing, HttpServletRequest request){
    	wodeshenqing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(wodeshenqing);
    	wodeshenqing.setUserid((Long)request.getSession().getAttribute("userId"));
        wodeshenqingService.insert(wodeshenqing);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody WodeshenqingEntity wodeshenqing, HttpServletRequest request){
    	wodeshenqing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(wodeshenqing);
        wodeshenqingService.insert(wodeshenqing);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody WodeshenqingEntity wodeshenqing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(wodeshenqing);
        wodeshenqingService.updateById(wodeshenqing);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        wodeshenqingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
