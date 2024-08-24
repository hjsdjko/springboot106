package com.cl.entity.view;

import com.cl.entity.JianliEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 简历
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-09 22:10:41
 */
@TableName("jianli")
public class JianliView  extends JianliEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JianliView(){
	}
 
 	public JianliView(JianliEntity jianliEntity){
 	try {
			BeanUtils.copyProperties(this, jianliEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
