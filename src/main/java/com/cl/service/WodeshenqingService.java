package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.WodeshenqingEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.WodeshenqingView;


/**
 * 我的申请
 *
 * @author 
 * @email 
 * @date 2024-03-09 22:10:41
 */
public interface WodeshenqingService extends IService<WodeshenqingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WodeshenqingView> selectListView(Wrapper<WodeshenqingEntity> wrapper);
   	
   	WodeshenqingView selectView(@Param("ew") Wrapper<WodeshenqingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WodeshenqingEntity> wrapper);
   	

}

