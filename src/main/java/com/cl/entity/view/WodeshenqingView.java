package com.cl.entity.view;

import com.cl.entity.WodeshenqingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 我的申请
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-09 22:10:41
 */
@TableName("wodeshenqing")
public class WodeshenqingView  extends WodeshenqingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public WodeshenqingView(){
	}
 
 	public WodeshenqingView(WodeshenqingEntity wodeshenqingEntity){
 	try {
			BeanUtils.copyProperties(this, wodeshenqingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
