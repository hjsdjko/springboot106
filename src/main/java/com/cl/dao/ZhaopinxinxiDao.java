package com.cl.dao;

import com.cl.entity.ZhaopinxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZhaopinxinxiView;


/**
 * 招聘信息
 * 
 * @author 
 * @email 
 * @date 2024-03-09 22:10:41
 */
public interface ZhaopinxinxiDao extends BaseMapper<ZhaopinxinxiEntity> {
	
	List<ZhaopinxinxiView> selectListView(@Param("ew") Wrapper<ZhaopinxinxiEntity> wrapper);

	List<ZhaopinxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<ZhaopinxinxiEntity> wrapper);
	
	ZhaopinxinxiView selectView(@Param("ew") Wrapper<ZhaopinxinxiEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ZhaopinxinxiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ZhaopinxinxiEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ZhaopinxinxiEntity> wrapper);



}
