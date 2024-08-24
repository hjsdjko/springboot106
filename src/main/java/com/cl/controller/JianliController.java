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

import com.cl.entity.JianliEntity;
import com.cl.entity.view.JianliView;

import com.cl.service.JianliService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 简历
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-09 22:10:41
 */
@RestController
@RequestMapping("/jianli")
public class JianliController {
    @Autowired
    private JianliService jianliService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JianliEntity jianli,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			jianli.setXuehao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<JianliEntity> ew = new EntityWrapper<JianliEntity>();

		PageUtils page = jianliService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jianli), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JianliEntity jianli, 
		HttpServletRequest request){
        EntityWrapper<JianliEntity> ew = new EntityWrapper<JianliEntity>();

		PageUtils page = jianliService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jianli), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JianliEntity jianli){
       	EntityWrapper<JianliEntity> ew = new EntityWrapper<JianliEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jianli, "jianli")); 
        return R.ok().put("data", jianliService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JianliEntity jianli){
        EntityWrapper< JianliEntity> ew = new EntityWrapper< JianliEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jianli, "jianli")); 
		JianliView jianliView =  jianliService.selectView(ew);
		return R.ok("查询简历成功").put("data", jianliView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JianliEntity jianli = jianliService.selectById(id);
		jianli = jianliService.selectView(new EntityWrapper<JianliEntity>().eq("id", id));
        return R.ok().put("data", jianli);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JianliEntity jianli = jianliService.selectById(id);
		jianli = jianliService.selectView(new EntityWrapper<JianliEntity>().eq("id", id));
        return R.ok().put("data", jianli);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JianliEntity jianli, HttpServletRequest request){
    	jianli.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jianli);
        jianliService.insert(jianli);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JianliEntity jianli, HttpServletRequest request){
    	jianli.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jianli);
        jianliService.insert(jianli);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JianliEntity jianli, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jianli);
        jianliService.updateById(jianli);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jianliService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
