package com.cl.dao;

import com.cl.entity.WodeshenqingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.WodeshenqingView;


/**
 * 我的申请
 * 
 * @author 
 * @email 
 * @date 2024-03-09 22:10:41
 */
public interface WodeshenqingDao extends BaseMapper<WodeshenqingEntity> {
	
	List<WodeshenqingView> selectListView(@Param("ew") Wrapper<WodeshenqingEntity> wrapper);

	List<WodeshenqingView> selectListView(Pagination page,@Param("ew") Wrapper<WodeshenqingEntity> wrapper);
	
	WodeshenqingView selectView(@Param("ew") Wrapper<WodeshenqingEntity> wrapper);
	

}
