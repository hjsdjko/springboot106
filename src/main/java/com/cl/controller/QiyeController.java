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

import com.cl.entity.QiyeEntity;
import com.cl.entity.view.QiyeView;

import com.cl.service.QiyeService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 企业
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-09 22:10:41
 */
@RestController
@RequestMapping("/qiye")
public class QiyeController {
    @Autowired
    private QiyeService qiyeService;



    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		QiyeEntity u = qiyeService.selectOne(new EntityWrapper<QiyeEntity>().eq("qiyezhanghao", username));
        if(u==null || !u.getMima().equals(password)) {
            return R.error("账号或密码不正确");
        }
		String token = tokenService.generateToken(u.getId(), username,"qiye",  "管理员" );
		return R.ok().put("token", token);
	}


	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody QiyeEntity qiye){
    	//ValidatorUtils.validateEntity(qiye);
    	QiyeEntity u = qiyeService.selectOne(new EntityWrapper<QiyeEntity>().eq("qiyezhanghao", qiye.getQiyezhanghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		qiye.setId(uId);
        qiyeService.insert(qiye);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        QiyeEntity u = qiyeService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	QiyeEntity u = qiyeService.selectOne(new EntityWrapper<QiyeEntity>().eq("qiyezhanghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setMima("123456");
        qiyeService.updateById(u);
        return R.ok("密码已重置为：123456");
    }


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,QiyeEntity qiye,
		HttpServletRequest request){
        EntityWrapper<QiyeEntity> ew = new EntityWrapper<QiyeEntity>();

		PageUtils page = qiyeService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qiye), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,QiyeEntity qiye, 
		HttpServletRequest request){
        EntityWrapper<QiyeEntity> ew = new EntityWrapper<QiyeEntity>();

		PageUtils page = qiyeService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qiye), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( QiyeEntity qiye){
       	EntityWrapper<QiyeEntity> ew = new EntityWrapper<QiyeEntity>();
      	ew.allEq(MPUtil.allEQMapPre( qiye, "qiye")); 
        return R.ok().put("data", qiyeService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(QiyeEntity qiye){
        EntityWrapper< QiyeEntity> ew = new EntityWrapper< QiyeEntity>();
 		ew.allEq(MPUtil.allEQMapPre( qiye, "qiye")); 
		QiyeView qiyeView =  qiyeService.selectView(ew);
		return R.ok("查询企业成功").put("data", qiyeView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        QiyeEntity qiye = qiyeService.selectById(id);
		qiye = qiyeService.selectView(new EntityWrapper<QiyeEntity>().eq("id", id));
        return R.ok().put("data", qiye);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        QiyeEntity qiye = qiyeService.selectById(id);
		qiye = qiyeService.selectView(new EntityWrapper<QiyeEntity>().eq("id", id));
        return R.ok().put("data", qiye);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody QiyeEntity qiye, HttpServletRequest request){
    	qiye.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(qiye);
    	QiyeEntity u = qiyeService.selectOne(new EntityWrapper<QiyeEntity>().eq("qiyezhanghao", qiye.getQiyezhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		qiye.setId(new Date().getTime());
        qiyeService.insert(qiye);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody QiyeEntity qiye, HttpServletRequest request){
    	qiye.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(qiye);
    	QiyeEntity u = qiyeService.selectOne(new EntityWrapper<QiyeEntity>().eq("qiyezhanghao", qiye.getQiyezhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		qiye.setId(new Date().getTime());
        qiyeService.insert(qiye);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody QiyeEntity qiye, HttpServletRequest request){
        //ValidatorUtils.validateEntity(qiye);
        qiyeService.updateById(qiye);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        qiyeService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
