package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.JianliEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JianliView;


/**
 * 简历
 *
 * @author 
 * @email 
 * @date 2024-03-09 22:10:41
 */
public interface JianliService extends IService<JianliEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JianliView> selectListView(Wrapper<JianliEntity> wrapper);
   	
   	JianliView selectView(@Param("ew") Wrapper<JianliEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JianliEntity> wrapper);
   	

}

