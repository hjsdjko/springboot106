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


import com.cl.dao.WodeshenqingDao;
import com.cl.entity.WodeshenqingEntity;
import com.cl.service.WodeshenqingService;
import com.cl.entity.view.WodeshenqingView;

@Service("wodeshenqingService")
public class WodeshenqingServiceImpl extends ServiceImpl<WodeshenqingDao, WodeshenqingEntity> implements WodeshenqingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WodeshenqingEntity> page = this.selectPage(
                new Query<WodeshenqingEntity>(params).getPage(),
                new EntityWrapper<WodeshenqingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WodeshenqingEntity> wrapper) {
		  Page<WodeshenqingView> page =new Query<WodeshenqingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<WodeshenqingView> selectListView(Wrapper<WodeshenqingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WodeshenqingView selectView(Wrapper<WodeshenqingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
