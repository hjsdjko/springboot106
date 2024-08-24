package com.cl.dao;

import com.cl.entity.JianliEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JianliView;


/**
 * 简历
 * 
 * @author 
 * @email 
 * @date 2024-03-09 22:10:41
 */
public interface JianliDao extends BaseMapper<JianliEntity> {
	
	List<JianliView> selectListView(@Param("ew") Wrapper<JianliEntity> wrapper);

	List<JianliView> selectListView(Pagination page,@Param("ew") Wrapper<JianliEntity> wrapper);
	
	JianliView selectView(@Param("ew") Wrapper<JianliEntity> wrapper);
	

}
